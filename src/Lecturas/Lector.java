package Lecturas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Optional;

public class Lector implements Serializable{
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static String pedString(Optional<String> t) {
		String respuesta="";
		do {
			if(t.isEmpty()) {
				System.out.println("Introduzca una cadena");
			}else {
				System.out.println(t.get());
			}
			try {
				respuesta=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(respuesta.isBlank());
		return respuesta;
	}
	
	public static int pedInt(Optional<String> t, Optional<Integer>min, Optional<Integer>max) {
		int respuesta=0;
		boolean val;
		do {
			
			if(t.isEmpty()) {
				System.out.println("Introduzca un numero");
			}else {
				System.out.println(t.get());
			}
			try {
				val=true;
				respuesta=Integer.parseInt(br.readLine());
				if(min.isPresent()&& min.get()>respuesta) val = false; 
				if(max.isPresent()&& max.get()<respuesta) val = false; 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				val=false;
			} catch (NumberFormatException e) {
				val=false;
			}
		}while(!val );
		return respuesta;
	}

}
