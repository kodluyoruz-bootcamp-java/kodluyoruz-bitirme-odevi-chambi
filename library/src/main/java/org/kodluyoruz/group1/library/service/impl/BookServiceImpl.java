package org.kodluyoruz.group1.library.service.impl;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.converter.BookDTOToBooksConverter;
import org.kodluyoruz.group1.library.dao.BooksOperationRepository;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Books;
import org.kodluyoruz.group1.library.repo.BookRepository;
import org.kodluyoruz.group1.library.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    private final BookDTOToBooksConverter bookDTOToBooksConverter;
    private final BooksOperationRepository booksOperationRepository;


    @Override
    public Collection<Books> getAllBooks() {
        Collection<Books> books = bookRepository.findAllBooks();
        if (CollectionUtils.isEmpty(books)) {
            throw new RuntimeException("Mevcutta henüz bir kitap bulunmamaktadır.");
        }
        return books;
    }


    @Override
    public Books save(BookDTO dto) {
        String bookName = dto.getBookName();
        if (bookName.isEmpty()) {
            throw new RuntimeException("Kitap ismi boş bırakılamaz.");
        }

        boolean isExist = booksOperationRepository.hasExistSameBookIsbn(dto.getIsbn());
        if (isExist) {
            throw new RuntimeException("Aynı barkod numarasına sahip kitap bulunmaktadır." +
                    " Barkod numaranızı tekrar kontrol ediniz!");
        }

        Books books = bookDTOToBooksConverter.convert(dto);
        return bookRepository.save(books);
    }

    @Override
    public Books update(BookDTO dto) {


        Books books = bookRepository.findById(dto.getId()).orElse(null);

        books.setUpdateDate(new Date());
        books.setDeleted(dto.isDeleted());
        books.setPublisherName(dto.getPublisherName());
        books.setCategory(dto.getCategory());
        books.setLanguage(dto.getLanguage());
        books.setEditionNumber(dto.getEditionNumber());
        books.setPageNumber(dto.getPageNumber());
        books.setIsbn(dto.getIsbn());
        books.setBookName(dto.getBookName());
        books.setStatus(dto.getStatus());

        return bookRepository.save(books);
    }



    @Override
    public void updateBookStatus(Long id) {
        bookRepository.updateBookStatus(id);

    }

    @Override
    public List<Books> getBooksByBookName(String bookName) {
        return bookRepository.findBooksByBookName(bookName);
    }
}
