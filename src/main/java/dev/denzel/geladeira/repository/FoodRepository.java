package dev.denzel.geladeira.repository;

import dev.denzel.geladeira.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {//Passar a classe e o tipo do identificador (Id)
}
