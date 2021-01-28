package org.kodluyoruz.group1.library.service;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;

import java.util.List;

public interface IAuthorService {

    Author save(AuthorDTO dto);

    List<Author> getAllActive();

    List<Author> getAllByNameSurname(List<String> nameSurname);

    void deleteById(Long id);

    Author update(Long id, AuthorDTO dto);

    AuthorDTO getAuthorById(Long id);
}
