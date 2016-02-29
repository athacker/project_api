package ca.thacker.data.jpa;

import ca.thacker.data.jpa.domain.City;
import ca.thacker.data.jpa.domain.Guideline;
import ca.thacker.data.jpa.domain.Owner;
import ca.thacker.data.jpa.domain.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;
import java.util.Date;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProjectDataRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("testdb")
public class ProjectDataRestApplicationTests {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
    private Owner owner;
    private City city;
    private Project project;
    private Guideline guideline;



    final String BASE_URL_GUIDELINE = "http://localhost:8080/guidelines/";
    final String BASE_URL_CITY = "http://localhost:8080/cities/";
    final String BASE_URL_PROJECT = "http://localhost:8080/projects/";

    @Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        city = new City("Cheyenne", "Wyoming", "US"  );

        owner = new Owner();
        owner.setCity(city);
        owner.setName("athacker");

        project = new Project(  );
        project.setProjectName("Project Info");
//        project.setOwner(owner);

//        guideline = new Guideline();
//
//        guideline.setProject(project);
//        guideline.setTitle("Validation");
//        guideline.setValue("Angular In-Line Validation");

    }

	@Test
	public void testHome() throws Exception {
 		this.mvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(content().string(containsString("owners")));
	}

	@Test
	public void testCity() throws Exception{
		this.mvc.perform(get("/cities")).andExpect(status().isOk())
				.andExpect(content().string(containsString("name")));;
	}


    @Test
    public void testPostCity() throws Exception{
        RestTemplate rest = new TestRestTemplate();
        String json=" {\"name\":\"" + city.getName() + "\",\"state\":\""
                + city.getState() + "\",\"country\":\""
                + city.getCountry() + "\"}";

        this.mvc.perform(post(BASE_URL_CITY).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated());

    }



    @Test
    public void testPostProject()throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString( project);
        this.mvc.perform(post(BASE_URL_PROJECT).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated());
    }




	@Test
	public void testOwner()throws Exception{
		this.mvc.perform(get("/owners/1")).andExpect(status().isOk());
	}

    @Test
    public void testProject() throws Exception{
        this.mvc.perform(get("/projects/1")).andExpect(status().isOk());
    }



}
