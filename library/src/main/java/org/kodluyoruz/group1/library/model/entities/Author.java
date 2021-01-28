package org.kodluyoruz.group1.library.model.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "author")
public class Author extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String nameSurname;

    @Type(type = "text")
    private String about;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
}