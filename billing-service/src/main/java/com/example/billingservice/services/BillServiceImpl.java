package com.example.billingservice.services;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.ProductItem;
import com.example.billingservice.exceptions.BillNotFoundException;
import com.example.billingservice.exceptions.CustomerNotFoundException;
import com.example.billingservice.mappers.BillServiceMapper;
import com.example.billingservice.model.Customer;
import com.example.billingservice.repository.BillRepository;
import com.example.billingservice.repository.ProductItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BillServiceImpl {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private BillServiceMapper mapperDTO;

    //@Override
    public ProductItem saveProductItem(ProductItem productItem) {
        return productItemRepository.save(productItem);
    }

    //@Override
    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    //@Override
    public Bill getBill(Long id) {
        Bill bill=billRepository.findById(id).orElse(null);
        if (bill==null) throw new BillNotFoundException("Bill not Found");
        Customer customer=customerRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        //product
        bill.setProductItems(this.getProductsItems(bill.getId()));
        return bill;
    }

    //@Override
    public List<ProductItem> getProductsItems(Long id) {
        return billRepository.findById(id).get().getProductItems();
    }
    //@Override
    public List<Bill> getBills() {
        return billRepository.findAll();
    }

    //@Override
    public List<Bill> getCustomerBills(Long customerId) {
        Customer customer=customerRestClient.findCustomerById(customerId);
        if(customer==null) throw new CustomerNotFoundException("Customer Not Found");
        return billRepository.findByCustomerId(customerId);
    }
}
