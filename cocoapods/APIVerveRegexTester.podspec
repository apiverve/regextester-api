Pod::Spec.new do |s|
  s.name             = 'APIVerveRegexTester'
  s.version          = '1.2.3'
  s.summary          = 'Regex Tester tests regular expressions against input strings across operations like match, search, replace, and split.'
  s.description      = <<-'DESC'
Regex Tester tests regular expressions against input strings across operations like match, search, replace, and split. It reports compilation validity, syntax error details, execution timing, and structural pattern analysis.

This iOS/macOS SDK provides a convenient way to access the Regex Tester from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/regextester?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/regextester-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveRegexTester/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
