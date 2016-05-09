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
    
### Releasing the client library

Changes pushed to master branch are automatically built and pushed to FT's nexus server by the [user-api-client-lib build job](http://aim-build.in.ft.com/job/user-api-client).

Releasing the client lib versions to maven central, so that it is publicly available will be done in due course.

# TODOs

* Make all dependencies publicly available
* Release to maven central.
