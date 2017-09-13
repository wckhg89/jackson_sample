package com.guppy.student.controller.rest;


import com.guppy.student.domain.Student;
import com.guppy.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    private final StudentService studentService;

    // TODO : 생성자 의존성 주입 받는 방식을 사용하도록 하자 (그래야 커플링 최소화)
    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/one")
    public ResponseEntity<Student> getStudent () {
        return studentService.getStudent();
    }


}
