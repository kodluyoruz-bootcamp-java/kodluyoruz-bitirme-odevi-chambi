package org.kodluyoruz.group1.library.converter;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Book;
import org.kodluyoruz.group1.library.service.IAuthorService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BookConverter implements IBaseConverter<Book, BookDTO> {

    private final ModelMapper modelMapper;
    private final IAuthorService authorService;

    @Override
    public BookDTO convertToDto(Book entity) {

        TypeMap<Book, BookDTO> typeMap = modelMapper
                .createTypeMap(Book.class, BookDTO.class);

        typeMap.addMappings(mapping -> mapping.using(new AuthorsListConverter())
                .map(Book::getAuthors, BookDTO::setAuthors));

        return modelMapper.map(entity, BookDTO.class);
    }

    @Override
    public Book convertToEntity(BookDTO dto) {
        Book book = modelMapper.map(dto, Book.class);
        book.setAuthors(authorService.getAllByNameSurname(dto.getAuthors()));
        return book;
    }

}
