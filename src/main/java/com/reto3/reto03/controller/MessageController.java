package com.reto3.reto03.controller;


import com.reto3.reto03.entities.Message;
import com.reto3.reto03.service.MessagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {


    @Autowired
    private MessagesServices messagesServices;

    @GetMapping("/all")
    public List<Message> getAll() {
        return messagesServices.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save (@RequestBody Message m){

        return messagesServices.save(m);
    }
}
