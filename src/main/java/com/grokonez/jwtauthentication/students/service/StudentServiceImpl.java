package com.grokonez.jwtauthentication.students.service;

import com.grokonez.jwtauthentication.dekanat.model.Dekanat;
import com.grokonez.jwtauthentication.students.model.Student;
import com.grokonez.jwtauthentication.students.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> listStudent() {
        return studentRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return false;
    }

    @Override
    public List<Student> getById(Long id) {

        return null;
    }


}
