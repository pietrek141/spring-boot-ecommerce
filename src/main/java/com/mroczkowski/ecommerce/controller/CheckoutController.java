package com.mroczkowski.ecommerce.controller;

import com.mroczkowski.ecommerce.dto.Purchase;
import com.mroczkowski.ecommerce.dto.PurchaseResponse;
import com.mroczkowski.ecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://angular-ecommerce-frontend.herokuapp.com")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    //autowired is not necessary when there is only one constructor
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
