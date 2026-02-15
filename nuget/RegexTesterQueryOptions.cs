using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.RegexTester
{
    /// <summary>
    /// Query options for the Regex Tester API
    /// </summary>
    public class RegexTesterQueryOptions
    {
        /// <summary>
        /// The regular expression pattern to test
        /// </summary>
        [JsonProperty("pattern")]
        public string Pattern { get; set; }

        /// <summary>
        /// The text to test the pattern against
        /// </summary>
        [JsonProperty("text")]
        public string Text { get; set; }

        /// <summary>
        /// Regex flags: g (global), i (case insensitive), m (multiline), s (dotall), u (unicode), y (sticky)
        /// </summary>
        [JsonProperty("flags")]
        public string Flags { get; set; }

        /// <summary>
        /// Operation type
        /// </summary>
        [JsonProperty("test_type")]
        public string Test_type { get; set; }

        /// <summary>
        /// Replacement text for 'replace' operation
        /// </summary>
        [JsonProperty("replacement")]
        public string Replacement { get; set; }
    }
}
