package herramientas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

@SuppressWarnings("unused")
public class ProgressSample {
	
  public static class BarThread extends Thread {
    private static int DELAY = 50;
    private static int bandera=0;
    private static  JFrame theFrame;
    public BarThread(){
    	super();
    }
    
    public void comenzar(){
    	
    	 final JProgressBar aJProgressBar = new JProgressBar(0, 50);
    	    aJProgressBar.setStringPainted(false);

    	 String title = ("Trabajando...");
    	 
    	   theFrame = new JFrame(title);
    	    
    	    theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	   Container contentPane = theFrame.getContentPane();
    	    contentPane.add(aJProgressBar, BorderLayout.NORTH);
    	   // contentPane.add(aJButton, BorderLayout.SOUTH);
    	   
    	    Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

    	    int alto = pantalla.height;

    	    int ancho = pantalla.width;


    	    theFrame.setSize(400, 70);
    	  
    	    //theFrame.setLocation(ancho/2-theFrame.getWidth()/2, alto/2-theFrame.getHeight()/2);
    	  
    	    theFrame.setVisible(true);
    	    
    	    Thread stepper = new BarThread(aJProgressBar);
    	    stepper.start();
    	    
    	   
    }
    
    public static int getBandera() {
		return bandera;
	}

	public void setBandera(int bandera) {
		BarThread.bandera = bandera;
		
	}

	JProgressBar progressBar;

    public BarThread(JProgressBar bar) {
      progressBar = bar;
    }

    public void run() {
      int minimum = progressBar.getMinimum();
      int maximum = progressBar.getMaximum();
      Runnable runner = new Runnable() {
        public void run() {
        
          int value = progressBar.getValue();
          progressBar.setValue(value + 1);
          
        }
      };
      for (int i = minimum; i < maximum; i++) {
        try {
          SwingUtilities.invokeAndWait(runner);
          // our job for each step is to just sleep
          Thread.sleep(DELAY);
        } catch (InterruptedException ignoredException) {
        } catch (InvocationTargetException ignoredException) {
        }
        if(i==maximum-1 && bandera==0){
        	i=0;
        	progressBar.setValue(0);
        	
        }else{
        	if(i==maximum-1)        	
        	theFrame.dispose();
        }
        
      }
      
      
    }
  }

 
}