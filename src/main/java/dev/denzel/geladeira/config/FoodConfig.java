package dev.denzel.geladeira.config;

import dev.denzel.geladeira.model.Food;
import dev.denzel.geladeira.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class FoodConfig implements CommandLineRunner {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public void run(String... args) throws Exception {

        Food food1 = new Food(null, "Bolo de Chocolate", LocalDate.of(2025, 5, 2),1);
        Food food2 = new Food(null, "Margarina", LocalDate.of(2026, 5, 8), 3);
        Food food3 = new Food(null, "Ovos", LocalDate.of(2025, 6, 29), 30);
        Food food4 = new Food(null, "Queijo Branco", LocalDate.of(2025, 6, 15), 2);

        foodRepository.saveAll(Arrays.asList(food1, food2, food3, food4));
    }

}
