package com.example.librarymanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private BorrowRecord borrowRecord;

    @Column(nullable = false)
    private BigDecimal amount;

    private boolean paid;
}
