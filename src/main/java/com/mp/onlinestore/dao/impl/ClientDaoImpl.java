package com.mp.onlinestore.dao.impl;

import com.mp.onlinestore.exceptions.GenericException;
import com.mp.onlinestore.consts.ErrorCodes;
import com.mp.onlinestore.consts.JdbcConstants;
import com.mp.onlinestore.dao.ClientDao;
import com.mp.onlinestore.model.Client;
import com.mp.onlinestore.util.ConnectToDb;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Repository
@Qualifier("ClientDaoImpl")
public class ClientDaoImpl implements ClientDao {

	private final static String userTable = "\"client\"";

	static Logger log = Logger.getLogger(ClientDaoImpl.class.toString());

	@Override
	public Client createClient(final Client client) throws GenericException{
		log.info("Need to store client into db: " + client);

		Connection conn = ConnectToDb.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(String.format(JdbcConstants.CLIENT_SAVE_USER_QUERY, JdbcConstants.CLIENT_TABLE_NAME,
					client.getClientName(), client.getClientLogin(), client.getClientEmail()));
			int rowsInserted = st.executeUpdate();
			if (rowsInserted >= 1) {
				st.close();
				return client;
			} else {
				System.out.println("No clients were saved");
				st.close();
				return null;
			}
		} catch (SQLException e) {
			throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
		} finally {
			ConnectToDb.closeConnection(conn);
		}
//		return false;
	}

	@Override
	public Client findById(final Long userId) throws GenericException{
		log.info("Need to read client from db with ID: " + userId);

		Connection conn = ConnectToDb.getConnection();
		Client client = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(String.format(JdbcConstants.CLIENT_FIND_BY_ID_QUERY, JdbcConstants.CLIENT_TABLE_NAME, userId));
			if (!rs.next()) {
				System.out.println("No such client in DB");
				return null;
			} else {
				rs.beforeFirst();
				while (rs.next()) {
					String clientName = String.valueOf(rs.getString("clientName"));
					String clientLogin = String.valueOf(rs.getString("clientLogin"));
					String clientEmail = String.valueOf(rs.getString("clientEmail"));
					client = new Client(clientName, clientLogin, clientEmail);
				}
			}
			rs.first();
			rs.close();
			stmt.close();
		} catch (SQLException e) {
//            e.printStackTrace();
			throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
		} finally {
			ConnectToDb.closeConnection(conn);
		}
		return client;
	}

	@Override
	public Client updateClient(final Client client) throws GenericException{
		log.info("Need to update client into db with new attributes: " + client);
		Connection conn = ConnectToDb.getConnection();

		try {
			PreparedStatement st = conn.prepareStatement(String.format(JdbcConstants.CLIENT_UPDATE_USER_QUERY, JdbcConstants.CLIENT_TABLE_NAME,
					client.getClientName(), client.getClientLogin(), client.getClientEmail(), client.getClientId()));
			int rowsUpdated = st.executeUpdate();
			if (rowsUpdated >= 1) {
				st.close();
				return client;
			} else {
				System.out.println("No clients were updated");
				st.close();
				return null;
			}
		} catch (SQLException e) {
//            e.printStackTrace();
			throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
		} finally {
			ConnectToDb.closeConnection(conn);
		}
	}

	@Override
	public Client deleteClient(final Long clientId) throws GenericException{
		log.info("Need to delete client from db with ID: " + clientId);

		Client client = new Client();
		client.setClientId(clientId);

		Connection conn = ConnectToDb.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(String.format(JdbcConstants.CLIENT_DELETE_USER_BY_ID_QUERY, JdbcConstants.CLIENT_TABLE_NAME, clientId));
			int rowsDeleted = st.executeUpdate();
			if (rowsDeleted >= 1) {
				st.close();
				return client;
			} else {
				System.out.println("No clients were deleted");
				st.close();
				return null;
			}
		} catch (SQLException e) {
//            e.printStackTrace();
			throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
		} finally {
			ConnectToDb.closeConnection(conn);
		}
	}

	@Override
	public Collection<Client> findAll() throws GenericException { //throws MyNewException {
		List<Client> clientList = new ArrayList<Client>();

		Connection conn = ConnectToDb.getConnection();
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(JdbcConstants.CLIENT_FIND_ALL_QUERY);
			if (!rs.next()) {
				System.out.println("No clients in DB");
			} else {
				rs.beforeFirst();
				while (rs.next()) {
					int clientId = Integer.valueOf(rs.getString("clientId"));
					String clientName = String.valueOf(rs.getString("clientName"));
					String clientLogin = String.valueOf(rs.getString("clientLogin"));
					String clientEmail = String.valueOf(rs.getString("clientEmail"));
					Long productId = Long.valueOf(rs.getLong("productId"));
					clientList.add(new Client(clientId, clientName, clientLogin, clientEmail));
				}
			}
			rs.first();
			rs.close();
			stmt.close();
		} catch (SQLException e) {
//            e.printStackTrace();
			throw new GenericException(ErrorCodes.DB_TABLE_ERROR);
		} finally {
			ConnectToDb.closeConnection(conn);
		}
		return clientList;
	}
}
