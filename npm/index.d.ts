declare module '@apiverve/regextester' {
  export interface regextesterOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface regextesterResponse {
    status: string;
    error: string | null;
    data: RegexTesterData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface RegexTesterData {
      pattern:         null | string;
      text:            null | string;
      flags:           null | string;
      testType:        null | string;
      replacement:     null;
      isValidRegex:    boolean | null;
      regexInfo:       RegexInfo;
      testResults:     TestResults;
      performance:     Performance;
      patternAnalysis: PatternAnalysis;
      suggestions:     (null | string)[];
      commonPatterns:  CommonPattern[];
      regexGuide:      RegexGuide;
  }
  
  interface CommonPattern {
      name:        null | string;
      pattern:     null | string;
      description: null | string;
      example:     null | string;
  }
  
  interface PatternAnalysis {
      containsAnchors:          ContainsAnchors;
      containsQuantifiers:      ContainsQuantifiers;
      containsGroups:           ContainsGroups;
      containsCharacterClasses: ContainsCharacterClasses;
      containsSpecialChars:     ContainsSpecialChars;
  }
  
  interface ContainsAnchors {
      startAnchor:  boolean | null;
      endAnchor:    boolean | null;
      wordBoundary: boolean | null;
  }
  
  interface ContainsCharacterClasses {
      predefinedClasses: boolean | null;
      customClasses:     boolean | null;
      negatedClasses:    boolean | null;
  }
  
  interface ContainsGroups {
      capturingGroups:    number | null;
      nonCapturingGroups: number | null;
      namedGroups:        number | null;
  }
  
  interface ContainsQuantifiers {
      zeroOrMore:    boolean | null;
      oneOrMore:     boolean | null;
      zeroOrOne:     boolean | null;
      specificCount: boolean | null;
      rangeCount:    boolean | null;
  }
  
  interface ContainsSpecialChars {
      wildcard:        boolean | null;
      pipe:            boolean | null;
      escapeSequences: number | null;
  }
  
  interface Performance {
      iterations:        number | null;
      totalTimeMS:       number | null;
      averageTimeMS:     number | null;
      performanceRating: null | string;
  }
  
  interface RegexGuide {
      basicSyntax:      BasicSyntax[];
      characterClasses: BasicSyntax[];
      quantifiers:      BasicSyntax[];
      groups:           BasicSyntax[];
      flags:            Flag[];
  }
  
  interface BasicSyntax {
      symbol:      null | string;
      description: null | string;
  }
  
  interface Flag {
      flag:        null | string;
      description: null | string;
  }
  
  interface RegexInfo {
      pattern:       null | string;
      flags:         Flags;
      source:        null | string;
      lastIndex:     number | null;
      patternLength: number | null;
      complexity:    null | string;
  }
  
  interface Flags {
      global:     boolean | null;
      ignoreCase: boolean | null;
      multiline:  boolean | null;
      sticky:     boolean | null;
      unicode:    boolean | null;
      dotAll:     boolean | null;
  }
  
  interface TestResults {
      operation:       null | string;
      result:          boolean | null;
      executionTimeMS: number | null;
      description:     null | string;
  }

  export default class regextesterWrapper {
    constructor(options: regextesterOptions);

    execute(callback: (error: any, data: regextesterResponse | null) => void): Promise<regextesterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: regextesterResponse | null) => void): Promise<regextesterResponse>;
    execute(query?: Record<string, any>): Promise<regextesterResponse>;
  }
}
