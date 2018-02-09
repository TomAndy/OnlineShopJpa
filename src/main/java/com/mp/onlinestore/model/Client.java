package com.mp.onlinestore.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="clients")
public class Client implements Serializable {

	private static final long serialVersionUID = -6507164137525885741L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Long clientId;

	@Column(name = "client_login")
	private String clientLogin;

	@Column(name = "client_name")
	private String clientName;

	@Column(name = "client_email")
	private String clientEmail;

	@OneToMany(mappedBy = "client", targetEntity = Order.class)
	private Collection<Order> orderList;

	public Collection<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Collection<Order> orderList) {
		this.orderList = orderList;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(final Long clientId) {
		this.clientId = clientId;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(final String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientLogin() {
		return clientLogin;
	}

	public void setClientLogin(String clientLogin) {
		this.clientLogin = clientLogin;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final Client client = (Client) o;

		if (clientId != null ? !clientId.equals(client.clientId) : client.clientId != null) return false;
		if (clientEmail != null ? !clientEmail.equals(client.clientEmail) : client.clientEmail != null) return false;
		if (clientEmail != null ? !clientName.equals(client.clientName) : client.clientName != null) return false;
		return clientLogin != null ? clientLogin.equals(client.clientLogin) : client.clientLogin == null;
	}

	@Override
	public int hashCode() {
		int result = clientId != null ? clientId.hashCode() : 0;
		result = 31 * result + (clientEmail != null ? clientEmail.hashCode() : 0);
		result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
		result = 31 * result + (clientLogin != null ? clientLogin.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Client{");
		sb.append("clientId=").append(clientId);
		sb.append(", clientEmail='").append(clientEmail).append('\'');
		sb.append(", clientName='").append(clientName).append('\'');
		sb.append(", clientLogin='").append(clientLogin).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public Client(long clientId, String clientName, String clientLogin, String clientEmail) {
		this.clientId = clientId;
		this.clientLogin = clientLogin;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
	}

	public Client(String clientName, String clientLogin, String clientEmail) {
		this.clientLogin = clientLogin;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
	}

	public Client() {};
}
