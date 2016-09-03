package GUI;


import javax.swing.*;

/*
/Klasa uruchumiaj¹ca grafikê w nowym w¹tku.
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


