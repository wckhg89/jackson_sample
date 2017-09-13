package com.guppy.student.service;


import com.guppy.student.domain.Student;
import com.guppy.student.repository.StudentRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // 초기화 하지 않은 final 키워드는 반드시 생성자에서 초기회 해줘야 한다.
    private final StudentRestRepository studentRestRepository;

    // TODO : 생성자 의존성 주입 받는 방식을 사용하도록 하자 (그래야 커플링 최소화)
    @Autowired
    public StudentService(StudentRestRepository studentRestRepository) {
        this.studentRestRepository = studentRestRepository;
    }


    public ResponseEntity<Student> getStudent () {
        return studentRestRepository.getStudent();
    }


}
