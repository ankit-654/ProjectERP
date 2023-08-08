package ProjectERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ProjectERP.Models.Technology;

public interface Technology_Repository extends JpaRepository<Technology, Integer>{

}
