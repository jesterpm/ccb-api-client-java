package com.p4square.ccbapi.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchGroupsResponseTest extends XmlBinderTestBase {

    /**
     * Assert that all of the fields bind appropriately for a single profile response.
     */
    @Test
    public void testGetGroupProfilesResponse() throws Exception {
        final SearchGroupsResponse response = parseFile("ccb_group_search_response.xml",
                SearchGroupsResponse.class);

        assertNull("Response should not have errors", response.getErrors());
        assertNotNull(response.getResults());
        assertEquals(1, response.getResults().size());

        final GroupSearchResult group = response.getResults().get(0);

        // IDs
        assertEquals(750, group.getId());

        assertEquals("Adamant by Lisa Bevere Book Study", group.getName());
        assertTrue(group.getDescription().startsWith("What is the truth?"));

        // Main Leader
        assertReferenceEquals(26102, "Jane Doe", group.getMainLeader());
        assertEquals("jane.doe@example.com", group.getMainLeaderEmail());

        // Attributes
        assertEquals(InteractionType.MEMBERS_INTERACT, group.getInteractionType());
        assertEquals(MembershipType.MODERATED, group.getMembershipType());

        // Reference Attributes
        assertEquals("Tuesday", group.getMeetingDayName());
        assertEquals("7:00 pm", group.getMeetingTimeName());
        assertEquals("Community", group.getGroupTypeName());
        assertEquals("Adults", group.getDepartmentName());
        assertReferenceEquals(18, "Puyallup", group.getArea());
    }

    private void assertReferenceEquals(int id, String name, Reference ref) {
        assertEquals(id, ref.getId());
        assertEquals(name, ref.getName());
    }

}