package com.example.bai1.controller;

import com.example.bai1.entity.Book;
import com.example.bai1.entity.Borrow;
import com.example.bai1.exception.BookNotFoundException;
import com.example.bai1.service.IBookService;
import com.example.bai1.service.IBorrowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final IBookService service;
    private final IBorrowService borrowService;

    public BookController(IBookService service, IBorrowService borrowService) {
        this.service = service;
        this.borrowService = borrowService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("books",service.findAll() );
        return "book/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model){
        Book book = service.findById(id).orElseThrow(()-> new BookNotFoundException("Không tìm thấy  sách với ID: " + id));
        model.addAttribute("book",book);
        return "book/detail";

    }
    @PostMapping("/borrow/{id}")
    public String borrow(@PathVariable Integer id, Model model) {
        Book book = service.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Không tìm thấy sách với ID: " + id));

        if (book.getQuantity() <= 0) {
            model.addAttribute("error", "Sách đã hết!");
            return "book/error";
        }


        book.setQuantity(book.getQuantity() - 1);
        service.save(book);


        long code = Long.parseLong(String.format("%05d", (long)(Math.random() * 100000)));


        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setBorrowCode(code);
        borrowService.save(borrow);

        model.addAttribute("book", book);
        model.addAttribute("code", code);
        return "book/borrow-success";
    }

    @GetMapping("/return/{id}")
    public String showReturnForm(@PathVariable Integer id, Model model) {
        model.addAttribute("bookId", id);
        return "book/return";
    }


    @PostMapping("/return/{id}")
    public String returnBook(@PathVariable Integer id,
                             @RequestParam("code") Long code,
                             Model model) {
        Borrow borrow = borrowService.findByBorrowCode(code)
                .orElseThrow(() -> new RuntimeException("Mã mượn không tồn tại!"));

        Book book = borrow.getBook();
        book.setQuantity(book.getQuantity() + 1);
        service.save(book);

        borrowService.delete(borrow);

        model.addAttribute("book", book);
        return "book/return-success";
    }

}
