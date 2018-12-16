package ru.kpfu.itis.anochatty.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Movie")
public class Movie extends Preference {
}
