package com.digiage.projectTask4.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    public Long emp_no;
    public String first_name;
    public String last_name;
    public String gender;
}
