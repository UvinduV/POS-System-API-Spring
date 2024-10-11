package lk.ijse.possystemapispring.controller;

import lk.ijse.possystemapispring.CustomStatusCode.SelectCustomerAndItemErrorStatus;
import lk.ijse.possystemapispring.dto.CustomerStatus;
import lk.ijse.possystemapispring.dto.Impl.CustomerDTO;
import lk.ijse.possystemapispring.exception.DataPersistException;
import lk.ijse.possystemapispring.service.CustomerService;
import lk.ijse.possystemapispring.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDTO customerDTO){
        try {
            customerService.saveCustomer(customerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value = "/{customerID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatus searchCustomer(@PathVariable ("customerID") String customerId){
        if (!RegexProcess.customerIdMatcher(customerId)) {
            return new SelectCustomerAndItemErrorStatus(1,"Customer ID is not valid");
        }
        return customerService.searchCustomer(customerId);

    }

}
