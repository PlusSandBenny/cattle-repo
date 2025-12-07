package com.aureus.cattlemanagement.entity;

import jakarta.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;


@Data
@Entity
@Table(name = "cattle_breeds")
public class CattleBreed {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
}
