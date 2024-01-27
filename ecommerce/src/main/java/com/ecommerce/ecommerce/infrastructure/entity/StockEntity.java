package com.ecommerce.ecommerce.infrastructure.entity;

import com.ecommerce.ecommerce.domain.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "stcok")
@Data
@NoArgsConstructor
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateCreated;
    private Integer unitIn;
    private Integer unitOut;
    private String description;
    private Integer balance;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductEntity productEntity;
}