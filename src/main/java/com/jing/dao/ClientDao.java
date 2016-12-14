package com.jing.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jing.utils.DaoUtils;
import com.jing.vo.Client;

public class ClientDao extends HibernateDaoSupport {

	public void register(Client client) {
		this.getHibernateTemplate().save(client);
	}

	public Client findByUsername(String username) {
		return DaoUtils.findBySql(this.getHibernateTemplate(), "from Client where username=?", username);
	}

	public Client activate(String code) {
		Client client = DaoUtils.findBySql(this.getHibernateTemplate(), "from Client where code=?", code);
		if (client == null || client.getId() == null) {
			return null;
		}
		client.setState(1);
		return client;
	}

	public Client findByEmailAndPassword(String email, String password) {
		return DaoUtils.findBySql(this.getHibernateTemplate(), "from Client where email=? and password=?", email,
				password);
	}

	public Client findByUsernameAndPassword(String username, String password) {
		return DaoUtils.findBySql(this.getHibernateTemplate(), "from Client where username=? and password=?", username,
				password);
	}

	public Client findById(Integer id) {
		return DaoUtils.findBySql(this.getHibernateTemplate(), "from Client where id=?", id);
	}

	@SuppressWarnings("unchecked")
	public List<Client> findAll() {
		return this.getHibernateTemplate().find("from Client");
	}

}
