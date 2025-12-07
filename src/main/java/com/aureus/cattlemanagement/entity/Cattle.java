package com.aureus.cattlemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "cattle")
public class Cattle {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "breed_id", nullable = false)
    private CattleBreed breed;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private CattleOwner owner;

    @ManyToOne
    @JoinColumn(name = "current_owner_id", nullable = false)
    private CattleOwner currentOwner;

    private boolean forSale = false;

    private String saleInstructions;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
