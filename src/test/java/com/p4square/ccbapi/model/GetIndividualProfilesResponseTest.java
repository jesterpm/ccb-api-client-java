package com.p4square.ccbapi.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for parsing GetIndividualProfilesResponse.
 */
public class GetIndividualProfilesResponseTest extends XmlBinderTestBase {

    /**
     * Assert that all of the fields bind appropriately for a single profile response.
     */
    @Test
    public void testGetIndividualProfilesResponse() throws Exception {
        final GetIndividualProfilesResponse response = parseFile("ccb_individual_profile_response.xml",
                GetIndividualProfilesResponse.class);

        assertNull("Response should not have errors", response.getErrors());
        assertNotNull(response.getIndividuals());
        assertEquals(1, response.getIndividuals().size());

        final IndividualProfile profile = response.getIndividuals().get(0);

        // IDs
        assertEquals(48, profile.getId());
        assertEquals(123, profile.getSyncId());
        assertEquals(456, profile.getOtherId());

        // Family
        assertEquals(36, profile.getFamily().getFamilyId());
        assertEquals("The Bob Family", profile.getFamily().getName());
        assertEquals("https://cdn3.ccbchurch.com/preSTABLE/images/group-default.gif", profile.getFamilyImageUrl());
        assertEquals(FamilyPosition.PRIMARY_CONTACT, profile.getFamilyPosition());
        assertEquals(1, profile.getFamilyMembers().size());

        // Mrs. Bob
        assertEquals(49, profile.getFamilyMembers().get(0).getIndividualReference().getIndividualId());
        assertEquals("Mrs. Bob", profile.getFamilyMembers().get(0).getIndividualReference().getName());
        assertEquals(FamilyPosition.SPOUSE, profile.getFamilyMembers().get(0).getFamilyPosition());

        // Names
        assertEquals("Mr.", profile.getSalutation());
        assertEquals("Larry", profile.getFirstName());
        assertEquals("", profile.getMiddleName());
        assertEquals("Bob", profile.getLastName());
        assertEquals("", profile.getSuffix());
        assertEquals("Larabar", profile.getLegalFirstName());
        assertEquals("Larry Bob", profile.getFullName());

        // Other Attributes
        assertEquals("https://cdn3.ccbchurch.com/preSTABLE/images/profile-default.gif", profile.getImageUrl());
        assertEquals("tsebastian@churchcommunitybuilder.com", profile.getEmail());
        assertEquals("", profile.getAllergies());
        assertEquals(true, profile.isConfirmedNoAllergies());
        assertEquals(Gender.MALE, profile.getGender());
        assertEquals("1990-04-05", profile.getBirthday().toString());
    }
}