package com.nttdata.clients.clients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.clients.clients.Service.ClientService;
import com.nttdata.clients.clients.model.Client;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping(value = "",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getClients(){
        return clientService.getClients();
    }


    @GetMapping(value = "/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public Client getClient(@PathVariable long id){
        return clientService.getClinet(id);
    }

    @PostMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> saveClinet(@RequestBody Client client){
        clientService.saveClinet(client);
        return clientService.getClients();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
        return clientService.getClients();
    }

    @GetMapping(value = "isEnterpriceClient/{idClient}",produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean isEnterpriceClient(@PathVariable long idClient){
        return clientService.isEnterpriceClinet(idClient);
    }

    @GetMapping(value = "isPersonalClient/{idClient}",produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean isPersonalClient(@PathVariable long idClient){
        return clientService.isPersonalClinet(idClient);
    }


    

    
}
