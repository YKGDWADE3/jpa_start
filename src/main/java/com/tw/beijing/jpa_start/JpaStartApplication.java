package com.tw.beijing.jpa_start;

import com.tw.beijing.jpa_start.entity.Customer;
import com.tw.beijing.jpa_start.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaStartApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JpaStartApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(JpaStartApplication.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            LOGGER.info("Customers found with findAll():");
            LOGGER.info("-------------------------------");
            Iterable<Customer> all = repository.findAll();
            for (Customer customer : all) {
                LOGGER.info(customer.toString());
            }
            LOGGER.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        LOGGER.info("Customer found with findById(1L):");
                        LOGGER.info("--------------------------------");
                        LOGGER.info(customer.toString());
                        LOGGER.info("");
                    });

            // fetch customers by last name
            LOGGER.info("Customer found with findByLastName('Bauer'):");
            LOGGER.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                LOGGER.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	LOGGER.info(bauer.toString());
            // }
            LOGGER.info("");
        };
    }
}
