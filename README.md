# User Api Client Library

## Using the client library

Refer to [UserApiAsyncClient](user-api-client/src/main/java/com/ft/membership/userapi/UserApiAsyncClient.java)
for a list of publicly exposed methods that may be used.
 
For an example of how to use the client lib, please refer to 
[UserApiAsyncClientTest](user-api-client-acceptance-tests/src/test/java/com/ft/membership/userapi/UserApiAsyncClientTest.java)

## Developing the client library

### Build and run tests

    mvn clean install -DAPP.ENV=<env var>
    
    Example:
    For running tests against Prod version of user api
    mvn clean install -DAPP.ENV=p
     
    For running tests against Test version of user api
    mvn clean install -DAPP.ENV=t
    

# TODOs

* Make all dependencies publicly available
* Create automated build and release job for the client lib 