package com.mp.onlinestore;

import com.mp.onlinestore.dao.ClientDao;
import com.mp.onlinestore.dao.impl.ClientDaoImpl;
import com.mp.onlinestore.model.Client;
import com.mp.onlinestore.util.ConnectToDb;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.mockito.Mockito.any;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ConnectToDb.class)
public class ClientDaoImplTest {

    @InjectMocks
    private ClientDaoImpl unit;

    @Mock
    private ClientDao clientDaoMock;

    @Mock
    private Connection c;

    @Mock
    private PreparedStatement stmt;

    @Mock
    private Statement stm;

    @Mock
    private ResultSet rs;

    private Client client;

    @Before
    public void setup() throws Exception{
        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(ConnectToDb.class);
        PowerMockito.when(ConnectToDb.getConnection()).thenReturn(c);
        Mockito.when(c.prepareStatement(any(String.class))).thenReturn(stmt);
        Mockito.when(c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)).thenReturn(stm);
    }

    @Test
    public void createClientTest() throws Exception {
        client = new Client(1, null, null, null);
        Mockito.when(stmt.executeUpdate()).thenReturn(1);
        Client res = unit.createClient(client);
        Assert.assertNotNull(res);
    }

    @Test
    public void createClientTest_Negative() throws Exception {
        client = new Client(1, null, null, null);
        Mockito.when(stmt.executeUpdate()).thenReturn(0);
        Client res = unit.createClient(client);
        Assert.assertNull(res);
    }

    @Test
    public void findByIdTest() throws Exception {
        long userId=1;
        Mockito.when(stm.executeQuery(any(String.class))).thenReturn(rs);

        Mockito.when(rs.next()).thenReturn(true, false);
        Mockito.when(rs.getString("userName")).thenReturn("AAA");
        Mockito.when(rs.getString("login")).thenReturn("BBB");
        Mockito.when(rs.getString("email")).thenReturn("CCC");
        client = unit.findById(userId);
        System.out.println(client);

    }

}
