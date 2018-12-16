package ru.kpfu.itis.anochatty.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Food")
public class Food extends Preference {
}
