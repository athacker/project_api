package ca.thacker.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by AndreaThacker on 2/9/2016.
 */



@MappedSuperclass
public class AbstractBaseEntity implements Serializable {


    @Column(name = "updated_timestamp")
    private Date updatedDate;

    @Column(name = "created_date")
    private Date createdDate;

    @PrePersist
    void prePersist() {
        createdDate = new Date();
        preUpdate();
    }

    @PreUpdate
    void preUpdate() {
        updatedDate = new Date();
    }


    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }




}
