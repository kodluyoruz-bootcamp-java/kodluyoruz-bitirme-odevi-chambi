package org.kodluyoruz.group1.library.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kodluyoruz.group1.library.model.enums.StatusEnum;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class Books extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Book_ID")
//    private Long id;

    @Column(name = "Book_Name",unique = false , length = 200 , nullable = false)
    private String bookName;

    //@Column(name = "Author_ID")
   // private Long authorId;

    /*@Column(name = "Author",unique = false , length = 200 , nullable = false)
    private String author;*/

    @Column(name = "Page_Number",unique = false , length =5 , nullable = false)
    private Long pageNumber;

    @Column(name = "Publisher",unique = false , length =100 , nullable = false)
    private String publisherName;

    @Column(name = "Edition_Number",unique = false , length = 50 , nullable = false)
    private Integer editionNumber;

    @Column(name = "ISBN",unique = true , length = 50 , nullable = false)
    private Long isbn;

    @Column(name = "Language",unique = false , length = 50 , nullable = false)
    private String language;

    @Column(name = "Category",unique = false , length = 50 , nullable = false)
    private String category;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "Created_Date", nullable = false ,updatable = false)
//    private Date createDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "Update_Date")
//    private Date updateDate;

    @Enumerated(value = EnumType.STRING)
    @Column (name = "Book_Status", length = 7, nullable = false)
    private StatusEnum status = StatusEnum.ACTIVE ;

/*
    @JoinColumn(name = "Author_ID")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private AuthorEntity author;*/


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = { @JoinColumn(name = "book_no", referencedColumnName = "id") },
            inverseJoinColumns =  { @JoinColumn(name = "author_no" , referencedColumnName = "id") }
    )
    private List<Authors> authors;






}
