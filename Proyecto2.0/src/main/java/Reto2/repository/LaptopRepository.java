/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2.repository;

import Reto2.model.Laptop;
import Reto2.repository.crud.LaptopCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Usuario
 */
@Repository
public class LaptopRepository {
    @Autowired
    private LaptopCrudRepository laptopCrudRepository;

    public List<Laptop> getAll() {
        return laptopCrudRepository.findAll();
    }

    public Optional<Laptop> getLaptop(int id) {
        return laptopCrudRepository.findById(id);
    }
    public Laptop create(Laptop laptop) {
        return laptopCrudRepository.save(laptop);
    }

    public void update(Laptop laptop) {
        laptopCrudRepository.save(laptop);
    }
    
    public void delete(Laptop laptop) {
        laptopCrudRepository.delete(laptop);
    }
}
