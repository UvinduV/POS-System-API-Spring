package lk.ijse.possystemapispring.service.Impl;

import lk.ijse.possystemapispring.dto.Impl.OrderDTO;
import lk.ijse.possystemapispring.dto.Impl.OrderDetailsDTO;
import lk.ijse.possystemapispring.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void placeOrder(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTOList) {

    }
}
