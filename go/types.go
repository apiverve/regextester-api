// Package regextester provides a Go client for the Regex Tester API.
//
// For more information, visit: https://apiverve.com/marketplace/regextester?utm_source=go&utm_medium=readme
package regextester

import (
	"fmt"
	"reflect"
	"regexp"
	"strings"
)

// ValidationRule defines validation constraints for a parameter.
type ValidationRule struct {
	Type      string
	Required  bool
	Min       *float64
	Max       *float64
	MinLength *int
	MaxLength *int
	Format    string
	Enum      []string
}

// ValidationError represents a parameter validation error.
type ValidationError struct {
	Errors []string
}

func (e *ValidationError) Error() string {
	return "Validation failed: " + strings.Join(e.Errors, "; ")
}

// Helper functions for pointers
func float64Ptr(v float64) *float64 { return &v }
func intPtr(v int) *int             { return &v }

// Format validation patterns
var formatPatterns = map[string]*regexp.Regexp{
	"email":    regexp.MustCompile(`^[^\s@]+@[^\s@]+\.[^\s@]+$`),
	"url":      regexp.MustCompile(`^https?://.+`),
	"ip":       regexp.MustCompile(`^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$|^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$`),
	"date":     regexp.MustCompile(`^\d{4}-\d{2}-\d{2}$`),
	"hexColor": regexp.MustCompile(`^#?([0-9a-fA-F]{3}|[0-9a-fA-F]{6})$`),
}

// Request contains the parameters for the Regex Tester API.
//
// Parameters:
//   - pattern (required): string - The regular expression pattern to test
//   - text (required): string - The text to test the pattern against
//   - flags: string - Regex flags: g (global), i (case insensitive), m (multiline), s (dotall), u (unicode), y (sticky)
//   - test_type: string - Operation type
//   - replacement: string - Replacement text for 'replace' operation
type Request struct {
	Pattern string `json:"pattern"` // Required
	Text string `json:"text"` // Required
	Flags string `json:"flags,omitempty"` // Optional
}

// ToQueryParams converts the request struct to a map of query parameters.
// Only non-zero values are included.
func (r *Request) ToQueryParams() map[string]string {
	params := make(map[string]string)
	if r == nil {
		return params
	}

	v := reflect.ValueOf(*r)
	t := v.Type()

	for i := 0; i < v.NumField(); i++ {
		field := v.Field(i)
		fieldType := t.Field(i)

		// Get the json tag for the field name
		jsonTag := fieldType.Tag.Get("json")
		if jsonTag == "" {
			continue
		}
		// Handle tags like `json:"name,omitempty"`
		jsonName := strings.Split(jsonTag, ",")[0]
		if jsonName == "-" {
			continue
		}

		// Skip zero values
		if field.IsZero() {
			continue
		}

		// Convert to string
		params[jsonName] = fmt.Sprintf("%v", field.Interface())
	}

	return params
}

// Validate checks the request parameters against validation rules.
// Returns a ValidationError if validation fails, nil otherwise.
func (r *Request) Validate() error {
	rules := map[string]ValidationRule{
		"pattern": {Type: "string", Required: true},
		"text": {Type: "string", Required: true},
		"flags": {Type: "string", Required: false},
		"test_type": {Type: "string", Required: false},
		"replacement": {Type: "string", Required: false},
	}

	if len(rules) == 0 {
		return nil
	}

	var errors []string
	v := reflect.ValueOf(*r)
	t := v.Type()

	for i := 0; i < v.NumField(); i++ {
		field := v.Field(i)
		fieldType := t.Field(i)

		jsonTag := fieldType.Tag.Get("json")
		if jsonTag == "" {
			continue
		}
		jsonName := strings.Split(jsonTag, ",")[0]

		rule, exists := rules[jsonName]
		if !exists {
			continue
		}

		// Check required
		if rule.Required && field.IsZero() {
			errors = append(errors, fmt.Sprintf("Required parameter [%s] is missing", jsonName))
			continue
		}

		if field.IsZero() {
			continue
		}

		// Type-specific validation
		switch rule.Type {
		case "integer", "number":
			var numVal float64
			switch field.Kind() {
			case reflect.Int, reflect.Int64:
				numVal = float64(field.Int())
			case reflect.Float64:
				numVal = field.Float()
			}
			if rule.Min != nil && numVal < *rule.Min {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at least %v", jsonName, *rule.Min))
			}
			if rule.Max != nil && numVal > *rule.Max {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at most %v", jsonName, *rule.Max))
			}

		case "string":
			strVal := field.String()
			if rule.MinLength != nil && len(strVal) < *rule.MinLength {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at least %d characters", jsonName, *rule.MinLength))
			}
			if rule.MaxLength != nil && len(strVal) > *rule.MaxLength {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be at most %d characters", jsonName, *rule.MaxLength))
			}
			if rule.Format != "" {
				if pattern, ok := formatPatterns[rule.Format]; ok {
					if !pattern.MatchString(strVal) {
						errors = append(errors, fmt.Sprintf("Parameter [%s] must be a valid %s", jsonName, rule.Format))
					}
				}
			}
		}

		// Enum validation
		if len(rule.Enum) > 0 {
			strVal := fmt.Sprintf("%v", field.Interface())
			found := false
			for _, enumVal := range rule.Enum {
				if strVal == enumVal {
					found = true
					break
				}
			}
			if !found {
				errors = append(errors, fmt.Sprintf("Parameter [%s] must be one of: %s", jsonName, strings.Join(rule.Enum, ", ")))
			}
		}
	}

	if len(errors) > 0 {
		return &ValidationError{Errors: errors}
	}
	return nil
}

// ResponseData contains the data returned by the Regex Tester API.
type ResponseData struct {
	Pattern string `json:"pattern"`
	Text string `json:"text"`
	Flags string `json:"flags"`
	TestType string `json:"test_type"`
	Replacement interface{} `json:"replacement"`
	IsValidRegex bool `json:"is_valid_regex"`
	RegexInfo RegexInfoData `json:"regex_info"`
	TestResults TestResultsData `json:"test_results"`
	Performance PerformanceData `json:"performance"`
	PatternAnalysis PatternAnalysisData `json:"pattern_analysis"`
	Suggestions []string `json:"suggestions"`
	CommonPatterns []CommonPatternsItem `json:"common_patterns"`
	RegexGuide RegexGuideData `json:"regex_guide"`
}

// RegexInfoData represents the regex_info object.
type RegexInfoData struct {
	Pattern string `json:"pattern"`
	Flags FlagsData `json:"flags"`
	Source string `json:"source"`
	LastIndex int `json:"last_index"`
	PatternLength int `json:"pattern_length"`
	Complexity string `json:"complexity"`
}

// FlagsData represents the flags object.
type FlagsData struct {
	Global bool `json:"global"`
	IgnoreCase bool `json:"ignore_case"`
	Multiline bool `json:"multiline"`
	Sticky bool `json:"sticky"`
	Unicode bool `json:"unicode"`
	DotAll bool `json:"dot_all"`
}

// TestResultsData represents the test_results object.
type TestResultsData struct {
	Operation string `json:"operation"`
	Result bool `json:"result"`
	ExecutionTimeMs int `json:"execution_time_ms"`
	Description string `json:"description"`
}

// PerformanceData represents the performance object.
type PerformanceData struct {
	Iterations int `json:"iterations"`
	TotalTimeMs int `json:"total_time_ms"`
	AverageTimeMs int `json:"average_time_ms"`
	PerformanceRating string `json:"performance_rating"`
}

// PatternAnalysisData represents the pattern_analysis object.
type PatternAnalysisData struct {
	ContainsAnchors ContainsAnchorsData `json:"contains_anchors"`
	ContainsQuantifiers ContainsQuantifiersData `json:"contains_quantifiers"`
	ContainsGroups ContainsGroupsData `json:"contains_groups"`
	ContainsCharacterClasses ContainsCharacterClassesData `json:"contains_character_classes"`
	ContainsSpecialChars ContainsSpecialCharsData `json:"contains_special_chars"`
}

// ContainsAnchorsData represents the contains_anchors object.
type ContainsAnchorsData struct {
	StartAnchor bool `json:"start_anchor"`
	EndAnchor bool `json:"end_anchor"`
	WordBoundary bool `json:"word_boundary"`
}

// ContainsQuantifiersData represents the contains_quantifiers object.
type ContainsQuantifiersData struct {
	ZeroOrMore bool `json:"zero_or_more"`
	OneOrMore bool `json:"one_or_more"`
	ZeroOrOne bool `json:"zero_or_one"`
	SpecificCount bool `json:"specific_count"`
	RangeCount bool `json:"range_count"`
}

// ContainsGroupsData represents the contains_groups object.
type ContainsGroupsData struct {
	CapturingGroups int `json:"capturing_groups"`
	NonCapturingGroups int `json:"non_capturing_groups"`
	NamedGroups int `json:"named_groups"`
}

// ContainsCharacterClassesData represents the contains_character_classes object.
type ContainsCharacterClassesData struct {
	PredefinedClasses bool `json:"predefined_classes"`
	CustomClasses bool `json:"custom_classes"`
	NegatedClasses bool `json:"negated_classes"`
}

// ContainsSpecialCharsData represents the contains_special_chars object.
type ContainsSpecialCharsData struct {
	Wildcard bool `json:"wildcard"`
	Pipe bool `json:"pipe"`
	EscapeSequences int `json:"escape_sequences"`
}

// CommonPatternsItem represents an item in the CommonPatterns array.
type CommonPatternsItem struct {
	Name string `json:"name"`
	Pattern string `json:"pattern"`
	Description string `json:"description"`
	Example string `json:"example"`
}

// RegexGuideData represents the regex_guide object.
type RegexGuideData struct {
	BasicSyntax []BasicSyntaxItem `json:"basic_syntax"`
	CharacterClasses []CharacterClassesItem `json:"character_classes"`
	Quantifiers []QuantifiersItem `json:"quantifiers"`
	Groups []GroupsItem `json:"groups"`
	Flags []FlagsItem `json:"flags"`
}

// BasicSyntaxItem represents an item in the BasicSyntax array.
type BasicSyntaxItem struct {
	Symbol string `json:"symbol"`
	Description string `json:"description"`
}

// CharacterClassesItem represents an item in the CharacterClasses array.
type CharacterClassesItem struct {
	Symbol string `json:"symbol"`
	Description string `json:"description"`
}

// QuantifiersItem represents an item in the Quantifiers array.
type QuantifiersItem struct {
	Symbol string `json:"symbol"`
	Description string `json:"description"`
}

// GroupsItem represents an item in the Groups array.
type GroupsItem struct {
	Symbol string `json:"symbol"`
	Description string `json:"description"`
}

// FlagsItem represents an item in the Flags array.
type FlagsItem struct {
	Flag string `json:"flag"`
	Description string `json:"description"`
}
