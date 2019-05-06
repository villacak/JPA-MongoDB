package au.com.mongodb.persistence.entities;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;


@Embeddable
@NoSql(dataFormat = DataFormatType.MAPPED)
public class SystemMetadata implements Serializable {

    @Basic
    private String createBy;

    @Basic
    private String createdDate;

    @Basic
    private String modifiedBy;

    @Basic
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
