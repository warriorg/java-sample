package me.warriorg.spring.jpa;

import lombok.extern.slf4j.Slf4j;
import me.warriorg.spring.jpa.model.Customer;
import me.warriorg.spring.jpa.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {

            repository.save(Customer.builder().firstName("Jack").lastName("Bauer").build());
            repository.save(Customer.builder().firstName("Chloe").lastName("O'Brian").build());
            repository.save(Customer.builder().firstName("Kim").lastName( "Bauer").build());
            repository.save(Customer.builder().firstName("David").lastName("Palmer").build());
            repository.save(Customer.builder().firstName("Michelle").lastName("Dessler").build());

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }
}
