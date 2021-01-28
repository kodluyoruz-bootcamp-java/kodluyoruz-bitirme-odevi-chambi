package org.kodluyoruz.group1.library.dao;

import org.kodluyoruz.group1.library.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByDeletedIsFalse();

    @Query("select a from Author a where a.nameSurname in (:nameSurname) and a.deleted = false")
    List<Author> findAllByNameSurname(List<String> nameSurname);

    @Modifying
    @Transactional
    @Query("update Author a set a.deleted=true where a.id=:id")
    void deleteAuthor(Long id);

	boolean findByNameSurname(String nameSurname);

}
