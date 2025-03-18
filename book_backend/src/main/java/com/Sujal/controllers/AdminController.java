package com.Sujal.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Sujal.models.Admin;
import com.Sujal.services.AppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AppService appService;
	
	@PostMapping("/login")
	public String login(@RequestBody Admin admin) {
		return appService.login(admin.getId(), admin.getPassword());
	}
//	@PutMapping("/updatePassword/{opass}/{npass}/{rpass}/{id}")
//	public String updatePassword(@PathVariable String opass,@PathVariable String npass,@PathVariable String rpass,@PathVariable String id) {
//		return appService.updatePassword(opass, npass, rpass, id);
//	}
	@PutMapping("/updatePassword/{opass}/{npass}/{rpass}/{id}")
	public ResponseEntity<String> updatePassword(@PathVariable String opass,@PathVariable String npass,@PathVariable String rpass,@PathVariable String id) {
		String m=appService.updatePassword(opass, npass, rpass, id);
		ResponseEntity<String> responseEntity=new ResponseEntity<String>(m, HttpStatus.OK);
		return responseEntity;
	}
	@PostMapping("/forgetPassword/{email}")
	public String forgetPassword(@PathVariable String email) {
		return appService.forgetPassword(email);
	}
	
}
