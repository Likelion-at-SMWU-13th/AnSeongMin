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

    @GetMapping("{studentID}")
    public Object readStudent(@PathVariable("studentID") Long studentID) {
        System.out.println("학생 단일 조회");
        for (StudentDTO studentDto : this.studentDTOList) {
            if (studentDto.getStudentID().equals(studentID)) {
                return studentDto;
            }
        }
        return "해당 studentID를 가진 학생이 존재하지 않습니다.";
    }

    @PutMapping("{studentID}")
    public Object updateStudent(
            @PathVariable("studentID") Long studentID,
            @RequestBody StudentDTO studentDto) {
        for (StudentDTO targetStudent : this.studentDTOList) {
            if (targetStudent.getStudentID().equals(studentID)) {
                if (studentDto.getName() != null) {
                    targetStudent.setName(studentDto.getName());
                }
                if (studentDto.getDateOfBirth() != null) {
                    targetStudent.setDateOfBirth(studentDto.getDateOfBirth());
                }
                if (studentDto.getStudentID() != null) {
                    targetStudent.setStudentID(studentDto.getStudentID());
                }
                return "학생 정보 수정 완료";
            }
        }
        return "해당 studentID를 가진 학생이 존재하지 않습니다.";
    }

    @DeleteMapping("{studentID}")
    public Object deleteStudent(@PathVariable("studentID") Long studentID) {
        for (StudentDTO student : this.studentDTOList) {
            if (student.getStudentID().equals(studentID)) {
                this.studentDTOList.remove(student);
                return "학생이 삭제되었습니다.";
            }
        }
        return "해당 studentID를 가진 학생이 존재하지 않습니다.";
    }



}
