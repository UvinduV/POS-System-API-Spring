package lk.ijse.possystemapispring.service;

import lk.ijse.possystemapispring.dto.CustomerStatus;
import lk.ijse.possystemapispring.dto.Impl.OrderDTO;
import lk.ijse.possystemapispring.dto.Impl.OrderDetailsDTO;
import lk.ijse.possystemapispring.dto.OrderDetailsStatus;
import lk.ijse.possystemapispring.dto.OrderStatus;


import java.util.List;

public interface OrderService {
    void placeOrder(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTOList);

    List<OrderDTO> getAllOrders();


    OrderDetailsStatus searchOrder(String orderId);
}
