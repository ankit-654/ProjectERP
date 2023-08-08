package ProjectERP.ViewRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectERP.ViewModels.Qualification_View;

public interface Qualification_View_Repository extends JpaRepository<Qualification_View, Integer>{

	List<Qualification_View> findAll();

}
