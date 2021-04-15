package com.example.sdata2.services;

import com.example.sdata2.domain.Student;
import com.example.sdata2.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository  studentRepository;

  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public Student save(Student student) {
    return studentRepository.save(student);
  }
}
