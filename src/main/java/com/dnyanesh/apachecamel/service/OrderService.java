package com.dnyanesh.apachecamel.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.dnyanesh.apachecamel.dto.Order;

@Service
public class OrderService {

	List<Order> list = new ArrayList<Order>();

	@PostConstruct
	public void initDatabase() {
		list.add(new Order(1, "order1", 1000d));
		list.add(new Order(2, "order2", 1100d));
		list.add(new Order(3, "order3", 1200d));
		list.add(new Order(4, "order4", 1400d));

	}

	public Order addOrder(Order order) {
		list.add(order);
		return order;
	}

	public List<Order> getOrders() {
		return list;
	}
}
