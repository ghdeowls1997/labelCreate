package com.label_gen.usps.domain.jpa;

import javax.persistence.PrePersist;
import java.util.Date;

public class CreatedAtListener {
    @PrePersist
    public void setCreatedAt(final SystemMetadata entity) {
        entity.setCreatedAt(new Date());
    }
}
