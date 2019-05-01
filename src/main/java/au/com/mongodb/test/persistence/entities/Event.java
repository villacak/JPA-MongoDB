package au.com.mongodb.test.persistence.entities;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NoSql(dataFormat = DataFormatType.MAPPED)
@NamedQueries({
        @NamedQuery(name = "event.findById", query = "SELECT e FROM Event e WHERE e._id = :id"),
        @NamedQuery(name = "event.findByAccountId", query = "SELECT e FROM Event e WHERE e.accountId = :accountId"),
        @NamedQuery(name = "event.findByReferenceNumber", query = "SELECT e FROM Event e WHERE e.referenceNumber = :referenceNumber"),
        @NamedQuery(name = "event.findByAccountNumber", query = "SELECT e FROM Event e WHERE e.accountNumber = :accountNumber"),
        @NamedQuery(name = "event.findBySchemeMembershipNumber", query = "SELECT e FROM Event e WHERE e.schemeMembershipNumber = :schemeMembershipNumber")
})
public class Event implements Serializable {

    @Id
    @GeneratedValue
    @Field(name = "_id")
    private String _id;

    @Basic
    private String accountId;

    @Basic

    private String referenceNumber;

    @Basic
    private String accountNumber;

    @Basic
    private String scheme;

    @Basic
    private String schemeMembershipNumber;

    @Basic
    private String type;

    @Basic
    private String dateRequested;

    @Basic
    private String effectiveDate;

    @Basic
    private String processedDate;

    @Basic
    private double totalAmount;

    @Basic
    private String description;

    @Basic
    private String status;

    @Basic
    private String paymentType;

    @Basic
    private String redemptionType;

    @Basic
    private String benefitReason;

    @Basic
    private String rolloverInstitution;

    @Basic
    private String feeType;

    @Basic
    private String contribuitionType;

    @Embedded
    private au.com.mongodb.test.persistence.entities.SystemMetadata medatadata;

    @Version
    private long version;



    public String get_id() {
        return _id;
    }

    public void set_id(final String _id) {
        this._id = _id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(final String accountId) {
        this.accountId = accountId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(final String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
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

    public au.com.mongodb.test.persistence.entities.SystemMetadata getMedatadata() {
        return medatadata;
    }

    public void setMedatadata(final SystemMetadata medatadata) {
        this.medatadata = medatadata;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(final long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return Double.compare(event.totalAmount, totalAmount) == 0 &&
                version == event.version &&
                _id.equals(event._id) &&
                Objects.equals(accountId, event.accountId) &&
                Objects.equals(referenceNumber, event.referenceNumber) &&
                Objects.equals(accountNumber, event.accountNumber) &&
                Objects.equals(scheme, event.scheme) &&
                Objects.equals(schemeMembershipNumber, event.schemeMembershipNumber) &&
                Objects.equals(type, event.type) &&
                Objects.equals(dateRequested, event.dateRequested) &&
                Objects.equals(effectiveDate, event.effectiveDate) &&
                Objects.equals(processedDate, event.processedDate) &&
                Objects.equals(description, event.description) &&
                Objects.equals(status, event.status) &&
                Objects.equals(paymentType, event.paymentType) &&
                Objects.equals(redemptionType, event.redemptionType) &&
                Objects.equals(benefitReason, event.benefitReason) &&
                Objects.equals(rolloverInstitution, event.rolloverInstitution) &&
                Objects.equals(feeType, event.feeType) &&
                Objects.equals(contribuitionType, event.contribuitionType) &&
                Objects.equals(medatadata, event.medatadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, accountId, referenceNumber, accountNumber, scheme, schemeMembershipNumber, type, dateRequested, effectiveDate, processedDate, totalAmount, description, status, paymentType, redemptionType, benefitReason, rolloverInstitution, feeType, contribuitionType, medatadata, version);
    }
}
