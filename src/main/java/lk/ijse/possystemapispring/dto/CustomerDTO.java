package lk.ijse.possystemapispring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus{
    private String id;
    private String name;
    private String address;
    private String contact;
}
