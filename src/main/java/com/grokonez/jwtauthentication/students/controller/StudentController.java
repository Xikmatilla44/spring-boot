package com.grokonez.jwtauthentication.students.controller;


import com.grokonez.jwtauthentication.students.convert.dto.StudentDTO;
import com.grokonez.jwtauthentication.students.convert.mapper.ConvertStudent;
import com.grokonez.jwtauthentication.students.model.Student;
import com.grokonez.jwtauthentication.students.respository.StudentRepository;
import com.grokonez.jwtauthentication.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class StudentController {

    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/Student")
    public List<StudentDTO> listAllStudent(){
        ConvertStudent convertStudent = new ConvertStudent();
        List<Student> students = (List<Student>) studentService.listStudent();

        return convertStudent.toDTO(students);
    }


    @PostMapping(value = "/saveStudent")
    public ResponseEntity saveStudent(@Valid @RequestBody StudentDTO studentDTO) {
        ConvertStudent convertStudent = new ConvertStudent();
        return ResponseEntity.ok(studentService.saveStudent(convertStudent.toEntity(studentDTO)));
    }

    @DeleteMapping("/deleteStudent/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        boolean res;
        res = studentService.deleteStudent(id);
        if (res == true) {
            return true;
        } else {
            return false;
        }

    }



}
