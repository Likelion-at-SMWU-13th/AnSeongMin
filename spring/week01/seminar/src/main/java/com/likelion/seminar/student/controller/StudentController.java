package com.likelion.seminar.student.controller;

import com.likelion.seminar.student.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {
    private final List<StudentDTO> studentDTOList;

    @PostMapping()
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        System.out.println(studentDTO.toString());
        this.studentDTOList.add(studentDTO);
    }

    @GetMapping()
    public List<StudentDTO> readStudentAll() {
        System.out.println("학생 전체 조회");
        return this.studentDTOList;
    }

    @GetMapping("{id}")
    public StudentDTO readStudentById(@PathVariable("id") int id) {
        System.out.println("포스트 단일 조회");
        return this.studentDTOList.get(id);
    }

    @PutMapping("{id}")
    public void updateStudent(
            @PathVariable("id") int id,
            @RequestBody StudentDTO studentDto) {
        StudentDTO targetStudent = this.studentDTOList.get(id);
        if(studentDto.getStudentID()!=null){
            targetStudent.setStudentID(studentDto.getStudentID());
        }
        if(studentDto.getName()!=null){
            targetStudent.setName(studentDto.getName());
        }
        if(studentDto.getDateOfBirth()!=null){
            targetStudent.setDateOfBirth(studentDto.getDateOfBirth());
        }
        this.studentDTOList.set(id, targetStudent);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        this.studentDTOList.remove(id);
    }



}
