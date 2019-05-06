package au.com.mongodb.enums;

/**
 * EventModel namedQueries field names
 *
 */
public enum EventSearchField {
    ID("_id"),
    ACCOUNT_ID("accountId"),
    REFERENCE_NUMBER("referenceNumber"),
    ACCOUNT_NUMBER("accountNumber"),
    SCHEME_MEMBERSHIP_NUMBER("schemeMembershipNumber");

    private String field;

    private EventSearchField(final String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
