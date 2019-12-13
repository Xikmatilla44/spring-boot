package com.grokonez.jwtauthentication.students.controller;


import com.grokonez.jwtauthentication.bolim.exception.ResourceNotFoundException;
import com.grokonez.jwtauthentication.students.convert.dto.StudentDTO;
import com.grokonez.jwtauthentication.students.convert.mapper.ConvertStudent;
import com.grokonez.jwtauthentication.students.model.Student;
import com.grokonez.jwtauthentication.students.respository.StudentRepository;
import com.grokonez.jwtauthentication.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
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
    public boolean deleteStudent(@PathVariable Long[] id) {
            boolean res = false;
        for (Long idex : id) {
            res = studentService.deleteStudent(idex);
        }
        if (res == true) {
            return true;
        } else {
            return false;
        }

    }



    @GetMapping("student/{id}")
    public Student findOne(@PathVariable Long id) {
        Student student = studentService.getById(id);
        return student;

    }

    @PutMapping("/StudentPut/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
                                                     @Valid @RequestBody Student studentDetails) throws ResourceNotFoundException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setPhone(studentDetails.getEmail());
        student.setDekanat(studentDetails.getDekanat());

        final Student updatedStudent= studentRepository.save(student);

        return ResponseEntity.ok(updatedStudent);

    }

    @GetMapping("/StudentByName/{name}")
    public List<StudentDTO> getByName(@PathVariable String name) {
        ConvertStudent convertStudent = new ConvertStudent();


        List<Student> list = studentService.getByName(name);

        return convertStudent.toDTO(list);

    }





}
