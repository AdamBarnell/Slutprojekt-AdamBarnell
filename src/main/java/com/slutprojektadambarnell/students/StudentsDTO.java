package com.slutprojektadambarnell.students;

import com.slutprojektadambarnell.courses.CoursesDTO;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentsDTO {

        private Integer id;
        private String name;
        private String lastname;
        private String hobby;
        private String town;
        List<CoursesDTO> courses;

}
