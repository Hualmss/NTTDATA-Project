package com.nttdata.clients.clients.Service;

import java.util.List;

import com.nttdata.clients.clients.model.Client;

public interface ClientService {

    Client getClinet(long idClient);

    void saveClinet(Client client);

    List<Client>getClients();

    boolean isEnterpriceClinet(long idClient);

    boolean isPersonalClinet(long idClient);

    Client updateClinet(Client client);

    List<Client> deleteClient(long idClient);
    
}
