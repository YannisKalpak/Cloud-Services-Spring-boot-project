package com.example.demoDealership;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DealershipRepository dealershipRepository;
   
    @Autowired
	 private DealershipService ds;
    
    @PostMapping("/signup/customer")
    public String signupCustomer(@RequestBody Customer customer) {
        if (customer.getId() == null || customer.getName() == null || customer.getLastname() == null || customer.getEmail() == null || customer.getPassword() == null) {
            return "All fields (id, name, lastname, email, password) are required.";
        }
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            return "Customer email already exists.";
        }
        customer.setPassword((customer.getPassword()));
        customerRepository.save(customer);
        return "Customer signed up successfully.";
    }

    @PostMapping("/signup/dealership")
    public String signupDealership(@RequestBody Dealership dealership) {
        if (dealership.getId() == null || dealership.getName() == null || dealership.getEmail() == null || dealership.getPassword() == null) {
            return "All fields (id, name, email, password) are required.";
        }
        if (dealershipRepository.findByEmail(dealership.getEmail()).isPresent()) {
            return "Dealership email already exists.";
        }
        dealership.setPassword((dealership.getPassword()));
        dealershipRepository.save(dealership);
        return "Dealership signed up successfully.";
    }

    @PostMapping("/login/customer")
    public String loginCustomer(@RequestBody Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findByEmail(customer.getEmail());
        if (existingCustomer.isPresent() && customer.getPassword().equals(existingCustomer.get().getPassword())) {
            return "Customer login successful.";
        }
        return "Invalid email or password.";
    }

    @PostMapping("/login/dealership")
    public String loginDealership(@RequestBody Dealership dealership) {
        Optional<Dealership> existingDealership = dealershipRepository.findByEmail(dealership.getEmail());
        if (existingDealership.isPresent() && dealership.getPassword().matches(existingDealership.get().getPassword())) {
            return "Dealership login successful.";
        }
        return "Invalid email or password.";
   
    }
   
    @GetMapping(path = "/dealership/customers")
	  public List<Customer> getAllCustomers() throws Exception {
	      return ds.getAllCustomers();
	 }
}
