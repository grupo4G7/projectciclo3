package com.reto3.reto03.controller;


import com.reto3.reto03.entities.Message;
import com.reto3.reto03.service.MessagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {


    @Autowired
    private MessagesServices messagesServices;

    @GetMapping("/all")
    public List<Message> getAll() {
        return messagesServices.getAll();
    }


    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int messageId) {
        return messagesServices.getMessage(messageId);}


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save (@RequestBody Message m){

        return messagesServices.save(m);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message m) {
        return messagesServices.update(m);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return messagesServices.delete(messageId); }
}
