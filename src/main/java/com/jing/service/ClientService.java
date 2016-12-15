package com.jing.service;

import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.ClientDao;
import com.jing.utils.EmailUtils;
import com.jing.utils.Md5Utils;
import com.jing.vo.Cart;
import com.jing.vo.Client;

@Transactional
public class ClientService {

	private ClientDao clientDao;

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public void register(Client client) throws AddressException, MessagingException {
		client.setPassword(Md5Utils.md5(client.getPassword()));
		client.setState(0);
		client.setCode(UUID.randomUUID().toString());
		Cart cart = new Cart();
		cart.setClient(client);
		client.setCart(cart);
		String emailMsg = "尊敬的" + client.getUsername() + "您好，欢迎注册，请<a href='http://localhost/mall/client_activate?code="
				+ client.getCode() + "'" + ">点击这里激活</a>，如果链接无法点击，请将下面的网址复制至浏览器地址栏中打开。<br/>"
				+ "http://localhost/mall/client_activate?code=" + client.getCode();
		EmailUtils.sendEmail(client.getEmail(), emailMsg);
		clientDao.register(client);
	}

	public Client findByUsername(String username) {
		return clientDao.findByUsername(username);
	}
	
	public Client activate(String code) {
		return clientDao.activate(code);
	}

	public Client findByEmailAndPassword(String email, String password) {
		return clientDao.findByEmailAndPassword(email, Md5Utils.md5(password));
	}

	public Client findByUsernameAndPassword(String username, String password) {
		return clientDao.findByUsernameAndPassword(username, Md5Utils.md5(password));
	}

	public Client findById(Integer id) {
		return clientDao.findById(id);
	}

	public List<Client> findAll() {
		return clientDao.findAll();
	}

}
