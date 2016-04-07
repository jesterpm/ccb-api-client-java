package com.p4square.ccbapi.model;

/**
 * A collection of lookup table types supported by CCB.
 */
public enum LookupTableType {
    ABILITY,
    ACTIVITY,
    AGE_BRACKET,
    AREA,
    CHURCH_SERVICE,
    DEPARTMENT,
    EVENT_GROUPING,
    GIFT,
    GROUP_GROUPING,
    GROUP_TYPE,
    HOW_JOINED_CHURCH,
    HOW_THEY_HEARD,
    MEET_DAY,
    MEET_TIME,
    MEMBERSHIP_TYPE,
    PASSION,
    REASON_LEFT_CHURCH,
    SCHOOL,
    SCHOOL_GRADE,
    SIGNIFICANT_EVENT,
    SPIRITUAL_MATURITY,
    STYLE,
    TRANSACTION_GROUPING,
    UDF_GRP_PULLDOWN_1,
    UDF_GRP_PULLDOWN_2,
    UDF_GRP_PULLDOWN_3,
    UDF_IND_PULLDOWN_1,
    UDF_IND_PULLDOWN_2,
    UDF_IND_PULLDOWN_3,
    UDF_IND_PULLDOWN_4,
    UDF_IND_PULLDOWN_5,
    UDF_IND_PULLDOWN_6,
    UDF_RESOURCE_PULLDOWN_1;

    /**
     * @return the identifier used by the CCB API.
     */
    public String getIdentifier() {
        return toString().toLowerCase();
    }
}
