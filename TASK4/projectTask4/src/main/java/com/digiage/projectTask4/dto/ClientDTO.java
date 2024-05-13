package com.digiage.projectTask4.dto;

import com.digiage.projectTask4.domain.Client;

public class ClientDTO {

    private Long emp_no;
    private String first_name;
    private String last_name;
    private String gender;

    public ClientDTO() {
    }

    public ClientDTO(Long emp_no, String first_name, String last_name, String gender) {
        this.emp_no = emp_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
    }

    public ClientDTO(Client client) {
        this.emp_no = client.getEmp_no();
        this.first_name = client.getFirst_name();
        this.last_name = client.getLast_name();
        this.gender = client.getGender();
    }

    public Long getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(Long emp_no) {
        this.emp_no = emp_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
