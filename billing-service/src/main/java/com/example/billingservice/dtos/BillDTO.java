package com.example.billingservice.dtos;

import com.example.billingservice.enums.BillStatus;

import java.util.Date;

public class BillDTO {
    private Long id ;
    private Date billdate;
    private BillStatus status;
    private Long customerId;
    private double total;
}
