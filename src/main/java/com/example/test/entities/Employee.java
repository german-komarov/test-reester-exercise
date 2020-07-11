package com.example.test.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String patronymic;

    private String gender;
    private String birthday;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="position_id")
    private Position position;

    private String employmentDate;

    private Long salary;

    private String jobPhoneNumber;
    private String personalPhoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "bank_customer",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "bank_id")})
    private Bank bankOrganization;

    private boolean isArchived;


    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getJobPhoneNumber() {
        return jobPhoneNumber;
    }

    public void setJobPhoneNumber(String jobPhoneNumber) {
        this.jobPhoneNumber = jobPhoneNumber;
    }

    public String getPersonalPhoneNumber() {
        return personalPhoneNumber;
    }

    public void setPersonalPhoneNumber(String personalPhoneNumber) {
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public Bank getBankOrganization() {
        return bankOrganization;
    }

    public void setBankOrganization(Bank bankOrganization) {
        this.bankOrganization = bankOrganization;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }


}
