package Lecturas;
import java.io.*;


public class MiObjectOutputStream extends ObjectOutputStream implements Serializable
{
	/** Constructor que recibe OutputStream */
    public MiObjectOutputStream(OutputStream out) throws IOException
    {   super(out);  }
    /** Constructor sin par�metros */
    public MiObjectOutputStream() throws IOException, SecurityException
    {   super();   }
    /** Redefinici�n del m�todo de escribir la cabecera para que no haga nada. */
    public void writeStreamHeader() throws IOException
    {    }
}
 