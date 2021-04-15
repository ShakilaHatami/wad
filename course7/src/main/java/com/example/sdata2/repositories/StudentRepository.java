package com.example.sdata2.repositories;

import com.example.sdata2.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
