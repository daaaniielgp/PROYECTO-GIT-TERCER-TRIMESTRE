import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Optional;

import Lecturas.Lector;
import Lecturas.MiObjectOutputStream;

public class Usuario implements Serializable{
	private String correo;
	private String password;
	
	public void establecerCorreo() {
		do {
			correo= Lector.pedString(Optional.of("Introduzca el correo"));
		}while(!correo.matches("^(?=.{1,254}$)(?=.{1,64}@)[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:(?:[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?\\.)+[A-Za-z]{2,}|\\[(?:IPv6:[A-Fa-f0-9:.]+|(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(?:\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3})\\])$"));
	}
	
	public void establercerPW() {
		do {
			password=Lector.pedString(Optional.of("Introduzca la contraseña de 8 caracteres"));
		}while(!password.matches("^.{8,}$"));
	}
	
	public String getCorreo() {
		return correo;
	}
	public String getPassword() {
		return password;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean usuarioValido() {
		boolean val = false;
		File f = new File("Usuarios.obj");
		if(f.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
				try {
					while(!val) {
						Usuario u = (Usuario) ois.readObject();
						if (u.getCorreo().equals(this.correo)&& u.getPassword().equals(this.password)) {
							val = true;
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
		return val;
	}
	
	public void escribir() {
		File f = new File("Usuarios.obj");
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
