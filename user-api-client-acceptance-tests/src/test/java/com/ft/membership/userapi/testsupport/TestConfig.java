package com.ft.membership.userapi.testsupport;

public class TestConfig {

    private String apiKey;
    private String testRegisteredUser1Email;
    private String testRegisteredUser1UserId;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(final String apiKey) {
        this.apiKey = apiKey;
    }

    public String getTestRegisteredUser1Email() {
        return testRegisteredUser1Email;
    }

    public void setTestRegisteredUser1Email(final String testRegisteredUser1Email) {
        this.testRegisteredUser1Email = testRegisteredUser1Email;
    }

    public String getTestRegisteredUser1UserId() {
        return testRegisteredUser1UserId;
    }

    public void setTestRegisteredUser1UserId(final String testRegisteredUser1UserId) {
        this.testRegisteredUser1UserId = testRegisteredUser1UserId;
    }
}
