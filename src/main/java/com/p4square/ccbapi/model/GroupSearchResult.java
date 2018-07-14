package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.NONE)
public class GroupSearchResult {

    @XmlElement(name="id")
    private int id;

    @XmlElement(name="name")
    private String name;

    @XmlElement(name="group_type_name")
    private String groupTypeName;

    @XmlElement(name="grouping_name")
    private String departmentName;

    @XmlElement(name="area_name")
    @XmlJavaTypeAdapter(CCBIDReference.Adapter.class)
    private Reference area;

    @XmlElement(name="meet_day_name")
    private String meetingDayName;

    @XmlElement(name="meet_time_name")
    private String meetingTimeName;

    @XmlElement(name="description")
    private String description;

    /**
     * This attribute is undefined in the CCB docs. I suspect that it is
     * the negative {@link GroupProfile#isActive()} attribute, but since
     * "Group must be active" to be included in the search results, I
     * have no way to confirm.
     *
     * I'm leaving this field inaccessible until it can be confirmed.
     */
    @XmlElement(name="status_id")
    private int statusId;

    @XmlElement(name="messaging_type")
    @XmlJavaTypeAdapter(InteractionTypeAdapter.class)
    private InteractionType interactionType;

    @XmlElement(name="membership_type")
    @XmlJavaTypeAdapter(MembershipTypeAdapter.class)
    private MembershipType membershipType;

    @XmlElement(name="owner_name")
    @XmlJavaTypeAdapter(CCBIDReference.Adapter.class)
    private Reference mainLeader;

    @XmlElement(name="owner_email_primary")
    private String mainLeaderEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupTypeName() {
        return groupTypeName;
    }

    public void setGroupTypeName(String groupTypeName) {
        this.groupTypeName = groupTypeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Reference getArea() {
        return area;
    }

    public void setArea(Reference area) {
        this.area = area;
    }

    public String getMeetingDayName() {
        return meetingDayName;
    }

    public void setMeetingDayName(String meetingDayName) {
        this.meetingDayName = meetingDayName;
    }

    public String getMeetingTimeName() {
        return meetingTimeName;
    }

    public void setMeetingTimeName(String meetingTimeName) {
        this.meetingTimeName = meetingTimeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InteractionType getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(InteractionType interactionType) {
        this.interactionType = interactionType;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public Reference getMainLeader() {
        return mainLeader;
    }

    public void setMainLeader(Reference mainLeader) {
        this.mainLeader = mainLeader;
    }

    public String getMainLeaderEmail() {
        return mainLeaderEmail;
    }

    public void setMainLeaderEmail(String mainLeaderEmail) {
        this.mainLeaderEmail = mainLeaderEmail;
    }

    /**
     * GroupProfile and GroupSearchResult use different serializations of the InteractionType enumeration.
     */
    private static final class InteractionTypeAdapter extends XmlAdapter<String, InteractionType> {
        @Override
        public InteractionType unmarshal(String s) throws Exception {
            switch (s) {
                case "Interact":
                    return InteractionType.MEMBERS_INTERACT;
                case "Announce":
                    return InteractionType.ANNOUNCEMENT_ONLY;
                default:
                    throw new IllegalArgumentException("Unknown InteractionType string '" + s + "'");
            }
        }

        @Override
        public String marshal(InteractionType membershipType) throws Exception {
            switch (membershipType) {
                case MEMBERS_INTERACT:
                    return "Interact";
                case ANNOUNCEMENT_ONLY:
                    return "Announce";
                case ADMINISTRATIVE:
                    throw new UnsupportedOperationException("InteractionType.ADMINISTRATIVE not allowed in search.");
                default:
                    throw new UnsupportedOperationException("No support for " + membershipType);
            }
        }
    }

    /**
     * GroupProfile and GroupSearchResult use different serializations of the MembershipType enumeration.
     */
    private static final class MembershipTypeAdapter extends XmlAdapter<String, MembershipType> {
        @Override
        public MembershipType unmarshal(String s) throws Exception {
            switch (s) {
                case "Request":
                    return MembershipType.MODERATED;
                case "Open":
                    return MembershipType.OPEN;
                default:
                    throw new IllegalArgumentException("Unknown MembershipType string '" + s + "'");
            }
        }

        @Override
        public String marshal(MembershipType membershipType) throws Exception {
            switch (membershipType) {
                case MODERATED:
                    return "Request";
                case OPEN:
                    return "Open";
                default:
                    throw new UnsupportedOperationException("No support for " + membershipType);
            }
        }
    }

}
