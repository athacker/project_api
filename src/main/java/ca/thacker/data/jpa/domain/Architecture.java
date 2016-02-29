package ca.thacker.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by AndreaThacker on 2/9/2016.
 */
public class Architecture extends AbstractBaseEntity{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Project project;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
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
}
