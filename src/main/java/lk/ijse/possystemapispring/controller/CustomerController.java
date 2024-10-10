package lk.ijse.possystemapispring.controller;

import lk.ijse.possystemapispring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

}
