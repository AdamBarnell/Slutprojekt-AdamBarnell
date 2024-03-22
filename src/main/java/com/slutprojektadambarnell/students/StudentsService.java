package com.slutprojektadambarnell.students;


import com.slutprojektadambarnell.courses.Courses;
import com.slutprojektadambarnell.courses.CoursesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StudentsService {
    @Autowired
    StudentsRepository studentsRepository;

    public List<StudentsDTO> getAllStudents(){
        List<StudentsDTO> studentsDTO = new ArrayList<>();
        studentsRepository.findAll().forEach(students ->studentsDTO.add(this.mapToDTO(students)));
        return studentsDTO;
    }

    public List<StudentsDTO> findStudentsByName(String name) {
        return studentsRepository.findByName(name).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    public List<StudentsDTO> findStudentsByLastname(String lastname){
        return studentsRepository.findByLastname(lastname).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentsDTO> findStudentsByTown(String town) {
        return studentsRepository.findByTown(town).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Iterable <Students> getStudent(){
        return studentsRepository.findAll();
    }

    private CoursesDTO mapCourseToDTO(Courses course) {
        CoursesDTO dto = new CoursesDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        return dto;
    }

    public StudentsDTO mapToDTO(Students student) {
        StudentsDTO dto = new StudentsDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setHobby(student.getHobby());
        dto.setTown(student.getTown());
        dto.setLastname(student.getLastname());
        List<CoursesDTO> coursesDTOs = student.getCourses().stream()
                .map(this::mapCourseToDTO)
                .collect(Collectors.toList());
        dto.setCourses(coursesDTOs);
        return dto;
    }

    public Optional<Students> studentId(Integer id) {
        return studentsRepository.findById(id);
    }

    public Iterable<Students> getAllStudentsDirectly() {
        return studentsRepository.findAll();
    }
}
