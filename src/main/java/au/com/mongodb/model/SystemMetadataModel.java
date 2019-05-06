package au.com.mongodb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemMetadataModel)) return false;
        SystemMetadataModel that = (SystemMetadataModel) o;
        return Objects.equals(createBy, that.createBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(modifiedBy, that.modifiedBy) &&
                Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createBy, createdDate, modifiedBy, modifiedDate);
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
