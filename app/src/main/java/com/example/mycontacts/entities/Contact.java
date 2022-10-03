package com.example.mycontacts.entities;

import java.util.Objects;

public class Contact {
    String first_name;
    String last_name;
    String phone_number;

    public Contact() {
    }

    public Contact(String first_name, String last_name, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getFirst_name().equals(contact.getFirst_name()) && getLast_name().equals(contact.getLast_name()) && getPhone_number().equals(contact.getPhone_number());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst_name(), getLast_name(), getPhone_number());
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
