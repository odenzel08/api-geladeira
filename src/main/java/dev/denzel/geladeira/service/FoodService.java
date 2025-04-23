package dev.denzel.geladeira.service;

import dev.denzel.geladeira.model.Food;
import dev.denzel.geladeira.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    //LISTAR
    public List getAll(){return foodRepository.findAll();}

    //OBTER POR ID
    public Food getById(Long id){return foodRepository.findById(id).orElse(null);}

    //CRIAR
    public Food save(Food food){return foodRepository.save(food);}

    //ATUALIZAR
    public Optional<Food> update(Long id, Food newFood){
        return foodRepository.findById(id).map(existingFood -> {
            existingFood.setName(newFood.getName());
            existingFood.setExpiration_date(newFood.getExpiration_date());
            existingFood.setQuantity(newFood.getQuantity());
            return foodRepository.save(existingFood);
        });
    }
    //DELETAR
    public boolean delete(Long id){
        if (foodRepository.existsById(id)) {
            foodRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
