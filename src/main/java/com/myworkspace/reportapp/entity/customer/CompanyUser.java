package com.myworkspace.reportapp.entity.customer;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class CompanyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String phoneNumber;
    private boolean activeUser;

    public CompanyUser(@NonNull String email, @NonNull String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.activeUser = false;
    }

    public void setActiveUser(boolean activeUser) {
        this.activeUser = activeUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyUser that = (CompanyUser) o;
        return Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phoneNumber);
    }
}
