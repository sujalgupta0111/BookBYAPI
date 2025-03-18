package com.Sujal.repo;



import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Sujal.mail.MailSend;
import com.Sujal.models.Admin;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AdminRepo {
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	MailSend ms;
	
	public String login(String id,String password) {
		Session session= entityManager.unwrap(Session.class);
		Admin a=session.get(Admin.class,id);
		if(a==null || !password.equals(a.getPassword())) {
			return null;
		}
		return a.getName();
	}
	@Transactional
	public String updatePassword(String opass,String npass,String rpass,String id) {
		if(npass.equals(rpass)) {
			Session session= entityManager.unwrap(Session.class);
			Admin a=session.get(Admin.class,id);
			if(a==null) {
				return "Wrong ID";
			}else {
				if(opass.equals(a.getPassword())) {
					a.setPassword(npass);
					session.persist(a);
					//mail sending
					String remail=id;
					String sub="Book App: Password Updation.";
					String body="Password Updated Successfully"; 
					String result=ms.doMailSend(remail,sub,body);
					System.out.println(result);
					
					return "Password Updated Successfully!";
				}else {
					return "Wrong OLD Password Entered!";
				}
			}
		}else {
			return "New Password Mismatched!";
		}
	}
	@Transactional
	public String forgetPassword(String email) {
		Session session= entityManager.unwrap(Session.class);
		Admin a=session.get(Admin.class,email);
		if(a==null) {
			return "Mail Id does not registered!";
		}else {
			//new password generated code Numeric
			//String p=String.valueOf((int)(Math.random()*900000)+100000);
			// //String p=(int)(Math.random()*1000000) +"";
			
			//new password generated code Alpha-Numeric
			
			String chars = "abcdefghijklmnopqrstuvwxyz@#%^&ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			String p="";
	        for(int x=1;x<=6;x++) { 
	            int index = (int)(Math.random()*chars.length());
	            p += chars.charAt(index);
	        }
			a.setPassword(p);
			session.persist(a);
			//mail sending
			String remail=email;
			String sub="Book App: New Password Generated.";
			String body="<div style='text-align: center; border: 1px dashed black;'>"
					+ "<img style='padding: 20px;' src='https://www.incapp.in/assets/incapp-logo/incapp-logo-box.webp' height='70px' />"
					+ "    <hr/>"
					+ "<h1><span style='color: red;'>BooK App:</span> New Password Generated.</h1>"
					+ "    <hr/>"
					+ "    <p>Your New Password is: <b><mark>"+p+"</mark></b></p>"
					+ "    <p style='padding: 10px; color: white; background-color: black;'>Rights reserved by Incapp</p>" 
					+ "    </div>"; 
			String result=ms.doMailSendHTML(remail,sub,body);
			System.out.println(result);
			return "New Password Send!";
		}
		
	}
}
