/**
 * Regex Tester API - Basic Usage Example
 *
 * This example demonstrates the basic usage of the Regex Tester API.
 * API Documentation: https://docs.apiverve.com/ref/regextester
 */

const API_KEY = process.env.APIVERVE_API_KEY || 'YOUR_API_KEY_HERE';
const API_URL = 'https://api.apiverve.com/v1/regextester';

/**
 * Make a POST request to the Regex Tester API
 */
async function callRegexTesterAPI() {
  try {
    // Request body
    const requestBody &#x3D; {
    &quot;pattern&quot;: &quot;\\d{3}-\\d{2}-\\d{4}&quot;,
    &quot;text&quot;: &quot;My SSN is 123-45-6789 and my friend&#x27;s is 987-65-4321&quot;,
    &quot;flags&quot;: &quot;g&quot;
};

    const response = await fetch(API_URL, {
      method: 'POST',
      headers: {
        'x-api-key': API_KEY,
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(requestBody)
    });

    // Check if response is successful
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json();

    // Check API response status
    if (data.status === 'ok') {
      console.log('✓ Success!');
      console.log('Response data:', data.data);
      return data.data;
    } else {
      console.error('✗ API Error:', data.error || 'Unknown error');
      return null;
    }

  } catch (error) {
    console.error('✗ Request failed:', error.message);
    return null;
  }
}

// Run the example
callRegexTesterAPI()
  .then(result => {
    if (result) {
      console.log('\n📊 Final Result:');
      console.log(JSON.stringify(result, null, 2));
    }
  });
