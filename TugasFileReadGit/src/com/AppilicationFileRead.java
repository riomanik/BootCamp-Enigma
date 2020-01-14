package com.enigma.camp.LatihanHeroes.src.com.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AppilicationFileRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Data> data = new ArrayList<Data>();
		File f = new File("C:/Users/EnigmaCamp/eclipse-workspace/KumpulanTugas/riomanik-academy/TugasFileReadGit/src/com/files_tugas-file.txt");
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String str = "";

			while (str != null) {
				str = br.readLine();
				if (str != null) {
					data.add(new Data(str));
				}
			}

			for (Data view : data) {
				System.out.println(view);
			}

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null)
				try {br.close();
				} catch (Exception e2) {
					System.out.println("fail to close buffered reader");
				};
				
			if(fr!=null)
				try {fr.close();
				} catch (Exception e2) {
					System.out.println("fail to close file reader");
				};
		}
	}

}
