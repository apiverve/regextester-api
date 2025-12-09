// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     RegexTesterData data = Converter.fromJsonString(jsonString);

package com.apiverve.regextester.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static RegexTesterData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(RegexTesterData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(RegexTesterData.class);
        writer = mapper.writerFor(RegexTesterData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// RegexTesterData.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class RegexTesterData {
    private String pattern;
    private String text;
    private String flags;
    private String testType;
    private Object replacement;
    private boolean isValidRegex;
    private RegexInfo regexInfo;
    private TestResults testResults;
    private Performance performance;
    private PatternAnalysis patternAnalysis;
    private String[] suggestions;
    private CommonPattern[] commonPatterns;
    private RegexGuide regexGuide;

    @JsonProperty("pattern")
    public String getPattern() { return pattern; }
    @JsonProperty("pattern")
    public void setPattern(String value) { this.pattern = value; }

    @JsonProperty("text")
    public String getText() { return text; }
    @JsonProperty("text")
    public void setText(String value) { this.text = value; }

    @JsonProperty("flags")
    public String getFlags() { return flags; }
    @JsonProperty("flags")
    public void setFlags(String value) { this.flags = value; }

    @JsonProperty("test_type")
    public String getTestType() { return testType; }
    @JsonProperty("test_type")
    public void setTestType(String value) { this.testType = value; }

    @JsonProperty("replacement")
    public Object getReplacement() { return replacement; }
    @JsonProperty("replacement")
    public void setReplacement(Object value) { this.replacement = value; }

    @JsonProperty("is_valid_regex")
    public boolean getIsValidRegex() { return isValidRegex; }
    @JsonProperty("is_valid_regex")
    public void setIsValidRegex(boolean value) { this.isValidRegex = value; }

    @JsonProperty("regex_info")
    public RegexInfo getRegexInfo() { return regexInfo; }
    @JsonProperty("regex_info")
    public void setRegexInfo(RegexInfo value) { this.regexInfo = value; }

    @JsonProperty("test_results")
    public TestResults getTestResults() { return testResults; }
    @JsonProperty("test_results")
    public void setTestResults(TestResults value) { this.testResults = value; }

    @JsonProperty("performance")
    public Performance getPerformance() { return performance; }
    @JsonProperty("performance")
    public void setPerformance(Performance value) { this.performance = value; }

    @JsonProperty("pattern_analysis")
    public PatternAnalysis getPatternAnalysis() { return patternAnalysis; }
    @JsonProperty("pattern_analysis")
    public void setPatternAnalysis(PatternAnalysis value) { this.patternAnalysis = value; }

    @JsonProperty("suggestions")
    public String[] getSuggestions() { return suggestions; }
    @JsonProperty("suggestions")
    public void setSuggestions(String[] value) { this.suggestions = value; }

    @JsonProperty("common_patterns")
    public CommonPattern[] getCommonPatterns() { return commonPatterns; }
    @JsonProperty("common_patterns")
    public void setCommonPatterns(CommonPattern[] value) { this.commonPatterns = value; }

    @JsonProperty("regex_guide")
    public RegexGuide getRegexGuide() { return regexGuide; }
    @JsonProperty("regex_guide")
    public void setRegexGuide(RegexGuide value) { this.regexGuide = value; }
}

// CommonPattern.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class CommonPattern {
    private String name;
    private String pattern;
    private String description;
    private String example;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("pattern")
    public String getPattern() { return pattern; }
    @JsonProperty("pattern")
    public void setPattern(String value) { this.pattern = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("example")
    public String getExample() { return example; }
    @JsonProperty("example")
    public void setExample(String value) { this.example = value; }
}

// PatternAnalysis.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class PatternAnalysis {
    private ContainsAnchors containsAnchors;
    private ContainsQuantifiers containsQuantifiers;
    private ContainsGroups containsGroups;
    private ContainsCharacterClasses containsCharacterClasses;
    private ContainsSpecialChars containsSpecialChars;

    @JsonProperty("contains_anchors")
    public ContainsAnchors getContainsAnchors() { return containsAnchors; }
    @JsonProperty("contains_anchors")
    public void setContainsAnchors(ContainsAnchors value) { this.containsAnchors = value; }

    @JsonProperty("contains_quantifiers")
    public ContainsQuantifiers getContainsQuantifiers() { return containsQuantifiers; }
    @JsonProperty("contains_quantifiers")
    public void setContainsQuantifiers(ContainsQuantifiers value) { this.containsQuantifiers = value; }

    @JsonProperty("contains_groups")
    public ContainsGroups getContainsGroups() { return containsGroups; }
    @JsonProperty("contains_groups")
    public void setContainsGroups(ContainsGroups value) { this.containsGroups = value; }

    @JsonProperty("contains_character_classes")
    public ContainsCharacterClasses getContainsCharacterClasses() { return containsCharacterClasses; }
    @JsonProperty("contains_character_classes")
    public void setContainsCharacterClasses(ContainsCharacterClasses value) { this.containsCharacterClasses = value; }

    @JsonProperty("contains_special_chars")
    public ContainsSpecialChars getContainsSpecialChars() { return containsSpecialChars; }
    @JsonProperty("contains_special_chars")
    public void setContainsSpecialChars(ContainsSpecialChars value) { this.containsSpecialChars = value; }
}

// ContainsAnchors.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class ContainsAnchors {
    private boolean startAnchor;
    private boolean endAnchor;
    private boolean wordBoundary;

    @JsonProperty("start_anchor")
    public boolean getStartAnchor() { return startAnchor; }
    @JsonProperty("start_anchor")
    public void setStartAnchor(boolean value) { this.startAnchor = value; }

    @JsonProperty("end_anchor")
    public boolean getEndAnchor() { return endAnchor; }
    @JsonProperty("end_anchor")
    public void setEndAnchor(boolean value) { this.endAnchor = value; }

    @JsonProperty("word_boundary")
    public boolean getWordBoundary() { return wordBoundary; }
    @JsonProperty("word_boundary")
    public void setWordBoundary(boolean value) { this.wordBoundary = value; }
}

// ContainsCharacterClasses.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class ContainsCharacterClasses {
    private boolean predefinedClasses;
    private boolean customClasses;
    private boolean negatedClasses;

    @JsonProperty("predefined_classes")
    public boolean getPredefinedClasses() { return predefinedClasses; }
    @JsonProperty("predefined_classes")
    public void setPredefinedClasses(boolean value) { this.predefinedClasses = value; }

    @JsonProperty("custom_classes")
    public boolean getCustomClasses() { return customClasses; }
    @JsonProperty("custom_classes")
    public void setCustomClasses(boolean value) { this.customClasses = value; }

    @JsonProperty("negated_classes")
    public boolean getNegatedClasses() { return negatedClasses; }
    @JsonProperty("negated_classes")
    public void setNegatedClasses(boolean value) { this.negatedClasses = value; }
}

// ContainsGroups.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class ContainsGroups {
    private long capturingGroups;
    private long nonCapturingGroups;
    private long namedGroups;

    @JsonProperty("capturing_groups")
    public long getCapturingGroups() { return capturingGroups; }
    @JsonProperty("capturing_groups")
    public void setCapturingGroups(long value) { this.capturingGroups = value; }

    @JsonProperty("non_capturing_groups")
    public long getNonCapturingGroups() { return nonCapturingGroups; }
    @JsonProperty("non_capturing_groups")
    public void setNonCapturingGroups(long value) { this.nonCapturingGroups = value; }

    @JsonProperty("named_groups")
    public long getNamedGroups() { return namedGroups; }
    @JsonProperty("named_groups")
    public void setNamedGroups(long value) { this.namedGroups = value; }
}

// ContainsQuantifiers.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class ContainsQuantifiers {
    private boolean zeroOrMore;
    private boolean oneOrMore;
    private boolean zeroOrOne;
    private boolean specificCount;
    private boolean rangeCount;

    @JsonProperty("zero_or_more")
    public boolean getZeroOrMore() { return zeroOrMore; }
    @JsonProperty("zero_or_more")
    public void setZeroOrMore(boolean value) { this.zeroOrMore = value; }

    @JsonProperty("one_or_more")
    public boolean getOneOrMore() { return oneOrMore; }
    @JsonProperty("one_or_more")
    public void setOneOrMore(boolean value) { this.oneOrMore = value; }

    @JsonProperty("zero_or_one")
    public boolean getZeroOrOne() { return zeroOrOne; }
    @JsonProperty("zero_or_one")
    public void setZeroOrOne(boolean value) { this.zeroOrOne = value; }

    @JsonProperty("specific_count")
    public boolean getSpecificCount() { return specificCount; }
    @JsonProperty("specific_count")
    public void setSpecificCount(boolean value) { this.specificCount = value; }

    @JsonProperty("range_count")
    public boolean getRangeCount() { return rangeCount; }
    @JsonProperty("range_count")
    public void setRangeCount(boolean value) { this.rangeCount = value; }
}

// ContainsSpecialChars.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class ContainsSpecialChars {
    private boolean wildcard;
    private boolean pipe;
    private long escapeSequences;

    @JsonProperty("wildcard")
    public boolean getWildcard() { return wildcard; }
    @JsonProperty("wildcard")
    public void setWildcard(boolean value) { this.wildcard = value; }

    @JsonProperty("pipe")
    public boolean getPipe() { return pipe; }
    @JsonProperty("pipe")
    public void setPipe(boolean value) { this.pipe = value; }

    @JsonProperty("escape_sequences")
    public long getEscapeSequences() { return escapeSequences; }
    @JsonProperty("escape_sequences")
    public void setEscapeSequences(long value) { this.escapeSequences = value; }
}

// Performance.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class Performance {
    private long iterations;
    private long totalTimeMS;
    private long averageTimeMS;
    private String performanceRating;

    @JsonProperty("iterations")
    public long getIterations() { return iterations; }
    @JsonProperty("iterations")
    public void setIterations(long value) { this.iterations = value; }

    @JsonProperty("total_time_ms")
    public long getTotalTimeMS() { return totalTimeMS; }
    @JsonProperty("total_time_ms")
    public void setTotalTimeMS(long value) { this.totalTimeMS = value; }

    @JsonProperty("average_time_ms")
    public long getAverageTimeMS() { return averageTimeMS; }
    @JsonProperty("average_time_ms")
    public void setAverageTimeMS(long value) { this.averageTimeMS = value; }

    @JsonProperty("performance_rating")
    public String getPerformanceRating() { return performanceRating; }
    @JsonProperty("performance_rating")
    public void setPerformanceRating(String value) { this.performanceRating = value; }
}

// RegexGuide.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class RegexGuide {
    private BasicSyntax[] basicSyntax;
    private BasicSyntax[] characterClasses;
    private BasicSyntax[] quantifiers;
    private BasicSyntax[] groups;
    private Flag[] flags;

    @JsonProperty("basic_syntax")
    public BasicSyntax[] getBasicSyntax() { return basicSyntax; }
    @JsonProperty("basic_syntax")
    public void setBasicSyntax(BasicSyntax[] value) { this.basicSyntax = value; }

    @JsonProperty("character_classes")
    public BasicSyntax[] getCharacterClasses() { return characterClasses; }
    @JsonProperty("character_classes")
    public void setCharacterClasses(BasicSyntax[] value) { this.characterClasses = value; }

    @JsonProperty("quantifiers")
    public BasicSyntax[] getQuantifiers() { return quantifiers; }
    @JsonProperty("quantifiers")
    public void setQuantifiers(BasicSyntax[] value) { this.quantifiers = value; }

    @JsonProperty("groups")
    public BasicSyntax[] getGroups() { return groups; }
    @JsonProperty("groups")
    public void setGroups(BasicSyntax[] value) { this.groups = value; }

    @JsonProperty("flags")
    public Flag[] getFlags() { return flags; }
    @JsonProperty("flags")
    public void setFlags(Flag[] value) { this.flags = value; }
}

// BasicSyntax.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class BasicSyntax {
    private String symbol;
    private String description;

    @JsonProperty("symbol")
    public String getSymbol() { return symbol; }
    @JsonProperty("symbol")
    public void setSymbol(String value) { this.symbol = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }
}

// Flag.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class Flag {
    private String flag;
    private String description;

    @JsonProperty("flag")
    public String getFlag() { return flag; }
    @JsonProperty("flag")
    public void setFlag(String value) { this.flag = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }
}

// RegexInfo.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class RegexInfo {
    private String pattern;
    private Flags flags;
    private String source;
    private long lastIndex;
    private long patternLength;
    private String complexity;

    @JsonProperty("pattern")
    public String getPattern() { return pattern; }
    @JsonProperty("pattern")
    public void setPattern(String value) { this.pattern = value; }

    @JsonProperty("flags")
    public Flags getFlags() { return flags; }
    @JsonProperty("flags")
    public void setFlags(Flags value) { this.flags = value; }

    @JsonProperty("source")
    public String getSource() { return source; }
    @JsonProperty("source")
    public void setSource(String value) { this.source = value; }

    @JsonProperty("last_index")
    public long getLastIndex() { return lastIndex; }
    @JsonProperty("last_index")
    public void setLastIndex(long value) { this.lastIndex = value; }

    @JsonProperty("pattern_length")
    public long getPatternLength() { return patternLength; }
    @JsonProperty("pattern_length")
    public void setPatternLength(long value) { this.patternLength = value; }

    @JsonProperty("complexity")
    public String getComplexity() { return complexity; }
    @JsonProperty("complexity")
    public void setComplexity(String value) { this.complexity = value; }
}

// Flags.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class Flags {
    private boolean global;
    private boolean ignoreCase;
    private boolean multiline;
    private boolean sticky;
    private boolean unicode;
    private boolean dotAll;

    @JsonProperty("global")
    public boolean getGlobal() { return global; }
    @JsonProperty("global")
    public void setGlobal(boolean value) { this.global = value; }

    @JsonProperty("ignore_case")
    public boolean getIgnoreCase() { return ignoreCase; }
    @JsonProperty("ignore_case")
    public void setIgnoreCase(boolean value) { this.ignoreCase = value; }

    @JsonProperty("multiline")
    public boolean getMultiline() { return multiline; }
    @JsonProperty("multiline")
    public void setMultiline(boolean value) { this.multiline = value; }

    @JsonProperty("sticky")
    public boolean getSticky() { return sticky; }
    @JsonProperty("sticky")
    public void setSticky(boolean value) { this.sticky = value; }

    @JsonProperty("unicode")
    public boolean getUnicode() { return unicode; }
    @JsonProperty("unicode")
    public void setUnicode(boolean value) { this.unicode = value; }

    @JsonProperty("dot_all")
    public boolean getDotAll() { return dotAll; }
    @JsonProperty("dot_all")
    public void setDotAll(boolean value) { this.dotAll = value; }
}

// TestResults.java

package com.apiverve.regextester.data;

import com.fasterxml.jackson.annotation.*;

public class TestResults {
    private String operation;
    private boolean result;
    private long executionTimeMS;
    private String description;

    @JsonProperty("operation")
    public String getOperation() { return operation; }
    @JsonProperty("operation")
    public void setOperation(String value) { this.operation = value; }

    @JsonProperty("result")
    public boolean getResult() { return result; }
    @JsonProperty("result")
    public void setResult(boolean value) { this.result = value; }

    @JsonProperty("execution_time_ms")
    public long getExecutionTimeMS() { return executionTimeMS; }
    @JsonProperty("execution_time_ms")
    public void setExecutionTimeMS(long value) { this.executionTimeMS = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }
}