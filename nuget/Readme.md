APIVerve.API.RegexTester API
============

Regex Tester is a comprehensive tool for testing and validating regular expressions. It supports multiple operations (test, match, search, replace, split) with detailed performance analysis and pattern suggestions.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a .NET Wrapper for the [APIVerve.API.RegexTester API](https://apiverve.com/marketplace/regextester)

---

## Installation

Using the .NET CLI:
```
dotnet add package APIVerve.API.RegexTester
```

Using the Package Manager:
```
nuget install APIVerve.API.RegexTester
```

Using the Package Manager Console:
```
Install-Package APIVerve.API.RegexTester
```

From within Visual Studio:

1. Open the Solution Explorer
2. Right-click on a project within your solution
3. Click on Manage NuGet Packages
4. Click on the Browse tab and search for "APIVerve.API.RegexTester"
5. Click on the APIVerve.API.RegexTester package, select the appropriate version in the right-tab and click Install

---

## Configuration

Before using the regextester API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Quick Start

Here's a simple example to get you started quickly:

```csharp
using System;
using APIVerve;

class Program
{
    static async Task Main(string[] args)
    {
        // Initialize the API client
        var apiClient = new RegexTesterAPIClient("[YOUR_API_KEY]");

        var queryOptions = new RegexTesterQueryOptions {
  pattern = "\\d{3}-\\d{2}-\\d{4}",
  text = "My SSN is 123-45-6789 and my friend's is 987-65-4321",
  flags = "g"
};

        // Make the API call
        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
            }
            else
            {
                Console.WriteLine("Success!");
                // Access response data using the strongly-typed ResponseObj properties
                Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Exception: {ex.Message}");
        }
    }
}
```

---

## Usage

The APIVerve.API.RegexTester API documentation is found here: [https://docs.apiverve.com/ref/regextester](https://docs.apiverve.com/ref/regextester).
You can find parameters, example responses, and status codes documented here.

### Setup

###### Authentication
APIVerve.API.RegexTester API uses API Key-based authentication. When you create an instance of the API client, you can pass your API Key as a parameter.

```csharp
// Create an instance of the API client
var apiClient = new RegexTesterAPIClient("[YOUR_API_KEY]");
```

---

## Usage Examples

### Basic Usage (Async/Await Pattern - Recommended)

The modern async/await pattern provides the best performance and code readability:

```csharp
using System;
using System.Threading.Tasks;
using APIVerve;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new RegexTesterAPIClient("[YOUR_API_KEY]");

        var queryOptions = new RegexTesterQueryOptions {
  pattern = "\\d{3}-\\d{2}-\\d{4}",
  text = "My SSN is 123-45-6789 and my friend's is 987-65-4321",
  flags = "g"
};

        var response = await apiClient.ExecuteAsync(queryOptions);

        if (response.Error != null)
        {
            Console.WriteLine($"Error: {response.Error}");
        }
        else
        {
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
    }
}
```

### Synchronous Usage

If you need to use synchronous code, you can use the `Execute` method:

```csharp
using System;
using APIVerve;

public class Example
{
    public static void Main(string[] args)
    {
        var apiClient = new RegexTesterAPIClient("[YOUR_API_KEY]");

        var queryOptions = new RegexTesterQueryOptions {
  pattern = "\\d{3}-\\d{2}-\\d{4}",
  text = "My SSN is 123-45-6789 and my friend's is 987-65-4321",
  flags = "g"
};

        var response = apiClient.Execute(queryOptions);

        if (response.Error != null)
        {
            Console.WriteLine($"Error: {response.Error}");
        }
        else
        {
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
    }
}
```

---

## Error Handling

The API client provides comprehensive error handling. Here are some examples:

### Handling API Errors

```csharp
using System;
using System.Threading.Tasks;
using APIVerve;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new RegexTesterAPIClient("[YOUR_API_KEY]");

        var queryOptions = new RegexTesterQueryOptions {
  pattern = "\\d{3}-\\d{2}-\\d{4}",
  text = "My SSN is 123-45-6789 and my friend's is 987-65-4321",
  flags = "g"
};

        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            // Check for API-level errors
            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
                Console.WriteLine($"Status: {response.Status}");
                return;
            }

            // Success - use the data
            Console.WriteLine("Request successful!");
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
        catch (ArgumentException ex)
        {
            // Invalid API key or parameters
            Console.WriteLine($"Invalid argument: {ex.Message}");
        }
        catch (System.Net.Http.HttpRequestException ex)
        {
            // Network or HTTP errors
            Console.WriteLine($"Network error: {ex.Message}");
        }
        catch (Exception ex)
        {
            // Other errors
            Console.WriteLine($"Unexpected error: {ex.Message}");
        }
    }
}
```

### Comprehensive Error Handling with Retry Logic

```csharp
using System;
using System.Threading.Tasks;
using APIVerve;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new RegexTesterAPIClient("[YOUR_API_KEY]");

        // Configure retry behavior (max 3 retries)
        apiClient.SetMaxRetries(3);        // Retry up to 3 times (default: 0, max: 3)
        apiClient.SetRetryDelay(2000);     // Wait 2 seconds between retries

        var queryOptions = new RegexTesterQueryOptions {
  pattern = "\\d{3}-\\d{2}-\\d{4}",
  text = "My SSN is 123-45-6789 and my friend's is 987-65-4321",
  flags = "g"
};

        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
            }
            else
            {
                Console.WriteLine("Success!");
                Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Failed after retries: {ex.Message}");
        }
    }
}
```

---

## Advanced Features

### Custom Headers

Add custom headers to your requests:

```csharp
var apiClient = new RegexTesterAPIClient("[YOUR_API_KEY]");

// Add custom headers
apiClient.AddCustomHeader("X-Custom-Header", "custom-value");
apiClient.AddCustomHeader("X-Request-ID", Guid.NewGuid().ToString());

var queryOptions = new RegexTesterQueryOptions {
  pattern = "\\d{3}-\\d{2}-\\d{4}",
  text = "My SSN is 123-45-6789 and my friend's is 987-65-4321",
  flags = "g"
};

var response = await apiClient.ExecuteAsync(queryOptions);

// Remove a header
apiClient.RemoveCustomHeader("X-Custom-Header");

// Clear all custom headers
apiClient.ClearCustomHeaders();
```

### Request Logging

Enable logging for debugging:

```csharp
var apiClient = new RegexTesterAPIClient("[YOUR_API_KEY]", isDebug: true);

// Or use a custom logger
apiClient.SetLogger(message =>
{
    Console.WriteLine($"[LOG] {DateTime.Now:yyyy-MM-dd HH:mm:ss} - {message}");
});

var queryOptions = new RegexTesterQueryOptions {
  pattern = "\\d{3}-\\d{2}-\\d{4}",
  text = "My SSN is 123-45-6789 and my friend's is 987-65-4321",
  flags = "g"
};

var response = await apiClient.ExecuteAsync(queryOptions);
```

### Retry Configuration

Customize retry behavior for failed requests:

```csharp
var apiClient = new RegexTesterAPIClient("[YOUR_API_KEY]");

// Set retry options
apiClient.SetMaxRetries(3);           // Retry up to 3 times (default: 0, max: 3)
apiClient.SetRetryDelay(1500);        // Wait 1.5 seconds between retries (default: 1000ms)

var queryOptions = new RegexTesterQueryOptions {
  pattern = "\\d{3}-\\d{2}-\\d{4}",
  text = "My SSN is 123-45-6789 and my friend's is 987-65-4321",
  flags = "g"
};

var response = await apiClient.ExecuteAsync(queryOptions);
```

### Dispose Pattern

The API client implements `IDisposable` for proper resource cleanup:

```csharp
using (var apiClient = new RegexTesterAPIClient("[YOUR_API_KEY]"))
{
    var queryOptions = new RegexTesterQueryOptions {
  pattern = "\\d{3}-\\d{2}-\\d{4}",
  text = "My SSN is 123-45-6789 and my friend's is 987-65-4321",
  flags = "g"
};
    var response = await apiClient.ExecuteAsync(queryOptions);
    Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
}
// HttpClient is automatically disposed here
```

---

## Example Response

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
