package me.warriorg.spring.jpa.repository;

import me.warriorg.spring.jpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author warrior
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
