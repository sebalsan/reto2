/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2.service;

import Reto2.model.Laptop;
import Reto2.repository.LaptopRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> getAll() {
        return laptopRepository.getAll();
    }

    public Optional<Laptop> getLaptop(int id) {
        return laptopRepository.getLaptop(id);
    }

    public Laptop create(Laptop laptop) {
        if (laptop.getId()== null) {
            return laptopRepository.create(laptop);
        } else {
            Optional<Laptop> e = laptopRepository.getLaptop(laptop.getId());
            if(e.isEmpty()){
                return laptopRepository.create(laptop);
            }else{
                return laptop;
            }
        }
    }
        
    public Laptop update(Laptop laptop) {
        if (laptop.getId()!= null) {
            Optional<Laptop> e = laptopRepository.getLaptop(laptop.getId());
            if (!e.isEmpty()) {
                if (laptop.getBrand()!= null) {
                    e.get().setBrand(laptop.getBrand());
                }
                if (laptop.getModel() != null) {
                    e.get().setModel(laptop.getModel());
                }
                if (laptop.getProcesor() != null) {
                    e.get().setProcesor(laptop.getProcesor());
                }
                if (laptop.getOs() != null) {
                    e.get().setOs(laptop.getOs());
                }
                if (laptop.getDescription() != null) {
                    e.get().setDescription(laptop.getDescription());
                }
                if (laptop.getMemory() != null) {
                    e.get().setMemory(laptop.getMemory());
                }
                if (laptop.getHardDrive() != null) {
                    e.get().setHardDrive(laptop.getHardDrive());
                }
                if (laptop.getPrice() != 0.0) {
                    e.get().setPrice(laptop.getPrice());
                }
                if (laptop.getQuantity() != 0) {
                    e.get().setQuantity(laptop.getQuantity());
                }
                if (laptop.getPhotography() != null) {
                    e.get().setPhotography(laptop.getPhotography());
                }
                e.get().setAvailability(laptop.isAvailability());
                laptopRepository.update(e.get());
                return e.get();
            } else {
                return laptop;
            }
        } else {
            return laptop;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getLaptop(id).map(laptop -> {
            laptopRepository.delete(laptop);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
