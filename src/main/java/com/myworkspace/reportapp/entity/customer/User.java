package com.myworkspace.reportapp.entity.customer;

import com.myworkspace.reportapp.entity.customer.enums.UserType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class User {

    @Id
    private UUID id;
    private String email;
    private String phoneNumber;
    private boolean activeUser;

    @Column(name = "user_type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(@NonNull String email,
                @NonNull String phoneNumber) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.activeUser = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", activeUser=" + activeUser +
                '}';
    }
}
