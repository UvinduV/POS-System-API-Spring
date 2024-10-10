package lk.ijse.possystemapispring.CustomStatusCode;

import lk.ijse.possystemapispring.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectCustomerAndItemErrorStatus implements CustomerStatus {
    private int statusCode;
    private String statusMassage;
}
