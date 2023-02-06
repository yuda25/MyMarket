package com.mymarket.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UpdateProductDto {
    @NotBlank(message = "UUID shouldn't be null")
    private UUID id;
    @NotBlank(message = "name shouldn't be null")
    private String name;
    @NotBlank(message = "description shouldn't be null")
    private String description;
    @NotNull(message = "Stock shouldn't be null")
    private Integer stock;
    @NotNull(message = "price shouldn't be null")
    private Double price;
    @NotBlank(message = "image shouldn't be null")
    private String image;
}
