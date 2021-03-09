package com.mroczkowski.ecommerce.dto;

import com.mroczkowski.ecommerce.entity.Address;
import com.mroczkowski.ecommerce.entity.Customer;
import com.mroczkowski.ecommerce.entity.Order;
import com.mroczkowski.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address billingAddress;
    private Address shippingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
