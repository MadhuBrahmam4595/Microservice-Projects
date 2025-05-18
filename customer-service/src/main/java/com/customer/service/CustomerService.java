package com.customer.service;

import com.customer.entity.Customer;
import com.customer.exception.CustomerAlreadyAvailableException;
import com.customer.exception.CustomerNotFoundException;
import com.customer.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public Customer saveCustomer(Customer customer){
        Optional<Customer> byEmail = customerRepo.findByEmail(customer.getEmail());
        if(byEmail.isPresent()) throw new CustomerAlreadyAvailableException(customer.getEmail());
        return customerRepo.save(customer);
    }

    public Optional<Customer> getById(Long id){
        Optional<Customer> byId = customerRepo.findById(id);
        if(byId.isEmpty()) throw new CustomerNotFoundException(String.valueOf(id));
        return customerRepo.findById(id);
    }

    public String deleteCustomerById(Long id){
        Optional<Customer> byId = customerRepo.findById(id);
        if(byId.isPresent()){
            customerRepo.deleteById(id);
            return "Customer deleted successfully for id:"+id;
        }else{
            throw new RuntimeException("No user found");
        }
    }

    public Customer updateCustomer(Customer customer, Long id){
        Optional<Customer> byId = customerRepo.findById(id);
        if(byId.isEmpty()){
            throw new RuntimeException("No user found");
        }
        byId.get().setEmail(customer.getEmail());
        byId.get().setName(customer.getName());
        byId.get().setLocation(customer.getLocation());
        return customerRepo.save(byId.get());
    }
}
