package au.com.mongodb.test.services.v1.validations;

import au.com.mongodb.test.enums.EventSearchField;
import au.com.mongodb.test.model.EventModel;

public class CrudMongoDbValidations {

    private final String EMPTY = "";

    public boolean validateEventModelInsert(final EventModel model) {
        final boolean isValid;
        if (model != null && (model.getAccountID() != null || model.getAccountID().equals(EMPTY))) {
            isValid = validateModelMandatoryFields(model);
        } else {
            isValid = false;
        }
        return isValid;
    }


    private boolean validateModelMandatoryFields(final EventModel model) {
        boolean isAccountIdValid = validateMandatoryString(model.getAccountID());
        boolean isReferenceNumberValid = validateMandatoryString(model.getRefNumber());
        boolean isAccountNumberValid = validateMandatoryString(model.getAccNumber());
        boolean isSchemeMembershipNumberValid = validateMandatoryString(model.getSchemeMembershipNumber());

        boolean areValid = isAccountIdValid && isReferenceNumberValid && isAccountNumberValid && isSchemeMembershipNumberValid;
        return areValid;
    }


    public boolean validateMandatoryString(final String value) {
        final boolean isValid;
        if (value != null && !value.equals(EMPTY)) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }


    public EventSearchField getSearchFieldEnum(final String field) {
        EventSearchField toReturn = null;
        final EventSearchField[] fields = EventSearchField.values();
        for(EventSearchField tempField: fields) {
            if (tempField.getField().equalsIgnoreCase(field)) {
                toReturn = tempField;
                break;
            }
        }
        return toReturn;
    }

}
