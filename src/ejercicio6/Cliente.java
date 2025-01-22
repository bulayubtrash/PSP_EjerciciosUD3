package ejercicio6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			System.out.println("Creando socket cliente");
			Socket cs= new Socket();
			System.out.println("Estableciendo coexion");
			InetSocketAddress addr= new InetSocketAddress("localhost",5000);
			cs.connect(addr);
			
			InputStream is = cs.getInputStream();
			OutputStream os = cs.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
			BufferedReader br= new BufferedReader(new InputStreamReader(is));
			
			String line=br.readLine();
			int num=Integer.parseInt(line);
			int nmio=Integer.MAX_VALUE;
			
			do {
				System.out.println("Introduce tu numero");
				nmio=sc.nextInt();
				if(nmio>num) {
					System.out.println("El numero a adivinar es menor");
				}else if(nmio<num) {
					System.out.println("El numero a adivinar es mayor");
				}else {
					nmio=num;
					System.out.println("Adivinado");
					break;
				}
			} while (num!=nmio);
			
            br.close();
            pw.close();
            os.close();
            is.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
