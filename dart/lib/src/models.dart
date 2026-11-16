/// Response models for the Regex Tester API.

/// API Response wrapper.
class RegextesterResponse {
  final String status;
  final dynamic error;
  final RegextesterData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  RegextesterResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory RegextesterResponse.fromJson(Map<String, dynamic> json) => RegextesterResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? RegextesterData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Regex Tester API.

class RegextesterData {
  String? pattern;
  String? text;
  String? flags;
  String? testType;
  dynamic replacement;
  bool? isValidRegex;
  RegextesterDataRegexInfo? regexInfo;
  RegextesterDataTestResults? testResults;
  RegextesterDataPerformance? performance;
  RegextesterDataPatternAnalysis? patternAnalysis;
  List<String>? suggestions;
  List<RegextesterDataCommonPatternsItem>? commonPatterns;
  RegextesterDataRegexGuide? regexGuide;

  RegextesterData({
    this.pattern,
    this.text,
    this.flags,
    this.testType,
    this.replacement,
    this.isValidRegex,
    this.regexInfo,
    this.testResults,
    this.performance,
    this.patternAnalysis,
    this.suggestions,
    this.commonPatterns,
    this.regexGuide,
  });

  factory RegextesterData.fromJson(Map<String, dynamic> json) => RegextesterData(
      pattern: json['pattern'],
      text: json['text'],
      flags: json['flags'],
      testType: json['test_type'],
      replacement: json['replacement'],
      isValidRegex: json['is_valid_regex'],
      regexInfo: json['regex_info'] != null ? RegextesterDataRegexInfo.fromJson(json['regex_info']) : null,
      testResults: json['test_results'] != null ? RegextesterDataTestResults.fromJson(json['test_results']) : null,
      performance: json['performance'] != null ? RegextesterDataPerformance.fromJson(json['performance']) : null,
      patternAnalysis: json['pattern_analysis'] != null ? RegextesterDataPatternAnalysis.fromJson(json['pattern_analysis']) : null,
      suggestions: (json['suggestions'] as List?)?.cast<String>(),
      commonPatterns: (json['common_patterns'] as List?)?.map((e) => RegextesterDataCommonPatternsItem.fromJson(e)).toList(),
      regexGuide: json['regex_guide'] != null ? RegextesterDataRegexGuide.fromJson(json['regex_guide']) : null,
    );
}

class RegextesterDataRegexInfo {
  String? pattern;
  RegextesterDataRegexInfoFlags? flags;
  String? source;
  num? lastIndex;
  num? patternLength;
  String? complexity;

  RegextesterDataRegexInfo({
    this.pattern,
    this.flags,
    this.source,
    this.lastIndex,
    this.patternLength,
    this.complexity,
  });

  factory RegextesterDataRegexInfo.fromJson(Map<String, dynamic> json) => RegextesterDataRegexInfo(
      pattern: json['pattern'],
      flags: json['flags'] != null ? RegextesterDataRegexInfoFlags.fromJson(json['flags']) : null,
      source: json['source'],
      lastIndex: json['last_index'],
      patternLength: json['pattern_length'],
      complexity: json['complexity'],
    );
}

class RegextesterDataRegexInfoFlags {
  bool? global;
  bool? ignoreCase;
  bool? multiline;
  bool? sticky;
  bool? unicode;
  bool? dotAll;

  RegextesterDataRegexInfoFlags({
    this.global,
    this.ignoreCase,
    this.multiline,
    this.sticky,
    this.unicode,
    this.dotAll,
  });

  factory RegextesterDataRegexInfoFlags.fromJson(Map<String, dynamic> json) => RegextesterDataRegexInfoFlags(
      global: json['global'],
      ignoreCase: json['ignore_case'],
      multiline: json['multiline'],
      sticky: json['sticky'],
      unicode: json['unicode'],
      dotAll: json['dot_all'],
    );
}

class RegextesterDataTestResults {
  String? operation;
  bool? result;
  num? executionTimeMs;
  String? description;

  RegextesterDataTestResults({
    this.operation,
    this.result,
    this.executionTimeMs,
    this.description,
  });

  factory RegextesterDataTestResults.fromJson(Map<String, dynamic> json) => RegextesterDataTestResults(
      operation: json['operation'],
      result: json['result'],
      executionTimeMs: json['execution_time_ms'],
      description: json['description'],
    );
}

class RegextesterDataPerformance {
  num? iterations;
  num? totalTimeMs;
  num? averageTimeMs;
  String? performanceRating;

  RegextesterDataPerformance({
    this.iterations,
    this.totalTimeMs,
    this.averageTimeMs,
    this.performanceRating,
  });

  factory RegextesterDataPerformance.fromJson(Map<String, dynamic> json) => RegextesterDataPerformance(
      iterations: json['iterations'],
      totalTimeMs: json['total_time_ms'],
      averageTimeMs: json['average_time_ms'],
      performanceRating: json['performance_rating'],
    );
}

class RegextesterDataPatternAnalysis {
  RegextesterDataPatternAnalysisContainsAnchors? containsAnchors;
  RegextesterDataPatternAnalysisContainsQuantifiers? containsQuantifiers;
  RegextesterDataPatternAnalysisContainsGroups? containsGroups;
  RegextesterDataPatternAnalysisContainsCharacterClasses? containsCharacterClasses;
  RegextesterDataPatternAnalysisContainsSpecialChars? containsSpecialChars;

  RegextesterDataPatternAnalysis({
    this.containsAnchors,
    this.containsQuantifiers,
    this.containsGroups,
    this.containsCharacterClasses,
    this.containsSpecialChars,
  });

  factory RegextesterDataPatternAnalysis.fromJson(Map<String, dynamic> json) => RegextesterDataPatternAnalysis(
      containsAnchors: json['contains_anchors'] != null ? RegextesterDataPatternAnalysisContainsAnchors.fromJson(json['contains_anchors']) : null,
      containsQuantifiers: json['contains_quantifiers'] != null ? RegextesterDataPatternAnalysisContainsQuantifiers.fromJson(json['contains_quantifiers']) : null,
      containsGroups: json['contains_groups'] != null ? RegextesterDataPatternAnalysisContainsGroups.fromJson(json['contains_groups']) : null,
      containsCharacterClasses: json['contains_character_classes'] != null ? RegextesterDataPatternAnalysisContainsCharacterClasses.fromJson(json['contains_character_classes']) : null,
      containsSpecialChars: json['contains_special_chars'] != null ? RegextesterDataPatternAnalysisContainsSpecialChars.fromJson(json['contains_special_chars']) : null,
    );
}

class RegextesterDataPatternAnalysisContainsAnchors {
  bool? startAnchor;
  bool? endAnchor;
  bool? wordBoundary;

  RegextesterDataPatternAnalysisContainsAnchors({
    this.startAnchor,
    this.endAnchor,
    this.wordBoundary,
  });

  factory RegextesterDataPatternAnalysisContainsAnchors.fromJson(Map<String, dynamic> json) => RegextesterDataPatternAnalysisContainsAnchors(
      startAnchor: json['start_anchor'],
      endAnchor: json['end_anchor'],
      wordBoundary: json['word_boundary'],
    );
}

class RegextesterDataPatternAnalysisContainsQuantifiers {
  bool? zeroOrMore;
  bool? oneOrMore;
  bool? zeroOrOne;
  bool? specificCount;
  bool? rangeCount;

  RegextesterDataPatternAnalysisContainsQuantifiers({
    this.zeroOrMore,
    this.oneOrMore,
    this.zeroOrOne,
    this.specificCount,
    this.rangeCount,
  });

  factory RegextesterDataPatternAnalysisContainsQuantifiers.fromJson(Map<String, dynamic> json) => RegextesterDataPatternAnalysisContainsQuantifiers(
      zeroOrMore: json['zero_or_more'],
      oneOrMore: json['one_or_more'],
      zeroOrOne: json['zero_or_one'],
      specificCount: json['specific_count'],
      rangeCount: json['range_count'],
    );
}

class RegextesterDataPatternAnalysisContainsGroups {
  num? capturingGroups;
  num? nonCapturingGroups;
  num? namedGroups;

  RegextesterDataPatternAnalysisContainsGroups({
    this.capturingGroups,
    this.nonCapturingGroups,
    this.namedGroups,
  });

  factory RegextesterDataPatternAnalysisContainsGroups.fromJson(Map<String, dynamic> json) => RegextesterDataPatternAnalysisContainsGroups(
      capturingGroups: json['capturing_groups'],
      nonCapturingGroups: json['non_capturing_groups'],
      namedGroups: json['named_groups'],
    );
}

class RegextesterDataPatternAnalysisContainsCharacterClasses {
  bool? predefinedClasses;
  bool? customClasses;
  bool? negatedClasses;

  RegextesterDataPatternAnalysisContainsCharacterClasses({
    this.predefinedClasses,
    this.customClasses,
    this.negatedClasses,
  });

  factory RegextesterDataPatternAnalysisContainsCharacterClasses.fromJson(Map<String, dynamic> json) => RegextesterDataPatternAnalysisContainsCharacterClasses(
      predefinedClasses: json['predefined_classes'],
      customClasses: json['custom_classes'],
      negatedClasses: json['negated_classes'],
    );
}

class RegextesterDataPatternAnalysisContainsSpecialChars {
  bool? wildcard;
  bool? pipe;
  num? escapeSequences;

  RegextesterDataPatternAnalysisContainsSpecialChars({
    this.wildcard,
    this.pipe,
    this.escapeSequences,
  });

  factory RegextesterDataPatternAnalysisContainsSpecialChars.fromJson(Map<String, dynamic> json) => RegextesterDataPatternAnalysisContainsSpecialChars(
      wildcard: json['wildcard'],
      pipe: json['pipe'],
      escapeSequences: json['escape_sequences'],
    );
}

class RegextesterDataCommonPatternsItem {
  String? name;
  String? pattern;
  String? description;
  String? example;

  RegextesterDataCommonPatternsItem({
    this.name,
    this.pattern,
    this.description,
    this.example,
  });

  factory RegextesterDataCommonPatternsItem.fromJson(Map<String, dynamic> json) => RegextesterDataCommonPatternsItem(
      name: json['name'],
      pattern: json['pattern'],
      description: json['description'],
      example: json['example'],
    );
}

class RegextesterDataRegexGuide {
  List<RegextesterDataRegexGuideBasicSyntaxItem>? basicSyntax;
  List<RegextesterDataRegexGuideCharacterClassesItem>? characterClasses;
  List<RegextesterDataRegexGuideQuantifiersItem>? quantifiers;
  List<RegextesterDataRegexGuideGroupsItem>? groups;
  List<RegextesterDataRegexGuideFlagsItem>? flags;

  RegextesterDataRegexGuide({
    this.basicSyntax,
    this.characterClasses,
    this.quantifiers,
    this.groups,
    this.flags,
  });

  factory RegextesterDataRegexGuide.fromJson(Map<String, dynamic> json) => RegextesterDataRegexGuide(
      basicSyntax: (json['basic_syntax'] as List?)?.map((e) => RegextesterDataRegexGuideBasicSyntaxItem.fromJson(e)).toList(),
      characterClasses: (json['character_classes'] as List?)?.map((e) => RegextesterDataRegexGuideCharacterClassesItem.fromJson(e)).toList(),
      quantifiers: (json['quantifiers'] as List?)?.map((e) => RegextesterDataRegexGuideQuantifiersItem.fromJson(e)).toList(),
      groups: (json['groups'] as List?)?.map((e) => RegextesterDataRegexGuideGroupsItem.fromJson(e)).toList(),
      flags: (json['flags'] as List?)?.map((e) => RegextesterDataRegexGuideFlagsItem.fromJson(e)).toList(),
    );
}

class RegextesterDataRegexGuideBasicSyntaxItem {
  String? symbol;
  String? description;

  RegextesterDataRegexGuideBasicSyntaxItem({
    this.symbol,
    this.description,
  });

  factory RegextesterDataRegexGuideBasicSyntaxItem.fromJson(Map<String, dynamic> json) => RegextesterDataRegexGuideBasicSyntaxItem(
      symbol: json['symbol'],
      description: json['description'],
    );
}

class RegextesterDataRegexGuideCharacterClassesItem {
  String? symbol;
  String? description;

  RegextesterDataRegexGuideCharacterClassesItem({
    this.symbol,
    this.description,
  });

  factory RegextesterDataRegexGuideCharacterClassesItem.fromJson(Map<String, dynamic> json) => RegextesterDataRegexGuideCharacterClassesItem(
      symbol: json['symbol'],
      description: json['description'],
    );
}

class RegextesterDataRegexGuideQuantifiersItem {
  String? symbol;
  String? description;

  RegextesterDataRegexGuideQuantifiersItem({
    this.symbol,
    this.description,
  });

  factory RegextesterDataRegexGuideQuantifiersItem.fromJson(Map<String, dynamic> json) => RegextesterDataRegexGuideQuantifiersItem(
      symbol: json['symbol'],
      description: json['description'],
    );
}

class RegextesterDataRegexGuideGroupsItem {
  String? symbol;
  String? description;

  RegextesterDataRegexGuideGroupsItem({
    this.symbol,
    this.description,
  });

  factory RegextesterDataRegexGuideGroupsItem.fromJson(Map<String, dynamic> json) => RegextesterDataRegexGuideGroupsItem(
      symbol: json['symbol'],
      description: json['description'],
    );
}

class RegextesterDataRegexGuideFlagsItem {
  String? flag;
  String? description;

  RegextesterDataRegexGuideFlagsItem({
    this.flag,
    this.description,
  });

  factory RegextesterDataRegexGuideFlagsItem.fromJson(Map<String, dynamic> json) => RegextesterDataRegexGuideFlagsItem(
      flag: json['flag'],
      description: json['description'],
    );
}

class RegextesterRequest {
  String pattern;
  String text;
  String? flags;

  RegextesterRequest({
    required this.pattern,
    required this.text,
    this.flags,
  });

  Map<String, dynamic> toJson() => {
      'pattern': pattern,
      'text': text,
      if (flags != null) 'flags': flags,
    };
}
