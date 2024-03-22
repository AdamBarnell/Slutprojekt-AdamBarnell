package com.slutprojektadambarnell.courses;

import lombok.*;
import com.slutprojektadambarnell.students.StudentsDTO;

import java.util.List;

@NoArgsConstructor

@Getter
@Setter
public class CoursesDTO {
     private Integer id;
     private String name;
     private String description;


     public CoursesDTO(Integer id, String name, String description) {
          this.id = id;
          this.name = name;
          this.description = description;
     }
}
