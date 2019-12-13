package com.grokonez.jwtauthentication.students.convert.dto;

public class StudentDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private Long dekanatId;

    private String dekanatName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDekanatId() {
        return dekanatId;
    }

    public void setDekanatId(Long dekanatId) {
        this.dekanatId = dekanatId;
    }

    public String getDekanatName() {
        return dekanatName;
    }
    public void setDekanatName(String dekanatName) {
        this.dekanatName = dekanatName;
    }
}
