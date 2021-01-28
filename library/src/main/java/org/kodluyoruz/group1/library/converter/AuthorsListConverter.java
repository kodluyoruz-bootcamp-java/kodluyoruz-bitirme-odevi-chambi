package org.kodluyoruz.group1.library.converter;

import org.kodluyoruz.group1.library.model.entities.Author;
import org.modelmapper.AbstractConverter;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorsListConverter extends AbstractConverter<List<Author>, List<String>> {

    @Override
    protected List<String> convert(List<Author> authors) {
        return authors
                .stream()
                .map(Author::getNameSurname)
                .collect(Collectors.toList());
    }
}
