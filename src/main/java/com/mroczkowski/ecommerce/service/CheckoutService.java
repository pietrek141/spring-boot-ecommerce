package com.mroczkowski.ecommerce.service;

import com.mroczkowski.ecommerce.dto.Purchase;
import com.mroczkowski.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
