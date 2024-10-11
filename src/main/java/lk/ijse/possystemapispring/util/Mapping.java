package lk.ijse.possystemapispring.util;

import lk.ijse.possystemapispring.dto.Impl.CustomerDTO;
import lk.ijse.possystemapispring.dto.Impl.ItemDTO;
import lk.ijse.possystemapispring.entity.Impl.CustomerEntity;
import lk.ijse.possystemapispring.entity.Impl.ItemEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    //Customer
    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }
    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }
    public List<CustomerDTO> asCustomerDtoLIst(List<CustomerEntity> customerEntityList){
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    //Items
    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO, ItemEntity.class);
    }
    public ItemDTO toItemDTO(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDTO.class);
    }
    public List<ItemDTO> asItemDtoLIst(List<ItemEntity> itemEntityList){
        return modelMapper.map(itemEntityList, new TypeToken<List<ItemDTO>>() {}.getType());
    }
}
