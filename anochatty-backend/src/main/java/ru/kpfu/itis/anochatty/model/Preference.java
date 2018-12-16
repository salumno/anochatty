package ru.kpfu.itis.anochatty.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance
@DiscriminatorColumn(name="preference_type")
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
