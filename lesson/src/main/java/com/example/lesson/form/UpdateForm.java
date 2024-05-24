package com.example.lesson.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class UpdateForm {
    @NotEmpty
    private String name;
    @NotNull
    private Integer price;

}