package Desarrollo;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class API {
	
	
	//https://apilayer.com/marketplace/currency_data-api
	//78yLMmSlF4IHcEEkxCAQKqmN8lh5Np4A
	public double get(String dia,String monto, String desde, String hasta ) {
	double finall=0;
		//Solicitar una peticion 
		// Lista de monedas 
		//https://api.getgeoapi.com/v2/currency/list?
		//clave:  api_key=a8981a1b5e65087bb8b919f2a35f1a2e6b964150
		try {
			URL url = new URL("https://api.apilayer.com/currency_data/convert?to="+hasta+"&from="+desde+"&amount="+monto+"&apikey=78yLMmSlF4IHcEEkxCAQKqmN8lh5Np4A");
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
				
				String valor=(String)informacionStri.get(11);
				valor= valor.replaceAll("\"result\":", "");
				finall= Double.parseDouble(valor);
					
				
				//Filtrar la información
				
				//System.out.println("El valor final es "+ finall);
				
				
			}
			else {
				
				//Scanner que lee el flujo de datos
				throw new RuntimeException("Ocurrio error"+ requestCode);
				}
			conec.disconnect();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "INTENTALO MAS TARDE"+ e, "Error", JOptionPane.ERROR_MESSAGE);
			Ejecutable intento=new Ejecutable();
			intento.menuinicio();
		}
		
	
		return finall;

	}

}

