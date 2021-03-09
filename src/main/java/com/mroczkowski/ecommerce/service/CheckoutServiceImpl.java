package com.mroczkowski.ecommerce.service;

import com.mroczkowski.ecommerce.dao.CustomerRepo;
import com.mroczkowski.ecommerce.dto.Purchase;
import com.mroczkowski.ecommerce.dto.PurchaseResponse;
import com.mroczkowski.ecommerce.entity.Address;
import com.mroczkowski.ecommerce.entity.Customer;
import com.mroczkowski.ecommerce.entity.Order;
import com.mroczkowski.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepo customerRepo;

    public CheckoutServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve the order info from dto
        Order order = purchase.getOrder();
        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();

        String theEmail = customer.getEmail();

        Customer customerFromDB = customerRepo.findByEmail(theEmail);

        if (customerFromDB != null) {
            customer = customerFromDB;
        }

        customer.add(order);

        //save to the database
        customerRepo.save(customer);

        //return a response

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
