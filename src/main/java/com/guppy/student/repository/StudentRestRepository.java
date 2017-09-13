package com.guppy.student.repository;

import com.guppy.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StudentRestRepository {

    private final RestTemplate restTemplate;

    // TODO : 생성자 의존성 주입 받는 방식을 사용하도록 하자 (그래야 커플링 최소화)
    @Autowired
    public StudentRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Student> getStudent () {
        return restTemplate.getForEntity("http://localhost:3000/students/one", Student.class);
    }



}
