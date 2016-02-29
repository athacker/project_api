package ca.thacker.data.jpa.service;


import com.github.springtestdbunit.annotation.DatabaseSetup;
import ca.thacker.data.jpa.ProjectDataTestApplication;
import ca.thacker.data.jpa.domain.City;
import ca.thacker.data.jpa.domain.Guideline;
import ca.thacker.data.jpa.domain.Owner;
import ca.thacker.data.jpa.domain.Project;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

/**
 * Created by AndreaThacker on 2/
 *
 * 18/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@DatabaseSetup(GuidelineRepositoryTest.DATASET)
@SpringApplicationConfiguration(classes = ProjectDataTestApplication.class)
@ActiveProfiles("testdb")

public class GuidelineRepositoryTest {

    protected static final String DATASET = "classpath:datasets/it-guidelines.xml";

    @Autowired
    private GuidelineRepository guidelineRepository;

    private Owner owner;
    private City city;
    private Project project;
    private Guideline guideline;


    @Before
    public void setUp() {

        city = new City("Cheyenne", "Wyoming", "US"  );

        owner = new Owner();
        owner.setCity(city);
        owner.setName("athacker");

        project = new Project(  );
        project.setProjectName("Project Info");
        project.setOwner(owner);

        guideline = new Guideline();

        guideline.setProject(project);
        guideline.setTitle("Validation");
        guideline.setValue("Angular In-Line Validation");

    }

    @Test
    public void  fileAll(){
        guidelineRepository.findAll();
    }

    @Test
    public void saveEditNewGuideline(){
      guideline = guidelineRepository.save(guideline);
      guidelineRepository.findOne(guideline.getId());
      guideline.setValue("Angular In-Line Validation 1.3");
      guidelineRepository.save(guideline);
    }


    @Test
    public void deleteGuideline(){
        guidelineRepository.delete(guideline);
    }



}
