package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		try {
            System.out.println("Creando socket cliente");
            Socket clientSocket = new Socket();
            System.out.println("Estableciendo conexion");
            InetSocketAddress addr = new InetSocketAddress("localhost", 5000);
            clientSocket.connect(addr);
            
            InputStream is = clientSocket.getInputStream();
            OutputStream os = clientSocket.getOutputStream();
            PrintWriter pw= new PrintWriter(new OutputStreamWriter(os));
            
            String mensaje="Introduce cadena: uno";
            String uno=sc.nextLine();
            pw.write(uno+"\n");
            pw.flush();
            System.out.println("Mensaje enviado");
            
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            
            String line;

            
//            do {
//            	String mensaje="Introduce cadena: ";
//                String uno=sc.nextLine();
//                pw.write(uno);
//                
//                System.out.println("Mensaje enviado");
//            	System.out.println(line);
//            	line= br.readLine();
//			} while ();
            
            while((line=br.readLine())!=null) {
            	System.out.println(line);
            	line=br.readLine();
            }
            
            
            
            System.out.println("Cerrando socket cliente");
            clientSocket.close();
            System.out.println("Terminado");
            
            br.close();
            pw.close();
            os.close();
            is.close();
            
            
            
		} catch (IOException e) {
            e.printStackTrace();

		}

	}

	public static String mensaje() {
		return null;
		
	}
}
