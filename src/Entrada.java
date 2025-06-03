import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

import Lecturas.Lector;
import Lecturas.MiObjectOutputStream;

public class Entrada implements Serializable{
	private Usuario user;
	private LocalDate fSubida;
	private String aprendido, realizado, dificultades, herrramientas;

	
	public Entrada(Usuario user) {
		// TODO Auto-generated constructor stub
		this.user = user;
		fSubida = LocalDate.now();
		aprendido = Lector.pedString(Optional.of("Que has aprendido?"));
		realizado = Lector.pedString(Optional.of("Que has realizado?"));
		dificultades = Lector.pedString(Optional.of("Cuales son tus dificultades?"));
		herrramientas = Lector.pedString(Optional.of("Que herramientas has usado"));
	}
	public LocalDate getfSubida() {
		return fSubida;
	}

	public String getAprendido() {
		return aprendido;
	}

	public String getRealizado() {
		return realizado;
	}

	public String getDificultades() {
		return dificultades;
	}

	public String getHerrramientas() {
		return herrramientas;
	}

	public void setfSubida(LocalDate fSubida) {
		this.fSubida = fSubida;
	}

	public void setAprendido(String aprendido) {
		this.aprendido = aprendido;
	}

	public void setRealizado(String realizado) {
		this.realizado = realizado;
	}

	public void setDificultades(String dificultades) {
		this.dificultades = dificultades;
	}

	public void setHerrramientas(String herrramientas) {
		this.herrramientas = herrramientas;
	}

	public void mostrar() {
		System.out.println("Fecha : "+fSubida);
		System.out.println("Aprendido : "+aprendido);
		System.out.println("Relizado : "+realizado);
		System.out.println("Dificultades : "+dificultades);
		System.out.println("Herramientas : "+herrramientas);
		
	}
	
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public static void mostrarEntradas(Usuario u) {
		File f = new File("Entradas.obj");
		if(f.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
				try {
					while(true) {
						Entrada e = (Entrada) ois.readObject();
						if(e.getUser().getCorreo().equals(u.getCorreo())) {
							e.mostrar();
						}
					}
				}catch (EOFException e) {
					// TODO: handle exception
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
			}
		}
	}
	
	public void escribir() {
		File f = new File("Entradas.obj");
		if(f.exists()) {
		 	try (MiObjectOutputStream escritor = new MiObjectOutputStream()){
				escritor.writeObject(this);
			} catch (SecurityException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(f))){
				escritor.writeObject(this);
			} catch (SecurityException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
