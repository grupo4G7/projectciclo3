package com.reto3.reto03.controller;

import com.reto3.reto03.entities.Score;
import com.reto3.reto03.service.ScoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreServices scoreServices;

    @GetMapping("/aLL")
    public List<Score> getAll() {
        return scoreServices.getAll();
    }

    @PostMapping("/save")
    public Score save(@RequestBody Score p) {
        return scoreServices.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score s) {
        return scoreServices.update(s);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int scoreId) { return scoreServices.delete(scoreId); }

}
