# UBC-IRP APIs Test Cases

This projects contains 3 test cases to test the 'create gist on GitHub' API with content file

API URL [GitHub API](https://api.github.com/gists) to call API.

## Bearer Token
```
Bearer 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
```

## Test Cases

## 1. create a new gist containing a file with the contents "UBC IRP Student QA!"
```
Class - UBCIRPTests
Method - firstTestCase() - This step will validate that gist is created successfully along with the supplied file parameter.
Test will be successful if everything worked as expected otherwise Assert will fail.
Expected status and Code - 201 Created
```
## 2. Assert that creating a new gist the file parameter is in fact required.
```
Class - UBCIRPTests
Method - secondTestCase() - This step will valdiate the file paramter supplied to API or not.
Expected status and Code - 422 Unprocessable Entity
```
## 3. (Pending, required more details on it)Test that the "User Agent" header is required when making a request.
```
Class - UBCIRPTests
Method - thirdTestCase() - This test will valdiate the that 'User-Agent' header is passed or not.
Expected status and Code - 403 Forbidden
```

## Run the suite
Test suite can be run through testNG.xml file directly.
Need to set the "-Dtestng.dtd.http=true" in run configuration VM Options