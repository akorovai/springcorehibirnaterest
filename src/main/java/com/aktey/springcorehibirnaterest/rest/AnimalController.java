package com.aktey.springcorehibirnaterest.rest;

import com.aktey.springcorehibirnaterest.dao.AnimalDao;
import com.aktey.springcorehibirnaterest.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/animals")
public class AnimalController {
    private final AnimalDao animalDao;

    @Autowired
    public AnimalController(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @GetMapping
    private List<Animal> showAnimals(@RequestParam(name = "orderBy", defaultValue = "Name") String param) {
        return animalDao.getAnimalsList(param);
    }

    @PostMapping
    private void addAnimal(@RequestBody Animal animal) {
        animalDao.save(animal);
    }

    @DeleteMapping("{id}")
    private void deleteAnimal(@PathVariable int id) {
        animalDao.delete(id);
    }

    @GetMapping("{id}")
    private Animal find(@PathVariable int id) {
        return animalDao.findById(id);
    }

    @PostMapping("{id}")
    private void modify(@PathVariable int id, @RequestBody Animal animal) {
        animal.setId(id);
        animalDao.modify(animal);
    }
}
