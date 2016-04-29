package com.ft.membership.userapi;

import com.ft.aim.client.ErrorResponseException;
import com.ft.membership.common.types.email.Email;
import com.ft.membership.userapi.domain.UserProfile;
import com.ft.membership.userapi.domain.UserProfileCollection;
import com.ft.membership.userapi.testsupport.TestConfig;
import me.atam.atam4j.configuration.ConfigLoader;
import org.junit.AfterClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserApiAsyncClientTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApiAsyncClientTest.class);
    private static TestConfig config;
    private static UserApiAsyncClient client;

    public UserApiAsyncClientTest() throws MalformedURLException {
        String appEnv = System.getProperty("APP.ENV");
        String fileName = "p.yml";
        if (appEnv != null) {
            fileName = appEnv.concat(".yml");
        }
        config = new ConfigLoader<>(TestConfig.class, fileName).getTestConfig();
        client = new UserApiAsyncClient(new URL(config.getApiBaseUrl()), config.getApiKey());
    }

    @Test
    public void testGetUserProfileByValidEmailValidUserId() throws Exception {

        UserProfileCollection items = null;

        try {
             items = client
                     .getUserProfileByEmail(new Email(config.getTestRegisteredUser1Email()), Optional.empty())
                     .get();
        } catch(Exception e) {
            if(e.getCause().getClass().equals(ErrorResponseException.class)) {
                ErrorResponseException errorResponseException = (ErrorResponseException) e.getCause();
                LOGGER.error(
                        "Error response code {} returned by user-api",
                        errorResponseException.getResponse().getStatusCode());
                LOGGER.error(errorResponseException.getResponse().getResponseBody());
            } else {
                LOGGER.error(e.getMessage(), e);
            }
        }

        assertNotNull(items);
        assertEquals(
                "UserId returned by the api doesn't match expected value",
                config.getTestRegisteredUser1UserId(),
                items.getUserProfiles().get(0).getUserId().toString());
    }

    @Test
    public void testGetUserProfileByInvalidEmailShouldReturnEmptyListInResponse() throws Exception {

        Email invalidEmail = new Email("invalidemail1@example.com");
        List<UserProfile> userProfiles = client
                .getUserProfileByEmail(invalidEmail, Optional.empty())
                .get()
                .getUserProfiles();

        assertEquals("Number of user profiles returned should be 0", 0, userProfiles.size());
    }

    @AfterClass
    public static void tearDown() throws Exception {

        client.close();
    }
}