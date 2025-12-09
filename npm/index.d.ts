declare module '@apiverve/regextester' {
  export interface regextesterOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface regextesterResponse {
    status: string;
    error: string | null;
    data: RegexTesterData;
    code?: number;
  }


  interface RegexTesterData {
      pattern:         string;
      text:            string;
      flags:           string;
      testType:        string;
      replacement:     null;
      isValidRegex:    boolean;
      regexInfo:       RegexInfo;
      testResults:     TestResults;
      performance:     Performance;
      patternAnalysis: PatternAnalysis;
      suggestions:     string[];
      commonPatterns:  CommonPattern[];
      regexGuide:      RegexGuide;
  }
  
  interface CommonPattern {
      name:        string;
      pattern:     string;
      description: string;
      example:     string;
  }
  
  interface PatternAnalysis {
      containsAnchors:          ContainsAnchors;
      containsQuantifiers:      ContainsQuantifiers;
      containsGroups:           ContainsGroups;
      containsCharacterClasses: ContainsCharacterClasses;
      containsSpecialChars:     ContainsSpecialChars;
  }
  
  interface ContainsAnchors {
      startAnchor:  boolean;
      endAnchor:    boolean;
      wordBoundary: boolean;
  }
  
  interface ContainsCharacterClasses {
      predefinedClasses: boolean;
      customClasses:     boolean;
      negatedClasses:    boolean;
  }
  
  interface ContainsGroups {
      capturingGroups:    number;
      nonCapturingGroups: number;
      namedGroups:        number;
  }
  
  interface ContainsQuantifiers {
      zeroOrMore:    boolean;
      oneOrMore:     boolean;
      zeroOrOne:     boolean;
      specificCount: boolean;
      rangeCount:    boolean;
  }
  
  interface ContainsSpecialChars {
      wildcard:        boolean;
      pipe:            boolean;
      escapeSequences: number;
  }
  
  interface Performance {
      iterations:        number;
      totalTimeMS:       number;
      averageTimeMS:     number;
      performanceRating: string;
  }
  
  interface RegexGuide {
      basicSyntax:      BasicSyntax[];
      characterClasses: BasicSyntax[];
      quantifiers:      BasicSyntax[];
      groups:           BasicSyntax[];
      flags:            Flag[];
  }
  
  interface BasicSyntax {
      symbol:      string;
      description: string;
  }
  
  interface Flag {
      flag:        string;
      description: string;
  }
  
  interface RegexInfo {
      pattern:       string;
      flags:         Flags;
      source:        string;
      lastIndex:     number;
      patternLength: number;
      complexity:    string;
  }
  
  interface Flags {
      global:     boolean;
      ignoreCase: boolean;
      multiline:  boolean;
      sticky:     boolean;
      unicode:    boolean;
      dotAll:     boolean;
  }
  
  interface TestResults {
      operation:       string;
      result:          boolean;
      executionTimeMS: number;
      description:     string;
  }

  export default class regextesterWrapper {
    constructor(options: regextesterOptions);

    execute(callback: (error: any, data: regextesterResponse | null) => void): Promise<regextesterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: regextesterResponse | null) => void): Promise<regextesterResponse>;
    execute(query?: Record<string, any>): Promise<regextesterResponse>;
  }
}
