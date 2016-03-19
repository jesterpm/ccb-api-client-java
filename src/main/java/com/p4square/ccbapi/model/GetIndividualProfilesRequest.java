package com.p4square.ccbapi.model;

import java.time.LocalDate;

/**
 * GetIndividualProfilesRequest is the set of options for retrieving individual profiles.
 */
public class GetIndividualProfilesRequest {

    // Used with individual_profiles
    private LocalDate modifiedSince;
    private Boolean includeInactive;
    private int page;
    private int perPage;

    // Used with individual_profile_from_id
    private int id;

    // Used with individual_profile_from_login_password
    private String login;
    private String password;

    // Used with individual_profile_from_micr
    private String routingNumber;
    private String accountNumber;

    public int getId() {
        return id;
    }

    /**
     * Request the IndividualProfile for the given individual id.
     *
     * This option is mutually exclusive with {@link #withLoginPassword(String, String)}
     * and {@link #withMICR(String, String)}.
     *
     * @param id The id.
     * @return this.
     */
    public GetIndividualProfilesRequest withIndividualId(final int id) {
        this.id = id;
        this.login = this.password = this.accountNumber = this.routingNumber = null;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Request the IndividualProfile for the given login and password.
     *
     * This option is mutually exclusive with {@link #withIndividualId(int)}
     * and {@link #withMICR(String, String)}.
     *
     * @param login The individual's login.
     * @param password The individual's password.
     * @return this.
     */
    public GetIndividualProfilesRequest withLoginPassword(final String login, final String password) {
        this.login = login;
        this.password = password;
        this.id = 0;
        this.accountNumber = this.routingNumber = null;
        return this;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Request the IndividualProfile for the given bank account information.
     *
     * This option is mutually exclusive with {@link #withIndividualId(int)}
     * and {@link #withLoginPassword(String, String)}.
     *
     * @param routingNumber The individual's bank routing number.
     * @param accountNumber The individual's bank account number.
     * @return this.
     */
    public GetIndividualProfilesRequest withMICR(final String routingNumber, final String accountNumber) {
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        return this;
    }

    public LocalDate getModifiedSince() {
        return modifiedSince;
    }

    /**
     * Request only IndividualProfiles modified since a given date.
     *
     * This option is only applicable when requesting all individuals.
     *
     * @param modifiedSince The date.
     * @return this.
     */
    public GetIndividualProfilesRequest withModifiedSince(final LocalDate modifiedSince) {
        this.modifiedSince = modifiedSince;
        return this;
    }

    public Boolean getIncludeInactive() {
        return includeInactive;
    }

    public GetIndividualProfilesRequest withIncludeInactive(final boolean includeInactive) {
        this.includeInactive = includeInactive;
        return this;
    }

    public int getPage() {
        return page;
    }

    /**
     * Select the page of results when perPage is also specified.
     *
     * This option is only applicable when requesting all individuals.
     *
     * Defaults to 1 if {@link #withPerPage(int)} is specified on the request.
     *
     * @param page The starting page number.
     * @return this.
     */
    public GetIndividualProfilesRequest withPage(final int page) {
        this.page = page;
        return this;
    }

    public int getPerPage() {
        return perPage;
    }

    /**
     * Limit the number of IndividualProfiles returned.
     *
     * This option is only applicable when requesting all individuals.
     *
     * Defaults to 25 if {@link #withPage(int)} is specified on the request.
     *
     * @param perPage The maximum number to return.
     * @return this.
     */
    public GetIndividualProfilesRequest withPerPage(int perPage) {
        this.perPage = perPage;
        return this;
    }
}
