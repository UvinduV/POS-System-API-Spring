package lk.ijse.possystemapispring.dto.Impl;

import lk.ijse.possystemapispring.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements OrderStatus {
    private String orderId;
    private String customerId;
    private String date;
    private double discount;
    private double sub_total;
    private List<OrderDetailsDTO> orderDetails;
}
