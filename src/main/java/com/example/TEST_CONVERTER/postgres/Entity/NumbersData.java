package com.example.TEST_CONVERTER.postgres.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(schema = "dzugaev", name = "num_data")
public class NumbersData {

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "number")
    private Long number;
}
