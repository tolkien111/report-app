package com.myworkspace.reportapp.entity.customer;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Objects;


@Entity
@DiscriminatorValue("MANAGER")
@NoArgsConstructor
@Getter
public class Manager extends User{

        private String firstName;
        private String lastName;
        private String password;


    public Manager(@NonNull String email,@NonNull String phoneNumber,@NonNull String firstName,@NonNull String lastName,@NonNull String password) {
        super(email, phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(firstName, manager.firstName) && Objects.equals(lastName, manager.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
}
