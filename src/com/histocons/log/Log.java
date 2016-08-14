package com.histocons.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Log {
	
	 public static void crearLog(String Operacion) throws IOException {

			//Pregunta el archivo existe, caso contrario crea uno con el nombre log.txt
        	File folder = new File("C:\\ProgramData\\Historias Clinicas");
        	if (!folder.exists()) {
        		folder.mkdirs();
        		 CreaLog(Operacion);
        	}
        	else
        		CreaLog(Operacion);
	 }
	 
	 public static void CreaLog(String Operacion) throws IOException
	 {
		 FileWriter archivo = null;
	        
	    Calendar fechaActual = Calendar.getInstance();
     	String fecha = fechaActual.get(Calendar.DAY_OF_MONTH)
     			+" "+(fechaActual.get(Calendar.MONTH)+1)
     			+" "+fechaActual.get(Calendar.YEAR);
     	archivo = new FileWriter(new File("C:\\ProgramData\\Historias Clinicas\\log-HistoCons"+fecha+".log"), true);
		 
		 if (new File("C:\\ProgramData\\Historias Clinicas\\log-HistoCons"+fecha+".txt").exists()==false){
				archivo=new FileWriter(new File("C:\\ProgramData\\Historias Clinicas\\log-HistoCons"+fecha+".log"),false);
			}	
	        	archivo = new FileWriter(new File("C:\\ProgramData\\Historias Clinicas\\log-HistoCons"+fecha+".log"), true);
				
	             //Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar     
	            
				archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
					      +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
					      +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
					      +";"+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
					      +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
					      +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+";"+Operacion+"\r\n");
				
	            archivo.close();
	     }
	 }
