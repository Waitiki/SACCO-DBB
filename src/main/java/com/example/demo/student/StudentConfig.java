//package com.example.demo.student;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static java.time.Month.MAY;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner CommandLineRunner(StudentRepository repository)
//    {
//        return args -> {
//            Student naina = new Student(
//                    1L,
//                    "Naina",
//                    "naina@gmail.com",
//                    LocalDate.of(2001, MAY, 3)
//
//            );
//
//            Student mburu = new Student(
//                    "Mburu",
//                    "mburu@gmail.com",
//                    LocalDate.of(2009, MAY, 3)
//            );
//
//            repository.saveAll(
//                    List.of(naina, mburu)
//            );u
//        };
//    }
//}
