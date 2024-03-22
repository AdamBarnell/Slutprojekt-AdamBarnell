package com.slutprojektadambarnell.courses;

import com.slutprojektadambarnell.students.Students;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends CrudRepository <Courses,Integer> {
    List<Courses> findByNameContaining(String name);
    List<Courses> findByDescriptionContaining(String description);
}
