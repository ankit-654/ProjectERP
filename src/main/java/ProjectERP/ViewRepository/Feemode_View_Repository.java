package ProjectERP.ViewRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectERP.ViewModels.Feemode_View;

public interface Feemode_View_Repository extends JpaRepository<Feemode_View, Integer>{

	List<Feemode_View> findAll();

}
