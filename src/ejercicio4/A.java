package ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;

public class A {
	public static void main(String[] args) {

		
	}

	public String leerFichero(String ruta) {
		String line="0";

		try(BufferedReader br= new BufferedReader(new FileReader(ruta))) {
			while((line= br.readLine())!=null) {
				return line;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return line;
		
	}
}
