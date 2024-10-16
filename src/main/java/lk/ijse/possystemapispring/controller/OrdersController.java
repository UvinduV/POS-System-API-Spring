package lk.ijse.possystemapispring.controller;

import lk.ijse.possystemapispring.dto.Impl.RequestOrderDTO;
import lk.ijse.possystemapispring.exception.DataPersistException;
import lk.ijse.possystemapispring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {
    @Autowired
    private OrderService orderService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> placeOrder(@RequestBody RequestOrderDTO requestOrder){
        try {
            orderService.placeOrder(requestOrder.getOrderDTO(),requestOrder.getOrderDetailsDTOList());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
