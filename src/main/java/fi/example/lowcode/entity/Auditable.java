package fi.example.lowcode.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @Version
    public long version;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    public Date created;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    public Date modified;

    @CreatedBy
    @Column(updatable = false)
    public String creator;

    @LastModifiedBy
    public String modifier;
}