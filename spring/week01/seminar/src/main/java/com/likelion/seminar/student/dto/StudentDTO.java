package com.likelion.seminar.student.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StudentDTO {
    private Long studentID;
    private String name;
    private LocalDate dateOfBirth;
}
