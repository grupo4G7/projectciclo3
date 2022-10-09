package com.reto3.reto03.controller;

import com.reto3.reto03.entities.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/aLL")
    public List<Score> getAll() {
        return scoreService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score p) {
        return scoreService.save(p);
    }

}
