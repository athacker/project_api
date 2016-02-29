package ca.thacker.data.jpa.service;

import ca.thacker.data.jpa.domain.City;
import ca.thacker.data.jpa.domain.Owner;
import ca.thacker.data.jpa.domain.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
interface
		ProjectRepository extends PagingAndSortingRepository<Project, Long> {
 //	Project findByOwner(Owner owner);
}
