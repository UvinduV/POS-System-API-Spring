package lk.ijse.possystemapispring.dao;

import lk.ijse.possystemapispring.entity.Impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity,String> {
}