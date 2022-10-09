package com.reto3.reto03.service;

import com.reto3.reto03.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MessagesServices {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages(){
        return MessageRepository.getAll();
    }

    public List<Message> getMessageByDates(int start, int end){
        return messageRepository.getMessagesByDates(start, end);
    }

    public Optional<Message> getMessage(int isbn){
        return messageRepository.getMessage(isbn);
    }

    public Message insertMessage(Message message){
        if(message.getIsbn() != null){
            Optional<Message> temp = messageRepository.getMessage( message.getIsbn() );
            if( temp.isEmpty() )
                if(message.getTitle() != null && message.getRegister_date() != null && message.getEditorial_fk() != null)
                    return messageRepository.save(message);
                else
                    return message;
            else
                return message;
        }
        else
            return message;
    }

    public Message updateMessage(Message message){
        if(message.getIsbn() != null){
            Optional<Message> temp = messageRepository.getMessage( message.getIsbn() );
            if( !temp.isEmpty() ){
                if(message.getYear() != null)
                    temp.get().setYear( message.getYear() );
                if(message.getAuthors() != null)
                    temp.get().setAuthors( message.getAuthors() );
                return messageRepository.save( temp.get() );
            }
            else
                return message;
        }
        else
            return message;
    }

    public Boolean delete(int isbn){
        Boolean success = messageRepository.getMessage(isbn).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return success;
    }

}
