package org.kodluyoruz.group1.library.service;


import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Books;

import java.util.Collection;
import java.util.List;

public interface BookService  {

        Collection<Books> getAllBooks();

        Books save (BookDTO dto);

        Books update (BookDTO dto);

    void updateBookStatus(Long id); //deleted

    List<Books>   getBooksByBookName (String bookName);






    /*public void delete(BaseDTO id) {
         bookRepository.delete(id.getId());
    }*/




    //Collection<BookDTO> getOrderedBooks();

}
