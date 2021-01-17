package org.kodluyoruz.group1.library.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Role_Name" )
    private String roleName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Created_Date", nullable = false ,updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Update_Date")
    private Date updateDate;

    private boolean deleted;


  /*  @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Collection<Member> users;*/

}
