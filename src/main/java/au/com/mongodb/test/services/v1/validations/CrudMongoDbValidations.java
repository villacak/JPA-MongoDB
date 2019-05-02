package au.com.mongodb.test.services.v1.validations;

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
        boolean isAccountIdValid = validateMandatoryStrings(model.getAccountID());
        boolean isReferenceNumberValid = validateMandatoryStrings(model.getRefNumber());
        boolean isAccountNumberValid = validateMandatoryStrings(model.getAccNumber());
        boolean isSchemeMembershipNumberValid = validateMandatoryStrings(model.getSchemeMembershipNumber());

        boolean areValid = isAccountIdValid && isReferenceNumberValid && isAccountNumberValid && isSchemeMembershipNumberValid;
        return areValid;
    }


    private boolean validateMandatoryStrings(final String value) {
        final boolean isValid;
        if (value != null && !value.equals(EMPTY)) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }
}
