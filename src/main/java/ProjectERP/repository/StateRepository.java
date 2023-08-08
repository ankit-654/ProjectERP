package ProjectERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ProjectERP.Models.State;

public interface StateRepository extends JpaRepository<State, Integer>{

}
