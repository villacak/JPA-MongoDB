package au.com.mongodb.test.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;


public class EventModel implements Serializable {


    private String primaryKey;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String accountID;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String refNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String accNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String scheme;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String schemeMembershipNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dateRequested;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String effectiveDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String processedDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double totalAmount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String paymentType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String redemptionType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String benefitReason;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String rolloverInstitution;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String feeType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String contribuitionType;

    private SystemMetadataModel medatadata;



    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(final String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(final String accountID) {
        this.accountID = accountID;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(final String refNumber) {
        this.refNumber = refNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(final String accNumber) {
        this.accNumber = accNumber;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(final String scheme) {
        this.scheme = scheme;
    }

    public String getSchemeMembershipNumber() {
        return schemeMembershipNumber;
    }

    public void setSchemeMembershipNumber(final String schemeMembershipNumber) {
        this.schemeMembershipNumber = schemeMembershipNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(final String dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(final String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(final String processedDate) {
        this.processedDate = processedDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(final double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(final String paymentType) {
        this.paymentType = paymentType;
    }

    public String getRedemptionType() {
        return redemptionType;
    }

    public void setRedemptionType(final String redemptionType) {
        this.redemptionType = redemptionType;
    }

    public String getBenefitReason() {
        return benefitReason;
    }

    public void setBenefitReason(final String benefitReason) {
        this.benefitReason = benefitReason;
    }

    public String getRolloverInstitution() {
        return rolloverInstitution;
    }

    public void setRolloverInstitution(final String rolloverInstitution) {
        this.rolloverInstitution = rolloverInstitution;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(final String feeType) {
        this.feeType = feeType;
    }

    public String getContribuitionType() {
        return contribuitionType;
    }

    public void setContribuitionType(final String contribuitionType) {
        this.contribuitionType = contribuitionType;
    }

    public SystemMetadataModel getMedatadata() {
        return medatadata;
    }

    public void setMedatadata(final SystemMetadataModel medatadata) {
        this.medatadata = medatadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventModel)) return false;
        EventModel model = (EventModel) o;
        return Double.compare(model.totalAmount, totalAmount) == 0 &&
                primaryKey.equals(model.primaryKey) &&
                Objects.equals(accountID, model.accountID) &&
                Objects.equals(refNumber, model.refNumber) &&
                Objects.equals(accNumber, model.accNumber) &&
                Objects.equals(scheme, model.scheme) &&
                Objects.equals(schemeMembershipNumber, model.schemeMembershipNumber) &&
                Objects.equals(type, model.type) &&
                Objects.equals(dateRequested, model.dateRequested) &&
                Objects.equals(effectiveDate, model.effectiveDate) &&
                Objects.equals(processedDate, model.processedDate) &&
                Objects.equals(description, model.description) &&
                Objects.equals(status, model.status) &&
                Objects.equals(paymentType, model.paymentType) &&
                Objects.equals(redemptionType, model.redemptionType) &&
                Objects.equals(benefitReason, model.benefitReason) &&
                Objects.equals(rolloverInstitution, model.rolloverInstitution) &&
                Objects.equals(feeType, model.feeType) &&
                Objects.equals(contribuitionType, model.contribuitionType) &&
                Objects.equals(medatadata, model.medatadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryKey, accountID, refNumber, accNumber, scheme, schemeMembershipNumber, type, dateRequested, effectiveDate, processedDate, totalAmount, description, status, paymentType, redemptionType, benefitReason, rolloverInstitution, feeType, contribuitionType, medatadata);
    }


    public String toJSON() {
        final ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (IOException ioe) {
            json = null;
        }
        return json;
    }
}
