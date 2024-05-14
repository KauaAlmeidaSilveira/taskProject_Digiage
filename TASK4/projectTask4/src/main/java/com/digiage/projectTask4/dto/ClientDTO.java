package com.digiage.projectTask4.dto;

import com.digiage.projectTask4.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long emp_no;
    private String first_name;
    private String last_name;
    private String gender;

    public ClientDTO(Client client) {
        this.emp_no = client.getEmp_no();
        this.first_name = client.getFirst_name();
        this.last_name = client.getLast_name();
        this.gender = client.getGender();
    }
}
