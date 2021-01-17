package org.kodluyoruz.group1.library.converter;


import org.kodluyoruz.group1.library.convert.LibraryAPIConverter;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Books;
import org.springframework.stereotype.Component;

@Component
public class BookDTOToBooksConverter implements LibraryAPIConverter<BookDTO, Books> {

    @Override
    public Books convert(BookDTO input) {

        Books books = new Books();

        books.setId(input.getId());
        books.setBookName(input.getBookName());
        books.setPageNumber(input.getPageNumber());
        books.setPublisherName(input.getPublisherName());
        books.setEditionNumber(input.getEditionNumber());
        books.setIsbn(input.getIsbn());
        books.setLanguage(input.getLanguage());
        books.setCategory(input.getCategory());
        books.setStatus(input.getStatus());
        books.setCreateDate(input.getCreateDate());
        books.setUpdateDate(input.getUpdateDate());
        books.setDeleted(input.isDeleted());

        books.setAuthor(input.getAuthors());
        books.setMember(input.getMember());



        return books;
    }
}
