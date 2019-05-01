package au.com.mongodb.test.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;


public class SystemMetadataModel implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createBy;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String modifiedBy;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String modifiedDate;


    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(final String createBy) {
        this.createBy = createBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(final String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
