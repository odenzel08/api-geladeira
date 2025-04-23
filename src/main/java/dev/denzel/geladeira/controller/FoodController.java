package dev.denzel.geladeira.controller;

import dev.denzel.geladeira.model.Food;
import dev.denzel.geladeira.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getAll(){ return foodService.getAll();}

    @GetMapping("{id}")
    public Food getById(@PathVariable("id") Long id){return foodService.getById(id);}

    @PostMapping
    public Food create(@RequestBody Food food){return foodService.save(food);}

    @PutMapping("{id}")
    public Optional<Food> update(@PathVariable("id") Long id, @RequestBody Food food){
        return foodService.update(id, food);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){foodService.delete(id);}

}
