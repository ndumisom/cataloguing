package com.ndumiso.manageusersandcatalogue.repository;
import com.ndumiso.manageusersandcatalogue.model.UserCatalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ndumiso on 14/06/18.
 */

@Repository
public interface UserCatalogueRepository extends JpaRepository<UserCatalogue, Long> {

}
