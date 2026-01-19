package cz.ivosahlik.controller;

import cz.ivosahlik.dto.CoffeeOrderDTO;
import cz.ivosahlik.service.CoffeeOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/coffee_orders")
@Validated
public class CoffeeOrderController {
    private CoffeeOrderService coffeeOrderService;

    public CoffeeOrderController(CoffeeOrderService coffeeOrderService) {
        this.coffeeOrderService = coffeeOrderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrderDTO newOrder(@Valid @RequestBody CoffeeOrderDTO coffeeOrderDTO){
        return coffeeOrderService.newOrder(coffeeOrderDTO);
    }
}
