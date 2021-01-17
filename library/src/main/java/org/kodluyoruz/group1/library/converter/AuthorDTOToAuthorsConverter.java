package org.kodluyoruz.group1.library.converter;


import org.kodluyoruz.group1.library.convert.LibraryAPIConverter;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Authors;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTOToAuthorsConverter implements LibraryAPIConverter<AuthorDTO, Authors> {
    @Override
    public Authors convert(AuthorDTO input) {

        Authors authors = new Authors();
        authors.setId(input.getId());
        authors.setNameSurname(input.getNameSurname());
        authors.setAbout(input.getAbout());
        authors.setCreateDate(input.getCreateDate());
        authors.setUpdateDate(input.getUpdateDate());
        authors.setDeleted(input.isDeleted());

        //authors.setBooks(input.getBooks());













        return authors;
    }
}
