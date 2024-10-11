package lk.ijse.possystemapispring.service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystemapispring.dao.ItemDao;
import lk.ijse.possystemapispring.dto.Impl.ItemDTO;
import lk.ijse.possystemapispring.entity.Impl.CustomerEntity;
import lk.ijse.possystemapispring.entity.Impl.ItemEntity;
import lk.ijse.possystemapispring.exception.DataPersistException;
import lk.ijse.possystemapispring.service.ItemService;
import lk.ijse.possystemapispring.util.AppUtil;
import lk.ijse.possystemapispring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping itemMapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setId(AppUtil.generateItemId());
        ItemEntity savedItem=
                itemDao.save(itemMapping.toItemEntity(itemDTO));
        if(savedItem == null){
            throw new DataPersistException("Item not saved");
        }
    }
}
