package de.pkrause.springit.model;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
    
    @CreatedBy @Getter @Setter
    private String createBy;
    
    @CreatedDate @Getter @Setter
    private LocalDateTime creationDate;
    
    @LastModifiedBy @Getter @Setter
    private String lastModifiedBy;
    
    @LastModifiedDate @Getter @Setter
    private LocalDateTime LastModifiedDate;
        
}
