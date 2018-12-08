package ru.kpfu.itis.anochatty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.anochatty.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
