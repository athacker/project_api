package ca.thacker.data.jpa.service;

import ca.thacker.data.jpa.domain.City;
import ca.thacker.data.jpa.domain.Guideline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "guidelines", path = "guidelines"  )
interface GuidelineRepository extends PagingAndSortingRepository<Guideline, Long> {



}
