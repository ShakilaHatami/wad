package com.example.sdata2.bootstrap;

import com.example.sdata2.domain.Address;
import com.example.sdata2.domain.Card;
import com.example.sdata2.domain.Faculty;
import com.example.sdata2.domain.Student;
import com.example.sdata2.services.FacultyService;
import com.example.sdata2.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
  private final StudentService studentService;
  private final FacultyService facultyService;

  public DataLoader(StudentService studentService, FacultyService facultyService) {
    this.studentService = studentService;
    this.facultyService = facultyService;
  }

  @Override
  public void run(String... args) throws Exception {
    Student s1 = new Student("John");
    Address a1= new Address("Bucuresti");
    s1.setAddress(a1);
    Card c1 = new Card("123");
    Card c2 = new Card("234");
    s1.addCard(c1);
    s1.addCard(c2);
//    s1 = studentService.save(s1);


    Faculty fils = new Faculty("FILS", LocalDate.of(2001,1,1));
    fils.addStudent(s1);
    facultyService.save(fils);

  }
}
