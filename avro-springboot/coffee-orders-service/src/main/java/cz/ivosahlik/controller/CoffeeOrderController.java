package cz.ivosahlik.controller;

import cz.ivosahlik.dto.CoffeeOrderDTO;
import cz.ivosahlik.service.CoffeeOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/coffee_orders")
@Validated
public class CoffeeOrderController {
    private final CoffeeOrderService coffeeOrderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrderDTO newOrder(@Valid @RequestBody CoffeeOrderDTO coffeeOrderDTO){
        return coffeeOrderService.newOrder(coffeeOrderDTO);
    }
}
