package com.ft.membership.userapi.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ft.membership.common.types.address.Address;
import com.ft.membership.common.types.demographic.Demographics;
import com.ft.membership.common.types.email.Email;
import com.ft.membership.common.types.firstname.FirstName;
import com.ft.membership.common.types.lastname.LastName;
import com.ft.membership.common.types.marketing.MarketingPreferences;
import com.ft.membership.common.types.telephone.Telephone;
import com.ft.membership.common.types.userid.UserId;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {

    private final UserId userId;

    private final Email email;

    private final FirstName firstName;

    private final Title title;

    private final LastName lastName;

    private final Telephone primaryTelephone;

    private final Address homeAddress;

    private final MarketingPreferences marketing;

    private final Demographics demographics;

    @JsonCreator
    public UserProfile(@JsonProperty("id") UserId userId,
                       @JsonProperty("email") Email email,
                       @JsonProperty("title") Title title,
                       @JsonProperty("firstName") FirstName firstName,
                       @JsonProperty("lastName") LastName lastName,
                       @JsonProperty("primaryTelephone") Telephone primaryTelephone,
                       @JsonProperty("homeAddress") Address homeAddress,
                       @JsonProperty("marketing") MarketingPreferences marketing,
                       @JsonProperty("demographics") Demographics demographics) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.title = title;

        this.lastName = lastName;
        this.primaryTelephone = primaryTelephone;
        this.homeAddress = homeAddress;
        this.marketing = marketing;
        this.demographics = demographics;
    }

    public UserId getUserId() {
        return userId;
    }

    public Email getEmail() {
        return email;
    }

    public FirstName getFirstName() {
        return firstName;
    }

    public Title getTitle() {
        return title;
    }

    public LastName getLastName() {
        return lastName;
    }

    public Telephone getPrimaryTelephone() {
        return primaryTelephone;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public MarketingPreferences getMarketing() {
        return marketing;
    }

    public Demographics getDemographics() {
        return demographics;
    }
}
