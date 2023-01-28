package com.example.billingservice.mappers;

import com.example.billingservice.dtos.CustomerDTO;
import com.example.billingservice.dtos.ProductDTO;
import com.example.billingservice.dtos.ProductItemDTO;
import com.example.billingservice.entities.ProductItem;
import com.example.billingservice.model.Customer;
import com.example.billingservice.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BillServiceMapper {
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        return customerDTO;
    }
    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;
    }
    public ProductDTO fromProduct(Product product){
        ProductDTO productDTO=new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        return productDTO;
    }
    public Product fromProductDTO(ProductDTO productDTO){
        Product product=new Product();
        BeanUtils.copyProperties(productDTO,product);
        return product;
    }

    public ProductItemDTO fromProductItem(ProductItem productItem){
        ProductItemDTO productItemDTO=new ProductItemDTO();
        BeanUtils.copyProperties(productItem,productItemDTO);
        return productItemDTO;
    }
    public ProductItem fromProductItemDTO(ProductItemDTO productItemDTO){
        ProductItem productItem=new ProductItem();
        BeanUtils.copyProperties(productItemDTO,productItem);
        return productItem;
    }
}
