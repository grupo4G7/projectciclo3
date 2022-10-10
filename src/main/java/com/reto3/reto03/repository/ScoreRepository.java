package com.reto3.reto03.repository;


import com.reto3.reto03.entities.Reservation;
import com.reto3.reto03.entities.Score;
import com.reto3.reto03.repository.crudRepository.ReservationCrudRepository;
import com.reto3.reto03.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score p){
        return scoreCrudRepository.save(p);
    }
    public void delete(Score p){scoreCrudRepository.delete(p);
    }
}
