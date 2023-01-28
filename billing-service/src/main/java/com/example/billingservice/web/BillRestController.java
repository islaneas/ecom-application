package com.example.billingservice.web;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.repository.BillRepository;
import com.example.billingservice.repository.ProductItemRepository;
import com.example.billingservice.services.BillService;
import com.example.billingservice.services.CustomerRestClient;
import com.example.billingservice.services.ProductRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public class BillRestController {
    /* @Autowired
     private BillRepository billRepository;
     @Autowired
     private ProductItemRepository productItemRepository;
     @Autowired
     private CustomerRestClient customerRestClient;
     @Autowired
     private ProductRestClient productRestClient;

     /*@GetMapping("/fullBill/{id}")
     public Bill bill(@PathVariable Long id){
         Bill bill=billRepository.findById(id).get();
         bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
         bill.getProductItems().forEach(pi->{
             pi.setProduct(productRestClient.findProductById(pi.getProductId()));
         });
         return bill;
     }*/
    private BillService billService;

    public BillRestController(BillService billService ) {
        this.billService = billService;
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('USER')")
    public List<Bill> bills(){
        return billService.getBills();
    }

    @GetMapping("/fullbill/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Bill bill(@PathVariable Long id){
        Bill bill=billService.getBill(id);
        return bill;
    }
    @GetMapping("/byCustomerId/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    List<Bill> findByCustomerId(@PathVariable Long id){
        return billService.getCustomerBills(id);
    }

}
