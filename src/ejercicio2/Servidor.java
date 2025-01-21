 package ejercicio2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private static Cliente cliente;
	public static void main(String[] args) {
		try {
			System.out.println("Creacion del socket servidor");
			ServerSocket serverSocket = new ServerSocket();
			System.out.println("Realizacion del bind");
			InetSocketAddress isa= new InetSocketAddress("localhost",5000);
			serverSocket.bind(isa);
            System.out.println ("Espera a que llegue una petición de socket");
            Socket socket= serverSocket.accept();
            System.out.println ("Se ha establecido la conexión");

            InputStream is= socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
            
            
            String line;
            while((line=br.readLine())!=null) {
            	System.out.println(line);
            }            
            pw.print("Hola cliente "+ cliente.getIdentificador());
            
        	br.close();
			pw.close();
			is.close();
			os.close();
            
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
