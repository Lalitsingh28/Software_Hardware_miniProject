package com.UseCases;

import java.util.Scanner;

import com.Dao.EngineerDao;
import com.Dao.EngineerDaoImpl;
import com.Dao.HodDao;
import com.Exceptions.EngineerException;

public class EngineerLogin {
	
	public static void loginEngineer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		EngineerDao hd = new EngineerDaoImpl();
		
		String result;
		try {
			result = hd.logInEngineer(uname, pass);
			System.out.println(result);
		} catch (EngineerException e) {
			e.printStackTrace();
		}
		
		EngineerUseCasses.optionsEngineer();
		
	}

}
