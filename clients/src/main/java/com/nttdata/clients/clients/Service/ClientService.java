package com.nttdata.clients.clients.Service;

import java.util.List;

import com.nttdata.clients.clients.model.Client;

public interface ClientService {

    /**
    * search for bank customers
    *
    * @param idclient – search client by id
    * @return – returns bank customer id
    */
    Client getClinet(long idClient);

    /**
    * save bank customers
    *
    * @param client – save client process
    * @return – returns bank customer
    */
    void saveClinet(Client client);

    /**
     * save bank customers
     *
     * @param client – save client process
     * @return – returns bank customer
     */
    List<Client>getClients();


    boolean isEnterpriceClinet(long idClient);

    boolean isPersonalClinet(long idClient);

       /**
     * update bank clients
     *
     * @param client – update client data
     * @return – returns updated bank customer data
     */
    Client updateClinet(Client client);

    /**
     * remove bank customers
     *
     * @param idClient – removes client data
     */
    List<Client> deleteClient(long idClient);
    
}
