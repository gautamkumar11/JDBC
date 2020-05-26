package com.jspiders.marriage.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class UserInterface {

	public static void main(String[] args) throws SQLException, IOException {
		 
		
		Person person = new Person();
		person.setName("anshu");
		person.setAge(22);
		person.setContact(7028870780l);
		
		File photo = new File("C:\\J2eePrograms\\Files\\profile.jpg");
		
		person.setPhoto(photo);
		
		
		InsertPersonDetails personDetails = new InsertPersonDetails();
		
		personDetails.insert(person);
		
		
		RetrievePersonDetails personDetails2 = new RetrievePersonDetails();
		personDetails2.retrieve();
		
	}

}
