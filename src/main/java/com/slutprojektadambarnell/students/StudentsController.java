package com.slutprojektadambarnell.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentsController {
    @Autowired
    private StudentsService studentsService;
    //Searches for all the students
    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Students>> students() {
        Iterable<Students> allStudents = studentsService.getAllStudentsDirectly();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }
    //Searches for students with id
    @GetMapping("/students/id/{id}")
    public ResponseEntity<StudentsDTO> getStudentById(@PathVariable Integer id) {
        Optional<Students> studentOptional = studentsService.studentId(id);
        if (studentOptional.isPresent()) {
            StudentsDTO studentDTO = studentsService.mapToDTO(studentOptional.get());
            return new ResponseEntity<>(studentDTO, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Searches for students with name

    @GetMapping(value = "/students/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudentsByName(@PathVariable String name) {
        List<StudentsDTO> students = studentsService.findStudentsByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    //Searches for students with lastname
    @GetMapping(value = "/students/lastname/{lastname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudentsByLastname(@PathVariable String lastname){
        List<StudentsDTO> students = studentsService.findStudentsByLastname(lastname);
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
    //Searches for students with town
    @GetMapping(value = "/students/town/{town}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentsDTO>> getStudentsByTown(@PathVariable String town) {
        List<StudentsDTO> students = studentsService.findStudentsByTown(town);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
