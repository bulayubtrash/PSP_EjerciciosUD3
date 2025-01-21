package ejercicio2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente extends Thread {
	private int identificador;

	public void run() {
		con();
	}

	public synchronized void con() {
		try {
			System.out.println("Creando socket cliente");
			Socket clientSocket = new Socket();
			System.out.println("Estableciendo conexion");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5000);
			clientSocket.connect(addr);

			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));

			pw.println("Soy el cliente " + getIdentificador());
			pw.flush();

			System.out.println("Mensaje enviado");

			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				line = br.readLine();
			}

			System.out.println("Cerrando socket cliente");
			clientSocket.close();
			System.out.println("Terminado");

			br.close();
			pw.close();
			os.close();
			is.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Cliente(int identificador) {
		super();
		this.identificador = identificador;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

}
