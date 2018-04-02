package com.mp.onlinestore.dao.impl;

import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.dao.ClientDao;
import com.mp.onlinestore.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@Transactional
@Repository("ClientDaoImplJpa")
@Qualifier("ClientDaoImplJpa")
public class ClientDaoImplJpa implements ClientDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Client createClient(Client client) throws GenericException {
        entityManager.persist(client);
        return client;
    }

    @Override
    public Client findById(Long clientId) throws GenericException {
        return entityManager.find(Client.class, clientId);
    }

    @Override
    public Client updateClient(Client client) throws GenericException {
        Client clientNew = entityManager.find(Client.class, client.getClientId());

        if(clientNew != null)
        {
            clientNew.setClientLogin(client.getClientLogin());
            clientNew.setClientName(client.getClientName());
            clientNew.setClientEmail(client.getClientEmail());
//            userNew.setProductId(user.getProductId());
            entityManager.persist(clientNew);
            return clientNew;
        }
        else return null;
    }

    @Override
    public Client deleteClient(Long clientId) throws GenericException {
        Client clientNew = entityManager.find(Client.class, clientId);
        Client deletedClient = new Client();
        deletedClient.setClientId(clientId);
        if(clientNew != null)
        {
            entityManager.remove(clientNew);
            return deletedClient;
        }
        else return null;
    }

    @Override
    public Collection<Client> findAll() throws GenericException {
        String hql = "FROM Client as atcl ORDER BY atcl.clientId";
        return (List<Client>) entityManager.createQuery(hql).getResultList();
    }
}
