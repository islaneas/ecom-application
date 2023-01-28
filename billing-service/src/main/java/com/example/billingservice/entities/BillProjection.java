package com.example.billingservice.entities;

import com.example.billingservice.enums.BillStatus;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name="fullbill",types=Bill.class)
public interface BillProjection {
    Long getId() ;
    Date getBilldate();
    Long getCustomerId();
    BillStatus getStatus();
}
