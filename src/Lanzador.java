

import java.io.File;
import java.util.Optional;

import Lecturas.Lector;

public class Lanzador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selecionUsuario();
		
	}
	
	public static void selecionUsuario() {
		System.out.println("SELECIONE UNA OPCION");
		int n = Lector.pedInt(Optional.of("1 Iniciar Sesion"
				+ "\n2 Resgistrarse"), Optional.of(1), Optional.of(2));
		
		switch(n) {
		case 1: iniciarSesion();break;
		case 2: registrarUsuario();;break;
		}
	}
	public static void iniciarSesion() { 
		System.out.println("INICIO SESION");
		Usuario inicio = new Usuario();
		inicio.establecerCorreo();
		inicio.establercerPW();
		if(inicio.usuarioValido()) {
			//Llamar siguiente paso
			gestionEntradas(inicio);
		}else {
			System.out.println("Usuario No valido");
			selecionUsuario();
		}
	}
	
	public static void registrarUsuario() {
		Usuario inicio = new Usuario();
		inicio.establecerCorreo();
		inicio.establercerPW();
		if(inicio.usuarioValido()) {
			System.out.println("Usuario existente incia sesion");
			iniciarSesion();
		}else {
			inicio.escribir();
			gestionEntradas(inicio);
		}
	}
	
	
	public static void gestionEntradas(Usuario u) {
		System.out.println("GESTION USUARIOS");
		System.out.println("SELECIONE UNA OPCION");
		int n = Lector.pedInt(Optional.of("1 Mostrar Entradas"
				+ "\n2 Añadir Entradas"
				+ "\n3 Salir"), Optional.of(1), Optional.of(3));
		
		switch(n) {
		case 1: Entrada.mostrarEntradas(u); gestionEntradas(u);;break;
		case 2: Entrada e = new Entrada(u); e.escribir();gestionEntradas(u);break;
		}
		
	}
	
}
