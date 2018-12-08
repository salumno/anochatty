package ru.kpfu.itis.anochatty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.anochatty.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
