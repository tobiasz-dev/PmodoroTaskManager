package GUI;


import javax.swing.*;

/*
/Klasa uruchumiaj�ca grafik� w nowym w�tku.
*/
public class GUI{
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run(){
				JFrame main = new MainWindow();
			}
		});
		
	}
}


