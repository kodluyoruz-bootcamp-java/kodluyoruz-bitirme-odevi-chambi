package org.kodluyoruz.group1.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.converter.AuthorConverter;
import org.kodluyoruz.group1.library.dao.AuthorRepository;
import org.kodluyoruz.group1.library.dto.AuthorDTO;
import org.kodluyoruz.group1.library.exceptions.AlreadyExistException;
import org.kodluyoruz.group1.library.exceptions.AuthorNotFoundException;
import org.kodluyoruz.group1.library.model.entities.Author;
import org.kodluyoruz.group1.library.service.IAuthorService;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;

    @Override
    public Author save(AuthorDTO dto) {
        
        boolean isExist = authorRepository.findByNameSurname(dto.getNameSurname().toUpperCase());
        if (isExist) {
            throw new AlreadyExistException("Zaten böyle bir yazar var.");
        }

        Author author = authorConverter.convertToEntity(dto);
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllActive() {
        return authorRepository.findAllByDeletedIsFalse();
    }

    @Override
    public void deleteById(Long id) {
        if(authorRepository.findById(id).isPresent()){
              authorRepository.deleteAuthor(id);
        }
        else{
            throw new AuthorNotFoundException("Böyle bir yazar yok.");
        }
      
    }

    @Override
    public Author update(Long id, AuthorDTO dto) {

        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Böyle bir yazar yok."));

        author.setUpdateDate(new Date());
        author.setDeleted(dto.isDeleted());
        author.setAbout(dto.getAbout());
        author.setNameSurname(dto.getNameSurname());
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllByNameSurname(List<String> nameSurname) {

        return authorRepository.findAllByNameSurname(nameSurname);
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Aradığınız yazar bulunamadı."));
        return authorConverter.convertToDto(author);
    }
}
