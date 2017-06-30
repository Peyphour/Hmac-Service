# Hmac-Service
A small Spring boot application to sign and verify data with HMAC

# Build

Run `gradle bootRepackage` in project root. The executable JAR will be in `build/libs/hmac-service-{version}.jar`

# Usage

## Sign data
Send a POST request to `/hmac/sign` containing a JSON body like this: 
```
{
  "body": "test",
  "algorithm": "MD5"
}
```
Example : `curl localhost:8080/hmac/sign -X POST -d '{"body": "test", "algorithm": "MD5"}' -H "Content-Type: application/json"`

Response : `{"body":"test","hash":"ba1ea8001f15f25b97e2e8c358f4a472","algorithm":"MD5"}`

## Verify data

Send a POST request to `/hmac/verify` containing the response from the sign request

Example: `curl localhost:8080/hmac/verify -X POST -d '{"body":"test","hash":"ba1ea8001f15f25b97e2e8c358f4a472","algorithm":"MD5"}' -H "Content-Type: application/json"`

Response : `{"result":true,"body":"test"}`
