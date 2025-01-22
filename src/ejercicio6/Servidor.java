package ejercicio6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor {
	public static void main(String[] args) {
		try {
			System.out.println("Creacion del socket servdor");
			ServerSocket ss= new ServerSocket();
			System.out.println("Realizacion del bind");
			InetSocketAddress isa = new InetSocketAddress("localhost",5000);
			ss.bind(isa);
			System.out.println("Espera a que llegue una peticion de socket");
			Socket socket= ss.accept();
			System.out.println("Se ha establecido la conexion");
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintWriter pw= new PrintWriter(new OutputStreamWriter(os));
			
			Random rn = new Random();
			
			int num=rn.nextInt(10);
			
			pw.println(num);
			pw.flush();
			
			br.close();
			pw.close();
			is.close();
			os.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
