package com.yube;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class read_adapter {

	private ArrayList<contact> list = new ArrayList<>();

	public read_adapter() {

		File file = new File("data\\text.txt");

		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				splitter(sCurrentLine);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<contact> getList() {
		return list;
	}

	private void splitter(String sCurrentLine) {

		String[] parts = sCurrentLine.split("-");
		list.add(new contact(parts[0], parts[1] + parts[2], parts[3]));

	}

}
