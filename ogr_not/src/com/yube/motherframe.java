package com.yube;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JLabel;

public class motherframe extends JFrame {
	ArrayList<contact> list = new ArrayList<>();
	JComboBox name_combo = new JComboBox();
	JLabel not = new JLabel("");
	JComboBox ogr_combo = new JComboBox();

	public motherframe() {
		// TODO Auto-generated constructor stub
		setTitle("Ayþe ödev");
		setBounds(200, 200, 500, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		ogr_combo.setBounds(10, 12, 123, 36);
		getContentPane().add(ogr_combo);

		name_combo.setBounds(143, 11, 259, 39);
		getContentPane().add(name_combo);

		not.setBounds(428, 23, 46, 14);
		getContentPane().add(not);

		read_adapter ra = new read_adapter();
		list = ra.getList();

		ogr_combo.addItem("1.Öðretim");
		ogr_combo.addItem("2.Öðretim");
		name_fill(true);
		ogr_combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (ogr_combo.getSelectedItem().equals("1.Öðretim")) {
					name_fill(true);
				} else {
					name_fill(false);

				}
			}

		});

		name_combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				for (contact contact : list) {

					if (contact.getName().equals(name_combo.getSelectedItem())) {
						not.setText(contact.getNot());
					}
				}
			}
		});

	}

	private void name_fill(boolean b) {
		// TODO Auto-generated method stub
		name_combo.removeAllItems();

		if (b) {
			for (contact contact : list) {
				if (contact.getOgr_no().substring(4, 7).equals("123")) {
					name_combo.addItem(contact.getName());
				}

			}

		} else {

			for (contact contact : list) {
				System.out.println(contact.getOgr_no().substring(4, 7));
				if (contact.getOgr_no().substring(4, 7).equals("143")) {
					name_combo.addItem(contact.getName());
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new motherframe().setVisible(true);
			}
		});
	}
}
