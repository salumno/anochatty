package ru.kpfu.itis.anochatty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.anochatty.model.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
