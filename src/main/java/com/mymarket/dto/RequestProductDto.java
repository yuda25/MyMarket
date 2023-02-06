package com.mymarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class RequestProductDto {
    @NotBlank(message = "name shouldn't be null")
    private String name;
    @NotBlank(message = "description shouldn't be null")
    private String description;
    @NotNull(message = "name shouldn't be null")
    private Integer stock;
    @NotNull(message = "price shouldn't be null")
    private Double price;
    @NotBlank(message = "image shouldn't be null")
    private String image;
}
