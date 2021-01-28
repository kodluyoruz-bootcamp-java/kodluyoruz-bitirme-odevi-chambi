package org.kodluyoruz.group1.library.model.entities;


import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    private String roleName;

    private boolean deleted;

    @ManyToMany(mappedBy = "roles") // ilişkinin sahibi
    private List<Member> members;

}
