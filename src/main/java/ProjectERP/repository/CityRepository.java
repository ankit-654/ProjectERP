package ProjectERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ProjectERP.Models.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
