package com.aktey.springcorehibirnaterest.dao;


import com.aktey.springcorehibirnaterest.entities.Animal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalDaoImplementation implements AnimalDao {
    private final EntityManager entityManager;

    @Autowired
    public AnimalDaoImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Animal newAnimal) {
        entityManager.persist(newAnimal);
    }

    @Override
    public List<Animal> getAnimalsList(String value) {
        TypedQuery<Animal> animalTypedQuery = entityManager.createQuery("FROM Animal ORDER BY :value", Animal.class);
        animalTypedQuery.setParameter("value", value);
        return animalTypedQuery.getResultList();
    }

    @Override
    public Animal findById(int id) {
        return entityManager.find(Animal.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    @Transactional
    public void modify(Animal modifiedAnimal) {
        entityManager.merge(modifiedAnimal);
    }
}





















