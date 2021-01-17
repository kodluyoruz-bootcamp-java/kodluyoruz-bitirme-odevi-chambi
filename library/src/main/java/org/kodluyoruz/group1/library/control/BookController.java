package org.kodluyoruz.group1.library.control;


import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequiredArgsConstructor
@RequestMapping

public class BookController {
    private final BookService bookService;
//
    @GetMapping("/bookList")
    public String getBooks(Model model) {
        Collection<BookDTO> allList = bookService.list();
        model.addAttribute("books", allList);
        return "book_list";
    }


    @PostMapping("/createBook")
    public ResponseEntity<BookDTO> create(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.create(bookDTO));
    }

    @PutMapping("/updateInfo/{id}")
    public String update (@PathVariable(value="id")  Long id,Model model){
        model.addAttribute("book", bookService.update(Long id));
        return "";
    }BookDTO bookDTO
    @PutMapping("/updateInfo/{id}")
    public String Update (@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("book", bookService.update(Long id));
        //model.addAttribute("authors", bookService.getAllAuthorForBooks());
        //model.addAttribute("publishers", bookService.getAllPublisherForBooks());
        return "update_book";
    }



    @GetMapping("/showSearchResult/{keyword}")
    public ResponseEntity<Collection<BookDTO>> findListByKeyword(@PathVariable(name = "keyword", required = true) String keyword) {
        return ResponseEntity.ok(bookService.findBooksByKeyword(keyword));
    }

    @GetMapping("/orderList")
    public ResponseEntity<Collection<BookDTO>> findListOrderBooks() {
        Collection<BookDTO> getOrderBooks = bookService.getOrderedBooks();
        return ResponseEntity.ok().body(getOrderBooks);
    }


}
