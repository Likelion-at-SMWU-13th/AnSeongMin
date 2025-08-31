package com.likelion.seminar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "BoardDto{" + "id=" + id + ", name='" + name + '\'' + "}";
    }
}
