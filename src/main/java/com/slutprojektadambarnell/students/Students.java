package com.slutprojektadambarnell.students;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.slutprojektadambarnell.courses.Courses;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "com/slutprojektadambarnell/students")
@Data
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Students {
    @Id
    @Column(name = "students_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "town")
    private String town;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "lastname")
    private String lastname;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "attendance",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonBackReference
    private Set<Courses> courses = new HashSet<>();
}
