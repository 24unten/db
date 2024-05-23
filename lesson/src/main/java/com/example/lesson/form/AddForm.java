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
public class AddForm {
    @NotEmpty
    @Length(min = 1, max = 50)
    private String name;
    @NotNull
    @Range(min = 1, max = 2147483646 )
    private Integer price;

}