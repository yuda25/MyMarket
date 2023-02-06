package com.mymarket.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_product")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Product implements Serializable{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false)
    private UUID id;

    @Column()
    private String name;
    
    @Column()
    private String description;
    
    @Column()
    private Integer stock;
    
    @Column()
    private Double price;

    @Column()
    private String image;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
