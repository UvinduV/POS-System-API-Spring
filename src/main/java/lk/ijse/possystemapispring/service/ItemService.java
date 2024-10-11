package lk.ijse.possystemapispring.service;

import lk.ijse.possystemapispring.dto.Impl.ItemDTO;
import lk.ijse.possystemapispring.dto.ItemStatus;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    ItemStatus searchItem(String itemId);
}
