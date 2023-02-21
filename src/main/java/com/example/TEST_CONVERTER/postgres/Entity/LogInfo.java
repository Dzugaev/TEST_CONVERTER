package com.example.TEST_CONVERTER.postgres.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "dzugaev", name = "logs")
public class LogInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "inner_value")
    private String input;

    @Column(name = "outer_value")
    private String output;

    @Column(name = "created")
    private OffsetDateTime created;

    @Column(name = "user_id")
    private Long userId;
}
