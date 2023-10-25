package com.bitee.StudentManagement.config;

import com.bitee.StudentManagement.models.Student;
import com.bitee.StudentManagement.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student("mariam",
                    "mariamlos@gmail.com",
                    LocalDate.of(2002, Month.APRIL,21));
            Student alex = new Student("Alex Karev",
                    "alexis@gmail.com",
                    LocalDate.of(2025, Month.FEBRUARY,15));
            repository.saveAll(
                    List.of(mariam,alex)
            );
        };
    }
}
