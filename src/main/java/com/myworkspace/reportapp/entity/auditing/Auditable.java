package com.myworkspace.reportapp.entity.auditing;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.data.annotation.*;

import java.time.LocalDateTime;


@Embeddable
@Data
public class Auditable {

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime creationDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Version
    private Long version;
}
