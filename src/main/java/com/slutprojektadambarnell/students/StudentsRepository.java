package com.slutprojektadambarnell.students;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends CrudRepository<Students, Integer> {
    List<Students> findByName(String name);
    List<Students> findByTown(String town);
    List<Students> findByLastname(String lastname);
}
