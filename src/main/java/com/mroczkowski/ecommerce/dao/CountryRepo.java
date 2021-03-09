package com.mroczkowski.ecommerce.dao;

import com.mroczkowski.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRepo extends JpaRepository<Country, Integer> {
}
