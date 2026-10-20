# [Regex Tester API](https://apiverve.com/marketplace/regextester?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)

Regex Tester tests regular expressions against input strings across operations like match, search, replace, and split. It reports compilation validity, syntax error details, execution timing, and structural pattern analysis.

The Regex Tester API provides a simple, reliable way to integrate regex tester functionality into your applications. Built for developers who need production-ready regex tester capabilities without the complexity of building from scratch.

**[View API Details →](https://apiverve.com/marketplace/regextester?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)**

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![API Status](https://img.shields.io/badge/Status-Active-green.svg)](https://apiverve.com/marketplace/regextester?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)
[![Method](https://img.shields.io/badge/Method-POST-blue.svg)](#)
[![Platform](https://img.shields.io/badge/Platform-Multi--Platform-orange.svg)](#installation)

**Available on:**
[![npm](https://img.shields.io/badge/npm-CB3837?style=flat&logo=npm&logoColor=white)](https://www.npmjs.com/package/@apiverve/regextester)
[![NuGet](https://img.shields.io/badge/NuGet-004880?style=flat&logo=nuget&logoColor=white)](https://www.nuget.org/packages/APIVerve.API.RegexTester)
[![PyPI](https://img.shields.io/badge/PyPI-3776AB?style=flat&logo=python&logoColor=white)](https://pypi.org/project/apiverve-regextester/)
[![RubyGems](https://img.shields.io/badge/RubyGems-E9573F?style=flat&logo=rubygems&logoColor=white)](https://rubygems.org/gems/apiverve_regextester)
[![Packagist](https://img.shields.io/badge/Packagist-F28D1A?style=flat&logo=packagist&logoColor=white)](https://packagist.org/packages/apiverve/regextester)
[![Go](https://img.shields.io/badge/Go-00ADD8?style=flat&logo=go&logoColor=white)](#-go)
[![Dart](https://img.shields.io/badge/Dart-0175C2?style=flat&logo=dart&logoColor=white)](https://pub.dev/packages/apiverve_regextester)
[![JitPack](https://img.shields.io/badge/JitPack-2E7D32?style=flat&logo=android&logoColor=white)](#-android-jitpack)

---

## Quick Start

### Using JavaScript

```javascript
async function callRegexTesterAPI() {
    try {
        const requestBody = {
    "pattern": "\\d{3}-\\d{2}-\\d{4}",
    "text": "My SSN is 123-45-6789 and my friend's is 987-65-4321",
    "flags": "g"
};

        const response = await fetch('https://api.apiverve.com/v1/regextester', {
            method: 'POST',
            headers: {
                'x-api-key': 'YOUR_API_KEY_HERE',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        });

        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error('Error:', error);
    }
}

callRegexTesterAPI();
```

### Using cURL

```bash
curl -X POST "https://api.apiverve.com/v1/regextester" \
  -H "x-api-key: YOUR_API_KEY_HERE" \
  -H "Content-Type: application/json" \
  -d '{
    "pattern": "\\d{3}-\\d{2}-\\d{4}",
    "text": "My SSN is 123-45-6789 and my friend'\''s is 987-65-4321",
    "flags": "g"
}'
```

**Get your API key:** [https://apiverve.com](https://apiverve.com)

**📁 For more examples, see the [examples folder](./examples/)**

---

## Installation

Choose your preferred programming language:

### 📦 NPM (JavaScript/Node.js)

```bash
npm install @apiverve/regextester
```

[**View NPM Package →**](https://www.npmjs.com/package/@apiverve/regextester) | [**Package Code →**](./npm/)

---

### 🔷 NuGet (.NET/C#)

```bash
dotnet add package APIVerve.API.RegexTester
```

[**View NuGet Package →**](https://www.nuget.org/packages/APIVerve.API.RegexTester) | [**Package Code →**](./nuget/)

---

### 🐍 Python (PyPI)

```bash
pip install apiverve-regextester
```

[**View PyPI Package →**](https://pypi.org/project/apiverve-regextester/) | [**Package Code →**](./python/)

---

### 💎 Ruby (RubyGems)

```bash
gem install apiverve_regextester
```

[**View RubyGems Package →**](https://rubygems.org/gems/apiverve_regextester) | [**Package Code →**](./ruby/)

---

### 🐘 PHP (Packagist)

```bash
composer require apiverve/regextester
```

[**View Packagist Package →**](https://packagist.org/packages/apiverve/regextester) | [**Package Code →**](./php/)

---

### 🎯 Dart (pub.dev)

```bash
dart pub add apiverve_regextester
```

[**View pub.dev Package →**](https://pub.dev/packages/apiverve_regextester) | [**Package Code →**](./dart/)

---

### 🤖 Android (JitPack)

```gradle
implementation 'com.github.apiverve:regextester-api:1.0.0'
```

[**Package Code →**](./android/)

---

### 🐹 Go

```bash
go get github.com/apiverve/regextester-api/go
```

[**Package Code →**](./go/)

---

## Why Use This API?

| Feature | Benefit |
|---------|---------|
| **Multi-language SDKs** | Native packages for JavaScript, Python, C#, Go, and Android |
| **Simple Integration** | Single API key authentication, consistent response format |
| **Production Ready** | 99.9% uptime SLA, served from 24 global regions |
| **Comprehensive Docs** | Full examples, OpenAPI spec, and dedicated support |

---

## Documentation

- 🏠 **API Home:** [Regex Tester API](https://apiverve.com/marketplace/regextester?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)
- 📚 **API Reference:** [docs.apiverve.com/ref/regextester](https://docs.apiverve.com/ref/regextester)
- 📖 **OpenAPI Spec:** [openapi.yaml](./openapi.yaml)
- 💡 **Examples:** [examples/](./examples/)

---

## What Can You Build?

The Regex Tester API is commonly used for:

- **Web Applications** - Add regex tester features to your frontend or backend
- **Mobile Apps** - Native SDKs for Android development
- **Automation** - Integrate with n8n, Zapier, or custom workflows
- **SaaS Products** - Enhance your product with regex tester capabilities
- **Data Pipelines** - Process and analyze data at scale

---

## API Reference

### Authentication
All requests require an API key in the header:
```
x-api-key: YOUR_API_KEY_HERE
```

Get your API key: [https://apiverve.com](https://apiverve.com)

### Response Format

Every APIVerve endpoint returns the same envelope — check `status`, then read `data`:

```json
{
  "status": "ok",
  "error": null,
  "data": { ... }
}
```

### Example Response

A real response from the Regex Tester API:

```json
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

## Support & Community

- 🏠 **API Home**: [Regex Tester API](https://apiverve.com/marketplace/regextester?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)
- 💬 **Support**: [https://apiverve.com/contact](https://apiverve.com/contact)
- 🐛 **Issues**: [GitHub Issues](../../issues)
- 📖 **Documentation**: [https://docs.apiverve.com](https://docs.apiverve.com)
- 🌐 **Website**: [https://apiverve.com](https://apiverve.com)

---

## Contributing

We welcome contributions! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

---

## Security

For security concerns, please review our [Security Policy](SECURITY.md).

---

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

Built with ❤️ by [APIVerve](https://apiverve.com)

Copyright © 2026 APIVerve. All rights reserved.
