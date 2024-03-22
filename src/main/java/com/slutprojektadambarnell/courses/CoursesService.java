package com.slutprojektadambarnell.courses;

import com.slutprojektadambarnell.students.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class CoursesService {
    @Autowired
    CoursesRepository coursesRepository;

    public Iterable<Courses> getCourses(){

        return coursesRepository.findAll();
    }

    public Optional<Courses> findCourseById(Integer id) {

        return coursesRepository.findById(id);
    }
    public List<Courses> findCourseByDescription(String description){
        return coursesRepository.findByDescriptionContaining(description);
    }

    public List<Courses> findCourseByName(String name) {
        return coursesRepository.findByNameContaining(name);
    }

    public Iterable<CoursesDTO> onlyGetCourses() {
        List<Courses> courses = (List<Courses>) coursesRepository.findAll();
        return courses.stream()
                .map(course -> new CoursesDTO(course.getId(), course.getName(), course.getDescription()))
                .collect(Collectors.toList());
    }
}
