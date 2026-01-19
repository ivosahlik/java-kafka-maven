package cz.ivosahlik.util;

import cz.ivosahlik.domain.generated.*;
import cz.ivosahlik.domain.generated.Address;
import cz.ivosahlik.domain.generated.CoffeeOrder;
import cz.ivosahlik.domain.generated.OrderId;
import cz.ivosahlik.domain.generated.OrderLineItem;
import cz.ivosahlik.domain.generated.Size;
import cz.ivosahlik.domain.generated.Store;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Random;

public class CoffeeOrderUtil {

    public static CoffeeOrder buildNewCoffeeOrder(){
        var orderId=   OrderId.newBuilder()
                .setId(randomId())
                .build();

        return CoffeeOrder.newBuilder()
                .setId(orderId)
               // .setId(UUID.randomUUID())
                .setName("Ivo Vošahlík")
                //.setNickName("DS")
               // .setFullName("Ivo Vošahlík")
                .setStore(generateStore())
                .setOrderLineItems(generateOrderLineItems())
                .setOrderedTime(Instant.now())
                //.setPickUp(PickUp.IN_STORE)
                //.setPickUpType(PickUp.IN_STORE)
                .build();


    }

//    public static CoffeeOrderOld buildNewCoffeeOrderV2(){
//
//        return CoffeeOrderOld.newBuilder()
//                .setId(randomId())
//                .setName("Prague 1234")
//                .setStore(generateStore())
//                .setOrderLineItems(generateOrderLineItems())
//                .build();
//
//
//    }

    private static List<OrderLineItem> generateOrderLineItems() {

        var orderLineItem = OrderLineItem.newBuilder()
                .setName("Caffe Latte")
                .setQuantity(1)
                .setSize(Size.MEDIUM)
                .setCost(BigDecimal.valueOf(3.99))
                .build();

        return List.of(orderLineItem);

    }

    private static Store generateStore(){

        return  Store.newBuilder()
                .setId(randomId())
                .setAddress(buildAddress())
                .build();
    }

    private static Address buildAddress() {

        return Address.newBuilder()
                .setAddressLine1("1234 Address Line 1")
                .setCity("Prague")
                .setStateProvince("IL")
                .setZip("12345")
                .build();

    }

    public static int randomId(){
        Random random = new Random();
        return random.nextInt(1000);
    }
}
