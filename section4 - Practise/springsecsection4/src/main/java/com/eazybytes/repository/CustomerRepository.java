package com.eazybytes.repository;

import com.eazybytes.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//this class is a repository class that deals with the logic with database operation.
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    //extends CrudRepository for all operations.
    //<Customer- table that it is going to handle,datatype of primary key column>

    //abstract method.
    //this interface is to fetch the data from database.
    List<Customer> findByEmail(String email);
    //generate the business logic with an assumption that developer is going to pass
    //email in where condition.

}
