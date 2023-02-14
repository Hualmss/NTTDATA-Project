package com.nttdata.clients.clients.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.clients.clients.model.Client;
import com.nttdata.clients.clients.repository.ClientRepository;


import static com.nttdata.clients.clients.util.ClientType.ENTERPRICE_CLIENT;
import static com.nttdata.clients.clients.util.ClientType.PERSONAL_CLIENT;;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getClinet(long idClient) {
        Optional<Client> clientOptional = clientRepository.findById(idClient);
        if(clientOptional.isPresent()){
            return clientOptional.get();
        }
        return null;
    }


    /*
    TODO: verificar si es necesario buscar al cliente  en la BD por ID para evitar una actualizacion
    */
    @Override
    public void saveClinet(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public boolean isEnterpriceClinet(long idClient) {
        Optional<Client> optionalClient = clientRepository.findById(idClient);
        if(optionalClient.isPresent() && optionalClient.get().getClinetTypeId()==ENTERPRICE_CLIENT){
            return true;
        }
        return false;
    }

    @Override
    public boolean isPersonalClinet(long idClient) {
        Optional<Client> optionalClient = clientRepository.findById(idClient);
        if(optionalClient.isPresent() && optionalClient.get().getClinetTypeId()==PERSONAL_CLIENT){
            return true;
        }
        return false;
    }

    @Override
    public Client updateClinet(Client client) {
        Optional<Client> clientOptional = clientRepository.findById(client.getClinetId());
        if(clientOptional.isPresent()){
            return clientRepository.save(client);
        }
        return null;
    }

    @Override
    public List<Client> deleteClient(long idClient) {
        Optional<Client> clientOptional = clientRepository.findById(idClient);
        if(clientOptional.isPresent()){
            clientRepository.deleteById(idClient);
            return clientRepository.findAll();
        }
        return null;
    }
    
}
