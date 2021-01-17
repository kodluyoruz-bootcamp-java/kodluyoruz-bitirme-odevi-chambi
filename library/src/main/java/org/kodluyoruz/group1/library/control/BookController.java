package org.kodluyoruz.group1.library.control;

import lombok.RequiredArgsConstructor;
import org.kodluyoruz.group1.library.dto.BookDTO;
import org.kodluyoruz.group1.library.model.entities.Books;
import org.kodluyoruz.group1.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")

public class BookController {

    private final BookService bookService;

   // private final BookRepository bookRepository;

// @GetMapping("/bookList")
// public String getBookList(Model model){
//     model.addAttribute("listBook",bookService.getAllBooks());
//     return "listBook";
// }


@GetMapping("/bookList")
public Collection<Books> getBookList(){
    return bookService.getAllBooks();
}



//    @GetMapping("/bookList")
//    public ResponseEntity<Collection<BookDTO>> listAllBooks() {
//        Collection<BookDTO> getAllBooks = bookService.list();
//        return ResponseEntity.ok().body(getAllBooks);
//    }


//    @GetMapping("/bookList")
//    public String bookList(Model model) {
//        model.addAttribute("listBook", bookService.getAllOrderedBooks());
//        return "book_list";


@PostMapping("/createBook")
public Books saveBook(@RequestBody BookDTO bookDTO){
    Books books= bookService.save(bookDTO);
    return books;

}
@PutMapping("/updateInfo")
public Books updateBook(@RequestBody BookDTO bookDTO){
    Books books= bookService.update(bookDTO);
    return books;
}
    @DeleteMapping("/delete/{id}")
    public void deleteBook (@PathVariable Long id){
    bookService.updateBookStatus(id);
    }

    @GetMapping("/showSearchResult/{bookName}")
    public Collection<Books> showSearchResult(@PathVariable String bookName){
    return bookService.getBooksByBookName(bookName);
    }

//    @PostMapping("/createBook")
//    public ResponseEntity<BookDTO> create (@RequestBody BookDTO bookDTO){
//        return ResponseEntity.ok(bookService.create(bookDTO));
//    }
//
//    @PutMapping("/updateInfo")
//    public ResponseEntity<BookDTO> update (@RequestBody BookDTO bookDTO){
//        return ResponseEntity.ok(bookService.update(bookDTO));
//    }



//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable ("id") @RequestBody  Long id ){
//        bookService.delete(id);
//        return ResponseEntity.ok().build();
//    }


   /*// @RequestMapping(value = "/id", method = RequestMethod.DELETE, consumes = "application/json")
    @DeleteMapping("/{id}")
    public void delete(Long id){
        bookService.delete(id);
    }*/


   /* public ResponseEntity<Long> delete( (@PathVariable Long id )  BaseDTO id) {

        bookService.delete(id);
        return ResponseEntity.ok().build();
    }*/

   /* @DeleteMapping(value = "/deleteproductbyid/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteProductById(@PathVariable int id) {
        return service.deleteProductById(id);
    }*/





//    @GetMapping("/showSearchResult/{bookName}")
//    public ResponseEntity<Collection<Books>> getListByKeyword(@PathVariable (name = "bookName",required = true) String bookName){
//        return ResponseEntity.ok(bookService.getSearchBook(bookName));
//    }





//    @GetMapping("/orderList")
//    public ResponseEntity<Collection<BookDTO>> findListOrderBooks(){
//        Collection<BookDTO> getOrderBooks = bookService.getOrderedBooks();
//        return ResponseEntity.ok().body(getOrderBooks);
//    }


}
