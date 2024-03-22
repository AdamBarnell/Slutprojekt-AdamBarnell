package com.slutprojektadambarnell.courses;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.slutprojektadambarnell.students.Students;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "com/slutprojektadambarnell/courses")
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Courses {
    @Id
    @Column(name = "courses_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @JsonManagedReference
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Students> students = new HashSet<>();
}
