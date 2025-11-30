package com.aureus.cattlemanagement;

import org.springframework.boot.SpringApplication;

public class TestCattleManagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(CattleManagementApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
