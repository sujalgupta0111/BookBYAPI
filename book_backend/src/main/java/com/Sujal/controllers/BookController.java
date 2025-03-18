package com.Sujal.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Sujal.models.Book;
import com.Sujal.models.BookProjection;
import com.Sujal.services.AppService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class BookController {
	@Autowired
	AppService appService;
	
	@RequestMapping("/")
	public String home() {
		return "Welcome to Book App";
	}
	
	@GetMapping("/getBooks/{name}")
	public List<BookProjection> getBooks(@PathVariable String name) {
		return appService.getBooks(name);
	}
//	@GetMapping("/getBooks") //by default produce is JSON
//	@GetMapping(value = "/getBooks",produces = {"application/json"}) //only JSON support
//	@GetMapping(value = "/getBooks",produces = {"application/xml"}) //only XML support
	@GetMapping(value = "/getBooks",produces = {"application/json","application/xml"}) //support XML and JSON both
	public List<BookProjection> getBooks() {
		return appService.getBooks();
	}
//	@GetMapping("/getBook/{name}")
	@GetMapping(value = "/getBook/{name}",produces = {"application/json","application/xml"})
	public Book getBook(@PathVariable String name) {
		return appService.getBook(name);
	}
	@PostMapping("/addBook")
	public boolean addBook(@RequestBody Book book)  {
		return appService.addBook(book);
	}
	@PutMapping("/updateBook")//by default consumes is JSON and XML both
//	@PutMapping(value = "/updateBook",consumes = {"application/xml"}) //only XML support
//	@PutMapping(value = "/updateBook",consumes = {"application/json"}) //only JSON support
//	@PutMapping(value = "/updateBook",consumes = {"application/xml","application/json"})//support XML and JSON both
	public boolean updateBook(@RequestBody Book book) {
		return appService.updateBook(book);
	}
	@PutMapping("/updateBookImage/{name}")
	public boolean updateBookImage(@PathVariable String name,@RequestBody byte[] image) {
		return appService.updateBookImage(name, image);
	}
	@DeleteMapping("/deleteBook/{name}")
	public boolean deleteBook(@PathVariable String name) {
		return appService.deleteBook(name);
	}
	@GetMapping("/getBookImage/{name}")
	public byte[] getBookImage(@PathVariable String name) {
		return appService.getBookImage(name);
	}
	@GetMapping("/getBookContent/{name}")
	public byte[] getBookContent(@PathVariable String name) {
		return appService.getBookContent(name);
	}
}
