package ca.thacker.data.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created by AndreaThacker on 2/9/2016.
 */

@Entity
@SuppressWarnings("serial")
public class Guideline extends AbstractBaseEntity{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="PROJECT_ID",   insertable = false, updatable = false)
    private Long projectId;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="value", nullable = false)
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
