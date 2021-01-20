package org.kodluyoruz.group1.library.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author extends BaseEntity {

    @Column(name = "name_surname", unique = false, length = 100)
    private String nameSurname;

    @Lob
    @Type(type = "text")
    @Column(name = "about")
    private String about;

    //Bu ilişki OK , muhammed
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

}