package com.Sujal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.Sujal.models.Book;
import com.Sujal.models.BookProjection;
import com.Sujal.repo.AdminRepo;
import com.Sujal.repo.BookRepo;

@Service
public class AppService {
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private AdminRepo adminRepo;
	
	public List<BookProjection> getBooks(String name) {
		return bookRepo.getBooks(name);
	}
	public Book getBook(String name) {
		return bookRepo.getBook(name);
	}
	public String login(String id,String password) {
		return adminRepo.login(id, password);
	}
	public boolean addBook(Book book) {
		return bookRepo.addBook(book);
	}
	public boolean updateBookImage(String name,byte[] image) {
		return bookRepo.updateBookImage(name,image);
	}
	public boolean updateBook(Book book) {
		return bookRepo.updateBook(book);
	}
	public boolean deleteBook(String name) {
		return bookRepo.deleteBook(name);
	}
	public List<String> getBookNames() {
		return bookRepo.getBookNames();
	}
	public List<BookProjection> getBooks() {
		return bookRepo.getBooks();
	}
	public byte[] getBookImage(String name) {
		return bookRepo.getBookImage(name);
	}
	public byte[] getBookContent(String name) {
		return bookRepo.getBookContent(name);
	}
	public String updatePassword(String opass,String npass,String rpass,String id) {
		return adminRepo.updatePassword(opass,npass,rpass,id);
	}
	public String forgetPassword(String email) {
		return adminRepo.forgetPassword(email);
	}
}
