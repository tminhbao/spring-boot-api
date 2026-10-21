package com.alantr.springboot;

import com.alantr.springboot.bean.Chef;
import com.alantr.springboot.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext; // nơi lấy được cái Bean được khởi tạo, kho của tất cả các bean
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String ...args) throws Exception {
		System.out.println("Check Singleton Scope");
		Chef chef1 = applicationContext.getBean(Chef.class);
		Chef chef2 = applicationContext.getBean(Chef.class);
		System.out.println("Chef1 === Chef2 ? " + (chef1 == chef2));

		System.out.println("Check Prototype Scope");
		Order order1 = applicationContext.getBean(Order.class);
		Order order2 = applicationContext.getBean(Order.class);
		System.out.println("Order1 === Order2 ? " + (order1 == order2));
	}

}
