package com.p4square.ccbapi.model;

/**
 * GetLookupTableRequest contains the information necessary to get a list of lookup table values.
 */
public class GetLookupTableRequest {

    private LookupTableType type;

    public LookupTableType getType() {
        return type;
    }

    /**
     * Specify the type of lookup table to query.
     *
     * @param type A non-null lookup table type.
     * @return this
     */
    public GetLookupTableRequest withType(final LookupTableType type) {
        if (type == null) {
            throw new IllegalArgumentException("type may not be null.");
        }
        this.type = type;
        return this;
    }
}
