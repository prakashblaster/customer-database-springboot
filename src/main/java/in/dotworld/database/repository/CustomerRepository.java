package in.dotworld.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.dotworld.database.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
