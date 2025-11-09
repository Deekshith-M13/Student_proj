package com.student_proj.student_proj.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data

public class studentRequestDto{

    @Size(min = 3 , max = 100 , message = "Name should have minimum of 3 characters")
    private String name;

    @Min(value = 1)
    private int age;
}
