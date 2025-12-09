Regex Tester API
============

Regex Tester is a comprehensive tool for testing and validating regular expressions. It supports multiple operations (test, match, search, replace, split) with detailed performance analysis and pattern suggestions.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [Regex Tester API](https://apiverve.com/marketplace/api/regextester)

---

## Installation
	pip install apiverve-regextester

---

## Configuration

Before using the regextester API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Regex Tester API documentation is found here: [https://docs.apiverve.com/api/regextester](https://docs.apiverve.com/api/regextester).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
# Import the client module
from apiverve_regextester.apiClient import RegextesterAPIClient

# Initialize the client with your APIVerve API key
api = RegextesterAPIClient("[YOUR_API_KEY]")
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
query = { "pattern": "\\d{3}-\\d{2}-\\d{4}", "text": "My SSN is 123-45-6789 and my friend's is 987-65-4321", "flags": "g" }
```

###### Simple Request

```
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```
{
  "status": "ok",
  "error": null,
  "data": {
    "pattern": "\\d{3}-\\d{2}-\\d{4}",
    "text": "My SSN is 123-45-6789 and my friend's is 987-65-4321",
    "flags": "g",
    "test_type": "test",
    "replacement": null,
    "is_valid_regex": true,
    "regex_info": {
      "pattern": "\\d{3}-\\d{2}-\\d{4}",
      "flags": {
        "global": true,
        "ignore_case": false,
        "multiline": false,
        "sticky": false,
        "unicode": false,
        "dot_all": false
      },
      "source": "\\d{3}-\\d{2}-\\d{4}",
      "last_index": 21,
      "pattern_length": 17,
      "complexity": "Medium"
    },
    "test_results": {
      "operation": "test",
      "result": true,
      "execution_time_ms": 0,
      "description": "Returns true if pattern matches anywhere in text, false otherwise"
    },
    "performance": {
      "iterations": 192,
      "total_time_ms": 0,
      "average_time_ms": 0,
      "performance_rating": "Excellent"
    },
    "pattern_analysis": {
      "contains_anchors": {
        "start_anchor": false,
        "end_anchor": false,
        "word_boundary": false
      },
      "contains_quantifiers": {
        "zero_or_more": false,
        "one_or_more": false,
        "zero_or_one": false,
        "specific_count": true,
        "range_count": false
      },
      "contains_groups": {
        "capturing_groups": 0,
        "non_capturing_groups": 0,
        "named_groups": 0
      },
      "contains_character_classes": {
        "predefined_classes": true,
        "custom_classes": false,
        "negated_classes": false
      },
      "contains_special_chars": {
        "wildcard": false,
        "pipe": false,
        "escape_sequences": 3
      }
    },
    "suggestions": [
      "Consider anchoring with ^ or $ if you need exact matches"
    ],
    "common_patterns": [
      {
        "name": "Email Address",
        "pattern": "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$",
        "description": "Matches valid email addresses",
        "example": "user@example.com"
      },
      {
        "name": "Phone Number (US)",
        "pattern": "^\\(?(\\d{3})\\)?[-.\\s]?(\\d{3})[-.\\s]?(\\d{4})$",
        "description": "Matches US phone numbers in various formats",
        "example": "(123) 456-7890"
      },
      {
        "name": "URL",
        "pattern": "^https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)$",
        "description": "Matches HTTP and HTTPS URLs",
        "example": "https://www.example.com"
      },
      {
        "name": "IP Address (IPv4)",
        "pattern": "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$",
        "description": "Matches valid IPv4 addresses",
        "example": "192.168.1.1"
      },
      {
        "name": "Credit Card Number",
        "pattern": "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13}|3[0-9]{13}|6(?:011|5[0-9]{2})[0-9]{12})$",
        "description": "Matches major credit card formats",
        "example": "4532123456789012"
      },
      {
        "name": "Social Security Number",
        "pattern": "^\\d{3}-?\\d{2}-?\\d{4}$",
        "description": "Matches SSN with or without dashes",
        "example": "123-45-6789"
      },
      {
        "name": "Date (MM/DD/YYYY)",
        "pattern": "^(0[1-9]|1[0-2])\\/(0[1-9]|[12][0-9]|3[01])\\/(19|20)\\d{2}$",
        "description": "Matches MM/DD/YYYY date format",
        "example": "12/31/2023"
      },
      {
        "name": "Time (24-hour)",
        "pattern": "^([01]?[0-9]|2[0-3]):[0-5][0-9]$",
        "description": "Matches 24-hour time format",
        "example": "14:30"
      },
      {
        "name": "Hexadecimal Color",
        "pattern": "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$",
        "description": "Matches hex color codes",
        "example": "#FF5733"
      },
      {
        "name": "Strong Password",
        "pattern": "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        "description": "At least 8 chars with uppercase, lowercase, digit, and special char",
        "example": "MyP@ssw0rd"
      }
    ],
    "regex_guide": {
      "basic_syntax": [
        {
          "symbol": ".",
          "description": "Matches any single character except newline"
        },
        {
          "symbol": "*",
          "description": "Matches 0 or more of the preceding character"
        },
        {
          "symbol": "+",
          "description": "Matches 1 or more of the preceding character"
        },
        {
          "symbol": "?",
          "description": "Matches 0 or 1 of the preceding character"
        },
        {
          "symbol": "^",
          "description": "Matches start of string"
        },
        {
          "symbol": "$",
          "description": "Matches end of string"
        },
        {
          "symbol": "|",
          "description": "OR operator"
        },
        {
          "symbol": "\\",
          "description": "Escape character"
        }
      ],
      "character_classes": [
        {
          "symbol": "[abc]",
          "description": "Matches any character in the set"
        },
        {
          "symbol": "[^abc]",
          "description": "Matches any character NOT in the set"
        },
        {
          "symbol": "[a-z]",
          "description": "Matches any lowercase letter"
        },
        {
          "symbol": "[A-Z]",
          "description": "Matches any uppercase letter"
        },
        {
          "symbol": "[0-9]",
          "description": "Matches any digit"
        },
        {
          "symbol": "\\d",
          "description": "Matches any digit (equivalent to [0-9])"
        },
        {
          "symbol": "\\w",
          "description": "Matches any word character [a-zA-Z0-9_]"
        },
        {
          "symbol": "\\s",
          "description": "Matches any whitespace character"
        }
      ],
      "quantifiers": [
        {
          "symbol": "{n}",
          "description": "Matches exactly n times"
        },
        {
          "symbol": "{n,}",
          "description": "Matches n or more times"
        },
        {
          "symbol": "{n,m}",
          "description": "Matches between n and m times"
        },
        {
          "symbol": "*?",
          "description": "Non-greedy: matches 0 or more (lazy)"
        },
        {
          "symbol": "+?",
          "description": "Non-greedy: matches 1 or more (lazy)"
        },
        {
          "symbol": "??",
          "description": "Non-greedy: matches 0 or 1 (lazy)"
        }
      ],
      "groups": [
        {
          "symbol": "(abc)",
          "description": "Capturing group"
        },
        {
          "symbol": "(?:abc)",
          "description": "Non-capturing group"
        },
        {
          "symbol": "(?<name>abc)",
          "description": "Named capturing group"
        },
        {
          "symbol": "(?=abc)",
          "description": "Positive lookahead"
        },
        {
          "symbol": "(?!abc)",
          "description": "Negative lookahead"
        },
        {
          "symbol": "(?<=abc)",
          "description": "Positive lookbehind"
        },
        {
          "symbol": "(?<!abc)",
          "description": "Negative lookbehind"
        }
      ],
      "flags": [
        {
          "flag": "g",
          "description": "Global - find all matches"
        },
        {
          "flag": "i",
          "description": "Case insensitive"
        },
        {
          "flag": "m",
          "description": "Multiline - ^ and $ match line breaks"
        },
        {
          "flag": "s",
          "description": "Dot matches newline characters"
        },
        {
          "flag": "u",
          "description": "Unicode mode"
        },
        {
          "flag": "y",
          "description": "Sticky - matches from lastIndex position"
        }
      ]
    }
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.