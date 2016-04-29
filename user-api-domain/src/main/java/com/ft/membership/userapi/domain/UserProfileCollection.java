package com.ft.membership.userapi.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserProfileCollection {

    private final List<UserProfile> userProfiles;

    @JsonCreator
    public UserProfileCollection(@JsonProperty("items") final List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }
}
