package au.com.mongodb.test.enums;

/**
 * EventModel namedQueries field names
 *
 */
public enum EvenSearchField {
    ID("_id"),
    ACCOUNT_ID("accountId"),
    REFERENCE_NUMBER("referenceNumber"),
    ACCOUNT_NUMBER("accountNumber"),
    SCHEME_MEMBERSHIP_NUMBER("schemeMembershipNumber");

    private String field;

    private EvenSearchField(final String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
