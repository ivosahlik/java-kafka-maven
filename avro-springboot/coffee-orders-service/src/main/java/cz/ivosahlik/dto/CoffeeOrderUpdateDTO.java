package cz.ivosahlik.dto;

import cz.ivosahlik.domain.generated.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoffeeOrderUpdateDTO {
    private OrderStatus orderStatus;
}
