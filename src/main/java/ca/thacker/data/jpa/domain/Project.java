package ca.thacker.data.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by AndreaThacker on 2/9/2016.
 */


@Entity
public class Project extends AbstractBaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="PROJECT_NAME", nullable = false)
    private String projectName;


    @Column(name="OWNER_ID",   insertable = false, updatable = false)
    private Long ownerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ONWER_ID")
    @JsonIgnore
    private Owner owner;

    @OneToMany(mappedBy = "project" )
    private List<Guideline> guidelines;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public List<Guideline> getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(List<Guideline> guidelines) {
        this.guidelines = guidelines;
    }
}
