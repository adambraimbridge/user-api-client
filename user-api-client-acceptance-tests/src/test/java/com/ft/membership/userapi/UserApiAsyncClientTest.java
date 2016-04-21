package com.ft.membership.userapi;

import com.ft.aim.client.ErrorResponseException;
import com.ft.membership.common.types.email.Email;
import com.ft.membership.userapi.domain.UserProfileCollection;
import com.ft.membership.userapi.testsupport.TestConfig;
import me.atam.atam4j.configuration.ConfigLoader;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserApiAsyncClientTest {

    private static TestConfig config;

    public UserApiAsyncClientTest() {
        config = new ConfigLoader<>(TestConfig.class, "p.yml").getTestConfig();
    }

    @Test
    public void testGetUserProfileByValidEmailReturnsStatus200AndUserId() throws Exception {

        UserApiAsyncClient client = new UserApiAsyncClient(config.getApiKey());

        UserProfileCollection items = client
                .getUserProfileByEmail(new Email(config.getTestRegisteredUser1Email()), Optional.empty())
                .exceptionally(throwable -> {

                    if(throwable.getCause().getClass().equals(ErrorResponseException.class)) {
                        ErrorResponseException errorResponseException = (ErrorResponseException) throwable.getCause();
                        try {
                            errorResponseException.getResponse().getResponseBody();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        throwable.printStackTrace();
                    }
                    return null;
                })
                .get();

        assertNotNull(items);
        assertEquals(
                "UserId returned by the api doesn't match expected value",
                config.getTestRegisteredUser1UserId(),
                items.getUserProfiles().get(0).getUserId().toString());
    }
}