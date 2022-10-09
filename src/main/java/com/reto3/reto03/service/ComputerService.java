package com.reto3.reto03.service;

import com.reto3.reto03.entities.Computer;
import com.reto3.reto03.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAll(){
        return computerRepository.getAll();
    }
    public Optional<Computer> getComputer(int id){
        return computerRepository.getComputer(id);
    }
    public Computer save(Computer p){
        if (p.getId()==null){
            return computerRepository.save(p);
        }else {
            Optional<Computer> e = computerRepository.getComputer(p.getId());
            if (e.isPresent()){
                return p;
            }else {
                return computerRepository.save(p);
            }
        }
    }
    public Computer update(Computer p){
        if (p.getId()!=null) {
            Optional<Computer> q = computerRepository.getComputer(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null && p.getName().length() <= 45) {
                    q.get().setName(p.getName());
                }
                if (p.getDescription() != null && p.getDescription().length() <= 250) {
                    q.get().setDescription(p.getDescription());
                }
                if (p.getBrand() != null && p.getBrand().length() <= 45) {
                    q.get().setBrand(p.getBrand());
                }
                if (p.getCategory() != null) {
                    q.get().setCategory(p.getCategory());
                }
                if (p.getYear() != null && p.getYear() >= 1000 && p.getYear() <= 9999) {
                    q.get().setYear(p.getYear());
                }
                computerRepository.save((q.get()));
                return q.get();
            } else {
                return p;
            }
            }else {
                return p;
            }
        }

        public boolean delete(int id){
        boolean success = computerRepository.getComputer(id).map(computer -> {
            computerRepository.delete(computer);
            return true;
        }).orElse(false);
        return success;
        }
    }
