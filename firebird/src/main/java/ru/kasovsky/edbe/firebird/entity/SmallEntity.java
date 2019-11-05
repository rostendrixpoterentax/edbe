package ru.kasovsky.edbe.firebird.entity;

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
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 36)
    private String uuid;

    @Column(nullable = false, length = 36)
    private String name;

    @Column(nullable = false, columnDefinition="BLOB SUB_TYPE TEXT")
    private String data;
}
