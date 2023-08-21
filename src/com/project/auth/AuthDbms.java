package com.project.auth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;



public class AuthDbms {
	private final static String dataAuthPath = "../data/authData.txt";	//상대경로 설정

	public ArrayList<Auth> selectAuth() {
		
		ArrayList<Auth> authList = new ArrayList<Auth>();
		
		File f = new File(dataAuthPath);
		
		  try {
		         BufferedReader reader = new BufferedReader(new FileReader(f.getPath()));
		         String line = null;
		         while ((line = reader.readLine()) != null) {
		            String[] authLine = line.split(",");
		            Auth a = new Auth(authLine);
		            authList.add(a);   
		         }
		         reader.close();
		      } catch (Exception e) {
		         System.out.println(e.getMessage());
		         e.printStackTrace();
		      }

	      return authList;
	      
	   }
	
	public Auth selectAuth(String allCode) {
		
		Auth auth = new Auth();
		
		for(Auth a : selectAuth()){
			if(a.getAllCode().equals(allCode)){
				auth = a;
			}
		}
		return auth;
	}
	
	public Auth selectAuth(Auth auth) {
		
		return this.selectAuth(auth.getAllCode());
	}
	
	
	
	public void insertAuth (Auth auth, boolean append) {
		File authFile = new File(dataAuthPath);
		try {
			BufferedWriter bw = new BufferedWriter (new FileWriter (authFile, append));
			bw.write(auth.toString());
			bw. flush ();
			bw.close();
		}catch (Exception e) {
			System.out.println(e. getMessage ()) ;
		}
	}
	
	public void insertAuth (Auth auth) {
		if(selectAuth(auth) == null) {
			this. insertAuth (auth, true);
		}
	}
	
	public void deleteAuth(Auth auth) {
		ArrayList<Auth> list = selectAuth() ;
		if(selectAuth(auth) != null) {
			int i =0;
			for (Auth a : list) {
				if (!a.getAllCode () . equals(auth.getAllCode ())) {
					if (i == 0) {
						insertAuth(a, false);
					} else {
						insertAuth (a, true);
					}
					i++;
				}
			}
		}
	}	
	
	public void printAuthList() {
		for(Auth a : selectAuth()){
			System.out.print(a.toString());
		}
	}
}
