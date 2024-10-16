package lk.ijse.possystemapispring.CustomStatusCode;

import lk.ijse.possystemapispring.dto.CustomerStatus;
import lk.ijse.possystemapispring.dto.ItemStatus;
import lk.ijse.possystemapispring.dto.OrderDetailsStatus;
import lk.ijse.possystemapispring.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectCustomerAndItemAndOrderErrorStatus implements CustomerStatus, ItemStatus , OrderStatus, OrderDetailsStatus {
    private int statusCode;
    private String statusMassage;
}
