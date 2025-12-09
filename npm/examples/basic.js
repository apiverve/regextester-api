/**
 * Basic Example - Regex Tester API
 *
 * This example demonstrates how to use the Regex Tester API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const regextesterAPI = require('../index.js');

// Initialize the API client
const api = new regextesterAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  "pattern": "\\d{3}-\\d{2}-\\d{4}",
  "text": "My SSN is 123-45-6789 and my friend's is 987-65-4321",
  "flags": "g"
};

// Make the API request using callback
console.log('Making request to Regex Tester API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});
