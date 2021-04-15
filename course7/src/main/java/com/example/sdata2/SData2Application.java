package com.example.sdata2;

import com.example.sdata2.domain.Address;
import com.example.sdata2.domain.Card;
import com.example.sdata2.domain.Faculty;
import com.example.sdata2.domain.Student;
import com.example.sdata2.services.FacultyService;
import com.example.sdata2.services.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SData2Application {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SData2Application.class, args);

  }

}
