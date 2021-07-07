package com.dnyanesh.apachecamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dnyanesh.apachecamel.dto.Order;
import com.dnyanesh.apachecamel.service.OrderService;

@Component
public class OrderProcessor implements Processor {

	@Autowired
	private OrderService orderService;

	@Override
	public void process(Exchange exchange) throws Exception {
		orderService.addOrder(exchange.getIn().getBody(Order.class));

	}

}
