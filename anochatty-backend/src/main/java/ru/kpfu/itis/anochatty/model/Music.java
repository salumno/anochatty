package ru.kpfu.itis.anochatty.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Music")
public class Music extends Preference {
}
