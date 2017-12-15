package json_ders;

import java.util.HashMap;

import javax.swing.JFrame;

public class main  extends JFrame{

	
	public main() {

       this.setSize(500,500);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setTitle("jsoup");
       
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new main().setVisible(true);
	    new json().json_parser();
	
	}

}
