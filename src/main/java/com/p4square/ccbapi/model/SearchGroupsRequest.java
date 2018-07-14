package com.p4square.ccbapi.model;

/**
 * SearchGroupsRequest is the set of options for the group_search API.
 */
public class SearchGroupsRequest {
    // Criteria
    private int areaId;
    private int campusId;
    private boolean hasChildcare;
    private int meetingDayId;
    private int meetingTimeId;
    private int departmentId;
    private int groupTypeId;
    private int udfPulldown1ValueId;
    private int udfPulldown2ValueId;
    private int udfPulldown3ValueId;

    // Controls
    private int limitRecordsStart;
    private int limitRecordsPerPage;
    private OrderByCriterion[] orderBy = new OrderByCriterion[0];

    public int getAreaId() {
        return areaId;
    }

    public SearchGroupsRequest withAreaId(int areaId) {
        this.areaId = areaId;
        return this;
    }

    public int getCampusId() {
        return campusId;
    }

    public SearchGroupsRequest withCampusId(int campusId) {
        this.campusId = campusId;
        return this;
    }

    public boolean hasChildcare() {
        return hasChildcare;
    }

    public SearchGroupsRequest withChildcare(boolean hasChildcare) {
        this.hasChildcare = hasChildcare;
        return this;
    }

    public int getMeetingDayId() {
        return meetingDayId;
    }

    public SearchGroupsRequest withMeetingDayId(int meetingDayId) {
        this.meetingDayId = meetingDayId;
        return this;
    }

    public int getMeetingTimeId() {
        return meetingTimeId;
    }

    public SearchGroupsRequest withMeetingTimeId(int meetingTimeId) {
        this.meetingTimeId = meetingTimeId;
        return this;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public SearchGroupsRequest withDepartmentId(int departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public int getGroupTypeId() {
        return groupTypeId;
    }

    public SearchGroupsRequest withGroupTypeId(int groupTypeId) {
        this.groupTypeId = groupTypeId;
        return this;
    }

    public int getUdfPulldown1ValueId() {
        return udfPulldown1ValueId;
    }

    public SearchGroupsRequest withUdfPulldown1ValueId(int udfPulldown1ValueId) {
        this.udfPulldown1ValueId = udfPulldown1ValueId;
        return this;
    }

    public int getUdfPulldown2ValueId() {
        return udfPulldown2ValueId;
    }

    public SearchGroupsRequest withUdfPulldown2ValueId(int udfPulldown2ValueId) {
        this.udfPulldown2ValueId = udfPulldown2ValueId;
        return this;
    }

    public int getUdfPulldown3ValueId() {
        return udfPulldown3ValueId;
    }

    public SearchGroupsRequest withUdfPulldown3ValueId(int udfPulldown3ValueId) {
        this.udfPulldown3ValueId = udfPulldown3ValueId;
        return this;
    }

    public int getLimitRecordsStart() {
        return limitRecordsStart;
    }

    public SearchGroupsRequest withLimitRecordsStart(int limitRecordsStart) {
        this.limitRecordsStart = limitRecordsStart;
        return this;
    }

    public int getLimitRecordsPerPage() {
        return limitRecordsPerPage;
    }

    public SearchGroupsRequest withLimitRecordsPerPage(int limitRecordsPerPage) {
        this.limitRecordsPerPage = limitRecordsPerPage;
        return this;
    }
    
    public OrderByCriterion[] getOrderBy() {
        return orderBy;
    }

    public SearchGroupsRequest withOrderBy(OrderByCriterion[] orderBy) {
        if (orderBy == null) {
            this.orderBy = new OrderByCriterion[0];
        } else if (orderBy.length > 3) {
                throw new IllegalArgumentException("At most 3 orderBy criteria are allowed.");
        } else {
            this.orderBy = orderBy;
        }
        return this;
    }

    public final class OrderByCriterion {
        private SearchGroupsCriteriaFields field;
        private SortOrder order = SortOrder.ASCENDING;

        public SearchGroupsCriteriaFields getField() {
            return field;
        }

        public OrderByCriterion withField(SearchGroupsCriteriaFields field) {
            this.field = field;
            return this;
        }

        public SortOrder getOrder() {
            return order;
        }

        public OrderByCriterion withOrder(SortOrder order) {
            this.order = order;
            return this;
        }
    }
}
