package com.reto3.reto03.service;

import com.reto3.reto03.entities.Message;
import com.reto3.reto03.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessagesServices {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message m){
        if(m.getIdMessage() == null) {
            return messageRepository.save(m);
        }else
        { Optional<Message> messageubicado = getMessage(m.getIdMessage());
                if(messageubicado.isEmpty()){
                    return messageRepository.save(m);
                }
                else {
                    return m;
                }
        }
    }

    public Message update (Message m){
        if(m.getIdMessage()!= null) {
            Optional<Message> messageubicado = getMessage(m.getIdMessage());
            if (!messageubicado.isEmpty()) {
                if (m.getMessageText()!= null) {
                    messageubicado.get().setMessageText(m.getMessageText());
                }
                return messageRepository.save(messageubicado.get());
            }
        }
                return m;
    }

    public Boolean delete(int id){
        Boolean success = getMessage(id).map(m -> {
            messageRepository.delete(m);
            return true;
        }).orElse(false);
        return success;
    }

}
