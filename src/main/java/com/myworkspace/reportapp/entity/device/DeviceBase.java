package com.myworkspace.reportapp.entity.device;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "device_bases")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DeviceBase {

    @Id
    private UUID id;
    private String name;
    private String internalId;
    private int revision;

    public DeviceBase(String name, String internalId, int revision) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.internalId = internalId;
        this.revision = revision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceBase that = (DeviceBase) o;
        return revision == that.revision && Objects.equals(name, that.name) && Objects.equals(internalId, that.internalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, internalId, revision);
    }

    @Override
    public String toString() {
        return "DeviceBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", internalId='" + internalId + '\'' +
                ", revision=" + revision +
                '}';
    }
}
