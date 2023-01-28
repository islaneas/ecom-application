package com.example.billingservice.services;

import com.example.billingservice.entities.Bill;
import com.example.billingservice.entities.ProductItem;

import java.util.List;

public interface BillService {
    ProductItem saveProductItem(ProductItem productItem);
    Bill saveBill(Bill bill);
    Bill getBill(Long id);
    List<ProductItem> getProductsItems(Long id);
    List<Bill> getBills();
    List<Bill> getCustomerBills(Long customerId);
}
