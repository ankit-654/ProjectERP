package ProjectERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ProjectERP.Models.Qualification;

public interface Qualification_Repository extends JpaRepository<Qualification, Integer> {

}
