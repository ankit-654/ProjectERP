package ProjectERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ProjectERP.Models.Training_courses;

public interface Training_Courses_Repository extends JpaRepository<Training_courses, Integer>{

}
