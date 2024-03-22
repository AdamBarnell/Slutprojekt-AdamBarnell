package com.slutprojektadambarnell.courses;

import com.slutprojektadambarnell.students.Students;
import com.slutprojektadambarnell.students.StudentsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class CoursesController {
    @Autowired
    CoursesService coursesService;
    //Gets all the courses and the students in it
    @GetMapping(value = "/courses/students", produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<Courses> getCourses(){
        return coursesService.getCourses();
    }
    //Gets all the courses that are avaliable
    @GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<CoursesDTO>> onlyGetCourses(){
        Iterable<CoursesDTO> courses = coursesService.onlyGetCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    //Searches for courses by id
    @GetMapping("/courses/id/{id}")
    public ResponseEntity<Courses> findCourseById(@PathVariable Integer id) {
        return coursesService.findCourseById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //Searches for courses by name
    @GetMapping(value = "/courses/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Courses>> getName(@PathVariable String name) {
        List<Courses> courses = coursesService.findCourseByName(name);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    //Searches for courses with description
    //TODO Använd contains
    @GetMapping(value = "/courses/description/{description}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Courses>> getDescription(@PathVariable String description) {
        List<Courses> courses = coursesService.findCourseByDescription(description);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
