package herramientas;

import javax.swing.JFileChooser;

public class FileChooser {

public FileChooser(){
	
}

//Creamos selector de apertura
public String lanzarSeleccion(){
	
JFileChooser chooser = new JFileChooser();

chooser.setCurrentDirectory(new java.io.File("."));

//Titulo que llevara la ventana

chooser.setDialogTitle("Seleccione");

//Elegiremos archivos del directorio

chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

chooser.setAcceptAllFileFilterUsed(true);

//Si seleccionamos algún archivo retornaremos su directorio

if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

System.out.println("Directorio: " + chooser.getSelectedFile());

//Si no seleccionamos nada retornaremos No seleccion

} else {

System.out.println("No seleccion ");

}
return chooser.getSelectedFile().toString();

}
public String lanzarSeleccionDeCarpeta(){
	
	JFileChooser chooser = new JFileChooser();

	chooser.setCurrentDirectory(new java.io.File("."));

	//Titulo que llevara la ventana

	chooser.setDialogTitle("Seleccione");

	//Elegiremos archivos del directorio

	chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

	chooser.setAcceptAllFileFilterUsed(true);

	//Si seleccionamos algún archivo retornaremos su directorio

	if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

	System.out.println("Directorio: " + chooser.getSelectedFile());

	//Si no seleccionamos nada retornaremos No seleccion

	} else {

	System.out.println("No seleccion");
	return "No seleccion";

	}
	return chooser.getSelectedFile().toString();

	}

}
