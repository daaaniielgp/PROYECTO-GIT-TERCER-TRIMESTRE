package grupal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class usuario {
	public usuario() {}
	private String email,contraseña;
	public void rellenar_usuario() throws IOException{
		pedir_email();
		pedir_contraseña();
	}
	public void pedir_contraseña() throws IOException {
		BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
		
		do{
			System.out.println("Introduzca la contraseña:");
			contraseña=lector.readLine();
		}while(contraseña.isBlank());
	}
	public void pedir_email() throws IOException {
		BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
		do{
			System.out.println("Introduzca la email:");
			email=lector.readLine();
		}while(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") );
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
