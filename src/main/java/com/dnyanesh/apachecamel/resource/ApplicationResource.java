package com.dnyanesh.apachecamel.resource;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.dnyanesh.apachecamel.dto.Order;
import com.dnyanesh.apachecamel.processor.OrderProcessor;
import com.dnyanesh.apachecamel.service.OrderService;

@Component
public class ApplicationResource extends RouteBuilder {

	@Autowired
	private OrderService orderService;

	@BeanInject
	private OrderProcessor orderProcessor;

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);

		rest().get("/hello").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.setBody(constant("Welcome to Apache Camel.."));

		rest().get("/getorders").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.setBody(constant(orderService.getOrders()));

		rest().post("/addorder").consumes(MediaType.APPLICATION_JSON_VALUE).type(Order.class).outType(Order.class)
				.route().process(orderProcessor).endRest();
	}

}
