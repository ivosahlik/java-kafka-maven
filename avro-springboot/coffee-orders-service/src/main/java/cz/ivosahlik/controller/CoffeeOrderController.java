package cz.ivosahlik.controller;

import cz.ivosahlik.dto.CoffeeOrderDTO;
import cz.ivosahlik.dto.CoffeeOrderUpdateDTO;
import cz.ivosahlik.service.CoffeeOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/coffee_orders")
@Validated
public class CoffeeOrderController {
    private final CoffeeOrderService coffeeOrderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrderDTO newOrder(@Valid @RequestBody CoffeeOrderDTO coffeeOrderDTO) {
        return coffeeOrderService.newOrder(coffeeOrderDTO);
    }

    @PutMapping("/{order_id}")
    @ResponseStatus(HttpStatus.OK)
    public CoffeeOrderUpdateDTO updateCoffeeOrder(
            @PathVariable("order_id") String orderId, @Valid @RequestBody CoffeeOrderUpdateDTO coffeeOrderUpdateDTO) {
        log.info("Received Request for an order");
        return coffeeOrderService.updateOrder(orderId, coffeeOrderUpdateDTO);
    }
}
