package com.ft.membership.userapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ft.aim.client.Client;
import com.ft.aim.client.Entities;
import com.ft.aim.client.HeaderBuilder;
import com.ft.aim.client.JacksonJsonResponseMapper;
import com.ft.aim.client.Method;
import com.ft.membership.common.types.email.Email;
import com.ft.membership.userapi.domain.UserProfileCollection;
import com.ning.http.client.AsyncHttpClient;

import java.net.URL;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class UserApiAsyncClient {

    private static final String API_KEY_HEADER_NAME = "X-Api-Key";
    private static final String TRANSACTION_ID_HEADER_NAME = "X-Request-Id";

    private final String USER_API_SEARCH_USER_BY_EMAIL_ENDPOINT;
    private final String API_KEY;

    public UserApiAsyncClient(URL apiBaseUrl, String apiKey) {
        API_KEY = apiKey;
        USER_API_SEARCH_USER_BY_EMAIL_ENDPOINT = apiBaseUrl+"/users?email=%s";
    }

    public CompletableFuture<UserProfileCollection> getUserProfileByEmail(
            Email emailAddress,
            Optional<String> transactionId) {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        Client client = new Client(asyncHttpClient);

        return client.request(
                Method.GET,
                String.format(USER_API_SEARCH_USER_BY_EMAIL_ENDPOINT, emailAddress),
                Entities.noBody(),
                HeaderBuilder.headers()
                        .with(API_KEY_HEADER_NAME, API_KEY)
                        .with(TRANSACTION_ID_HEADER_NAME, transactionId.orElse(UUID.randomUUID().toString()))
                        .build(),
                JacksonJsonResponseMapper.asObject(new TypeReference<UserProfileCollection>() {})
        );
    }
}
