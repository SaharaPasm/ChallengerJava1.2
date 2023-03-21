package Desarrollo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class apiprueba {
	public static void main(String[] args) {
		try {
			String to="USD";
			String from="COP";
			
			URL url = new URL("https://api.apilayer.com/currency_data/convert?to="+to+"&from="+from+"&amount=15&apikey=78yLMmSlF4IHcEEkxCAQKqmN8lh5Np4A");
			//https://api.getgeoapi.com/v2/currency/convert?api_key=a8981a1b5e65087bb8b919f2a35f1a2e6b964150&from=COP&to=USD&amount=10&format=json
			// https://api.getgeoapi.com/v2/currency/convert?api_key=a8981a1b5e65087bb8b919f2a35f1a2e6b964150&from="+de+"&to="+a+"&amount="+monto"; 
			//https://api.getgeoapi.com/v2/currency/list?api_key=a8981a1b5e65087bb8b919f2a35f1a2e6b964150&format=json"
			HttpURLConnection conec= (HttpURLConnection) url.openConnection();
			conec.setRequestMethod("GET");
			conec.setRequestProperty("apikey", "78yLMmSlF4IHcEEkxCAQKqmN8lh5Np4A");
			conec.connect();
			
			//Peticion correcta? 
			
			int requestCode= conec.getResponseCode();
			if (requestCode == 200) {
				
				List informacionStri= new ArrayList();
				Scanner scanner = new Scanner(url.openStream());
				while(scanner.hasNext()) {
					informacionStri.add(scanner.nextLine());
									
				}
				scanner.close();
				
				//String valor=(String)informacionStri.get(12);
				//valor= valor.replaceAll("\"result\":", "");
				//double finnall = Double.parseDouble(valor);
					
				
				//Filtrar la información
				
				//System.out.println("El valor final es "+ finnall);
				
				System.out.println(informacionStri);
			}
			else {
				
				//Scanner que lee el flujo de datos
				throw new RuntimeException("Ocurrio error"+ requestCode);
				}
			conec.disconnect();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "INTENTALO MAS TARDE"+ e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
