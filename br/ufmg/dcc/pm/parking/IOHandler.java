package br.ufmg.dcc.pm.parking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOHandler{
	String strLine;
	FileInputStream fstream;
	BufferedReader br;

	public IOHandler(){
		try{
			fstream = new FileInputStream("entrada.txt");
			br = new BufferedReader(new InputStreamReader(fstream));
		}
		catch (IOException e){
		 		System.out.println("IOException");
		 	}
	}

	public String readInputLine(){
		
		try{
			if ((strLine = br.readLine()) != null)   {
		 		//System.out.println (strLine);
		 		return strLine;
			}
			else {
				br.close();
				return null;
			}
		} catch (Exception e) {
			//TODO
			return null;
		}

	}
}