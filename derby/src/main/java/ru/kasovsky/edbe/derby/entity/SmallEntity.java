package ru.kasovsky.edbe.derby.entity;

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

    @Column(nullable = false, length = 36)
    private UUID uuid;

    @Column(nullable = false, length = 36)
    private String name;

    @Column(nullable = false, length = 32672)
    private String data;
}
