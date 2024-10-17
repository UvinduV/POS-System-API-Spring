package lk.ijse.possystemapispring.controller;

import lk.ijse.possystemapispring.CustomStatusCode.SelectCustomerAndItemAndOrderErrorStatus;
import lk.ijse.possystemapispring.dto.CustomerStatus;
import lk.ijse.possystemapispring.dto.Impl.OrderDTO;
import lk.ijse.possystemapispring.dto.Impl.RequestOrderDTO;
import lk.ijse.possystemapispring.dto.OrderDetailsStatus;
import lk.ijse.possystemapispring.dto.OrderStatus;
import lk.ijse.possystemapispring.entity.Impl.OrderEntity;
import lk.ijse.possystemapispring.exception.DataPersistException;
import lk.ijse.possystemapispring.service.OrderService;
import lk.ijse.possystemapispring.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin
public class OrdersController {
    @Autowired
    private OrderService orderService;
    private static Logger logger= LoggerFactory.getLogger(OrdersController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> placeOrder(@RequestBody RequestOrderDTO requestOrder){
        try {
            orderService.placeOrder(requestOrder.getOrderDTO(),requestOrder.getOrderDetailsDTOList());
            logger.info("Order place successfully!");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            logger.error("Order place unsuccessful!"+e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error("Order place unsuccessful!"+e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping(value = "/{OrderID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDetailsStatus searchOrder(@PathVariable ("OrderID") String orderId){
        /*if (!RegexProcess.customerIdMatcher(orderId)) {
            logger.error("Order search fail!");
            return new SelectCustomerAndItemAndOrderErrorStatus(1,"Customer ID is not valid");
        }*/
        return orderService.searchOrder(orderId);
    }

}
