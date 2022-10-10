package com.reto3.reto03.service;

import com.reto3.reto03.entities.Client;
import com.reto3.reto03.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client c){
        if (c.getIdClient()==null){
            return clientRepository.save(c);
        }else {
            Optional<Client> e = clientRepository.getClient(c.getIdClient());
            if (e.isPresent()){

                return  c;
            }else {
                return clientRepository.save(c);
            }
        }
    }
    public Client update(Client c){
        if (c.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(c.getIdClient());
            if (q.isPresent()){
                if (c.getName()!=null){
                    q.get().setName(c.getName());
                }
                clientRepository.save(q.get());
                return q.get();
            }else {
                return c;
            }
        }else {
            return c;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Client>c= clientRepository.getClient(id);
        if (c.isPresent()){
            clientRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
