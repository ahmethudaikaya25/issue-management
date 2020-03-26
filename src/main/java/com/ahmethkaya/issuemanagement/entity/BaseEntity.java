package com.ahmethkaya.issuemanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


//Data binevi implement edildi lombok içinde getter setter kullanmaya gerek kalmıyor
//Aynı zamanda @Data yerine @getter ve @setter de yazılabilir
//MappedSuperclass tüm tablolarda ortak olmasını sağlar
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "created_by", length = 50)
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @Column(name = "status")
    private Boolean status;

}