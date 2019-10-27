package ru.kasovsky.edbe.h2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@Entity
@Table(name = "small")
public class SmallEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 512000)
    private String data;
}
