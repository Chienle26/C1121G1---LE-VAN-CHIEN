package com.chienle.controller;

import com.chienle.model.Customer;
import com.chienle.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public ResponseEntity<Page<Customer>> pageCustomer(@PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customers = this.iCustomerService.findAll(pageable);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> goListCustomer() {
        List<Customer> customers = this.iCustomerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Integer id) {
        Customer customer = this.iCustomerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
        this.iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        if (this.iCustomerService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        if (this.iCustomerService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.iCustomerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
