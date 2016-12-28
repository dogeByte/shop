package com.jing.web;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jing.service.CartService;
import com.jing.service.OrderService;
import com.jing.vo.Client;
import com.jing.vo.Order;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class OrderAction extends ActionSupport implements ModelDriven<Order>, SessionAware {

	private static final long serialVersionUID = 352195079506415439L;
	private Order order = new Order();
	private Map<String, Object> session;
	private OrderService orderService;
	private CartService cartService;
	private Integer clientId;
	private Double total2;

	@Override
	public Order getModel() {
		return order;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public void setTotal2(Double total2) {
		this.total2 = total2;
	}

	@InputConfig(resultName = "addFailure")
	public String add() {
		Client client = (Client) session.get("client");
		order.setClient(client);
		order = orderService.add(order);
		cartService.clear(client.getId());
		return "addSuccess";
	}

	// 已登录用户查看自己的订单
	public String show() {
		Client client = (Client) session.get("client");
		List<Order> orders = orderService.findByClientId(client.getId());
		if (orders == null || orders.size() == 0) {
			return "showFailure";
		}
		client.setOrders(new HashSet<Order>(orders));
		session.put("client", client);
		return "showSuccess";
	}

	public String pay1() {
		if (this.payVerify()) {
			return "pay1Success";
		}
		return "payFailure";
	}

	public String pay2() {
		if (this.payVerify()) {
			orderService.pay(order.getId());
			this.addActionMessage("支付成功！");
			return "pay2Success";
		}
		return "payFailure";
	}

	private boolean payVerify() {
		Client client = (Client) session.get("client");
		order = orderService.findById(order.getId());
		if (order == null) {
			this.addActionError("订单不存在");
			return false;
		}
		if (!order.getClient().getId().equals(client.getId())) {
			this.addActionError("非本人订单");
			return false;
		}
		if ("1".equals(order.getState())) {
			this.addActionError("订单已支付");
			return false;
		}
		return true;
	}

	// 管理后台查看指定用户的订单
	public String findByClientId() {
		List<Order> orders = orderService.findByClientId(clientId);
		ActionContext.getContext().getValueStack().push(orders);
		return "findSuccess";
	}

	public String findAll() {
		List<Order> orders = orderService.findAll();
		ActionContext.getContext().getValueStack().push(orders);
		return "findSuccess";
	}

	public String find() {
		List<Order> orders = orderService.find(order, total2);
		ActionContext.getContext().getValueStack().push(orders);
		return "findSuccess";
	}

}
