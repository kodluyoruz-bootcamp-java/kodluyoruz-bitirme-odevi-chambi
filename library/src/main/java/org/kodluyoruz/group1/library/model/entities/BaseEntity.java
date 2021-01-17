package org.kodluyoruz.group1.library.model.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
   // @Column(name = "Created_Date", nullable = false ,updatable = false)
    @Column(name = "Created_Date", nullable = false )
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Update_Date")
    private Date updateDate;

    @Column(name = "Deleted")
    private boolean deleted;


}
