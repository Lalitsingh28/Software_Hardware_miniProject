package com.UseCases;

import java.util.Scanner;

import com.Dao.HodDao;
import com.Dao.HodDaoImpl;

public class HodLoginUses {
	
	public static void loginHod() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		HodDao hd = new HodDaoImpl();
		
		String result = hd.logInHod(uname, pass);

		System.out.println(result);
		
		DotUseCases.optionsHod();
		
	}

}
