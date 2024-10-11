package lk.ijse.possystemapispring.CustomStatusCode;

import lk.ijse.possystemapispring.dto.CustomerStatus;
import lk.ijse.possystemapispring.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectCustomerAndItemErrorStatus implements CustomerStatus, ItemStatus {
    private int statusCode;
    private String statusMassage;
}
