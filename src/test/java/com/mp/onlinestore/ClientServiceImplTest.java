package com.mp.onlinestore;

import com.mp.onlinestore.Exceptions.GenericException;
import com.mp.onlinestore.dao.ClientDao;
import com.mp.onlinestore.model.Client;
import com.mp.onlinestore.service.impl.ClientServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.Collections;

public class ClientServiceImplTest {

    @InjectMocks
    private ClientServiceImpl unit;

    @Mock
    private ClientDao clientDaoMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createClientTest() throws GenericException {
        Client clientDB = new Client(1,null, null, null);

        Mockito.when(clientDaoMock.createClient(clientDB)).thenReturn(true);

        boolean res = unit.createClient(clientDB);

        Assert.assertTrue(res);

        Mockito.verify(clientDaoMock, Mockito.times(1)).createClient(clientDB);
        Mockito.verifyNoMoreInteractions(clientDaoMock);
    }

    @Test
    public void createClientTest_Negative() throws GenericException {
        Client clientDB = new Client(1,null, null, null);

        Mockito.when(clientDaoMock.createClient(clientDB)).thenReturn(false);

        boolean res = unit.createClient(clientDB);

        Assert.assertFalse(res);

        Mockito.verify(clientDaoMock, Mockito.times(1)).createClient(clientDB);
        Mockito.verifyNoMoreInteractions(clientDaoMock);
    }

    @Test
    public void findByIdTest() throws GenericException {
        long userId = 1;
        Client clientDB = new Client(userId, null, null, null);

        Mockito.when(clientDaoMock.findById(userId)).thenReturn(clientDB);

        Client client = unit.findById(userId);

        Assert.assertEquals(1, (long) client.getClientId());

        Mockito.verify(clientDaoMock, Mockito.times(1)).findById(userId);
        Mockito.verifyNoMoreInteractions(clientDaoMock);
    }

    @Test
    public void updateClientTest() throws GenericException {
        Client clientDB = new Client(1,null, null, null);

        Mockito.when(clientDaoMock.updateClient(clientDB)).thenReturn(true);

        boolean res = unit.updateClient(clientDB);

        Assert.assertTrue(res);

        Mockito.verify(clientDaoMock, Mockito.times(1)).updateClient(clientDB);
        Mockito.verifyNoMoreInteractions(clientDaoMock);
    }

    @Test
    public void deleteClientTest() throws GenericException {
        long userId = 1;

        Mockito.when(clientDaoMock.deleteClient(userId)).thenReturn(true);

        boolean res = unit.deleteClient(userId);

        Assert.assertTrue(res);

        Mockito.verify(clientDaoMock, Mockito.times(1)).deleteClient(userId);
        Mockito.verifyNoMoreInteractions(clientDaoMock);
    }

    @Test
    public void findAllTest() throws GenericException {
        Mockito.when(clientDaoMock.findAll()).thenReturn(Collections.EMPTY_LIST);

        Collection res = unit.findAll();

        Assert.assertNotNull(res);

        Mockito.verify(clientDaoMock, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(clientDaoMock);
    }
}
