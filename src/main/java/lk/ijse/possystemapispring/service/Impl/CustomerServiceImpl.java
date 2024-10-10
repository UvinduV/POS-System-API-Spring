package lk.ijse.possystemapispring.service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystemapispring.dao.CustomerDao;
import lk.ijse.possystemapispring.dto.Impl.CustomerDTO;
import lk.ijse.possystemapispring.entity.Impl.CustomerEntity;
import lk.ijse.possystemapispring.exception.DataPersistException;
import lk.ijse.possystemapispring.service.CustomerService;
import lk.ijse.possystemapispring.util.AppUtil;
import lk.ijse.possystemapispring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping customerMapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setId(AppUtil.generateCustomerId());
        CustomerEntity savedCustomer=
                customerDao.save(customerMapping.toCustomerEntity(customerDTO));
        if(savedCustomer == null){
            throw new DataPersistException("Customer not saved");
        }

    }
}
