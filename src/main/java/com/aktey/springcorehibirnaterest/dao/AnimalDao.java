package com.aktey.springcorehibirnaterest.dao;


import com.aktey.springcorehibirnaterest.entities.Animal;

import java.util.List;

public interface AnimalDao {
    void save(Animal newAnimal);

    List<Animal> getAnimalsList(String value);

    Animal findById(int id);

    void delete(int id);

    void modify(Animal modifiedAnimal);
}
