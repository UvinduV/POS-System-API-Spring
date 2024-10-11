package lk.ijse.possystemapispring.service;

import lk.ijse.possystemapispring.dto.CustomerStatus;
import lk.ijse.possystemapispring.dto.Impl.CustomerDTO;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    CustomerStatus searchCustomer(String customerId);
}
