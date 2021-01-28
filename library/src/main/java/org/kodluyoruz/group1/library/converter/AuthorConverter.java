package org.kodluyoruz.group1.library.converter;

import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthorConverter implements IBaseConverter<Author, AuthorDTO> {

    private final ModelMapper modelMapper;

    @Override
    public AuthorDTO convertToDto(Author entity) {
        return modelMapper.map(entity, AuthorDTO.class);
    }

    @Override
    public Author convertToEntity(AuthorDTO dto) {
        return modelMapper.map(dto, Author.class);
    }
}
