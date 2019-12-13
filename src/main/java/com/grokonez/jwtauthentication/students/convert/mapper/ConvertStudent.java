package com.grokonez.jwtauthentication.students.convert.mapper;

import com.grokonez.jwtauthentication.dekanat.model.Dekanat;
import com.grokonez.jwtauthentication.students.convert.dto.StudentDTO;
import com.grokonez.jwtauthentication.students.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ConvertStudent {

//    public StudentDTO toDTO(Student student) {
//        StudentDTO studentDTO = new StudentDTO();
//        studentDTO.setId(student.getId());
//        studentDTO.setFirstName(student.getFirstName());
//        studentDTO.setLastName(student.getLastName());
//        studentDTO.setPhone(student.getPhone());
//        studentDTO.setEmail(student.getEmail());
//        studentDTO.setDekanatId(student.getDekanat().getId();
//        studentDTO.setDekanatName(student.getDekanat().getName());
//
//        return studentDTO;
//
//    }

    public Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setPhone(studentDTO.getPhone());
        student.setEmail(studentDTO.getEmail());

        Dekanat dekanat = new Dekanat();
        if (studentDTO.getDekanatName() == null) {
            studentDTO.setDekanatName("");
        }
        if (studentDTO.getDekanatId() == null) {
            studentDTO.setDekanatId((long) 1);
        }
        dekanat.setId(studentDTO.getDekanatId());
        student.setDekanat(dekanat);

        return student;

    }

    public List<StudentDTO> toDTO(List<Student> students) {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setFirstName(student.getFirstName());
            studentDTO.setLastName(student.getLastName());
            studentDTO.setId(student.getId());
            studentDTO.setPhone(student.getPhone());
            studentDTO.setEmail(student.getEmail());

            if (student.getDekanat() != null) {
                studentDTO.setDekanatId(student.getDekanat().getId());
                studentDTO.setDekanatName(student.getDekanat().getName());
            } else {
                studentDTO.setDekanatName("");
            }
            studentDTOS.add(studentDTO);

        }

        return studentDTOS;
    }

}
