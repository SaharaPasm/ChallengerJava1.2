package Conversor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import Desarrollo.API;
import Desarrollo.Ejecutable;
public class ConversorMoneda {

		
	public void menuConversor() {
		Object[] menuConversor= {"Pesos (COP) a Dolar (USD)", "Pesos (COP) a Euro(EUR)", "Pesos (COP) a Libra Esterlina(GBP)", "Pesos (COP) a Yen(JPY)", "Pesos (COP) a Won(KRW)", "Dolares(USD) a Pesos (COP)", "Euros (EUR) a Pesos (COP)", "Libra Esterlina (GBP) a Pesos (COP)", "Yen (JPY) a Pesos (COP)", "Won (KRW) a Pesos (COP)"}; 
		Object OpMoneda= JOptionPane.showInputDialog(null, "CONVERTIDOR DE MONEDAS ","Lista de Monedas" , JOptionPane.DEFAULT_OPTION, null, menuConversor,menuConversor[0]);
		JOptionPane.showMessageDialog(null, "Usted eligio:  " + OpMoneda);
		String OpMonedaElegida= (String) OpMoneda;
		
		
		if(OpMonedaElegida!=null) {
			
			try {
				String monto;
				monto= JOptionPane.showInputDialog("Ingrese cantidad a convertir");
				
						
				if (monto!= null  ) {
					JOptionPane.showMessageDialog(null, "El monto a Convertir es "+ monto);
					ConversorMoneda conversion=new ConversorMoneda();
					conversion.divisaResultado(OpMonedaElegida, monto);
					
				}
			}
				catch(NumberFormatException | NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Error, Por favor Solo Números "+ e);
					Ejecutable intento=new Ejecutable();
					intento.menuinicio();
				}
			}
		else {
			JOptionPane.showMessageDialog(null, "NO ESCOGIO NINGUNA OPCION - SALIR - ");
		}
		
		
	}
	
	
	public void divisaResultado(String Tipo, String montoConverir ) {
		String listaApi[];
		listaApi	= new String[4];
		String desde="", hasta="";
		
		switch(Tipo) {
		case "Pesos (COP) a Dolar (USD)":
			desde="COP";
			hasta="USD";
			break;
		case "Pesos (COP) a Euro(EUR)":
			desde="COP";
			hasta="EUR";
			break;
		case "Pesos (COP) a Libra Esterlina(GBP)":
			desde="COP";
			hasta="GBP";
			break;
		case "Pesos (COP) a Yen(JPY)":
			desde="COP";
			hasta="JPY";
			break;
		case "Pesos (COP) a Won(KRW)":
			desde="COP";
			hasta="KRW";
			break;
		case "Dolares(USD) a Pesos (COP)":
			desde="USD";
			hasta="COP";
			break;
		case "Euros (EUR) a Pesos (COP)":
			desde="EUR";
			hasta="COP";
			break;
		case "Libra Esterlina (GBP) a Pesos (COP)":
			desde="GBP";
			hasta="COP";
			break;
		case "Yen (JPY) a Pesos (COP)":
			desde="JPY";
			hasta="COP";
			break;
		case "Won (KRW) a Pesos (COP)":
			desde="KRW";
			hasta="COP";
			break;
			
		default:
			
			break;
		
		}//Switch monedas
		
		LocalDate fechaHoy=LocalDate.now();
		DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String fecha=fechaHoy.format(formato);
		listaApi[0]=fecha;
		listaApi[1]=montoConverir;
		listaApi[2]=desde;
		listaApi[3]=hasta;
		API resultado = new API();
		double valoRespuesta=resultado.get(listaApi[0], listaApi[1], listaApi[2], listaApi[3]);
		BigDecimal valorReal = new BigDecimal(valoRespuesta).setScale(2, RoundingMode.HALF_UP);		
		JOptionPane.showMessageDialog(null, "El valor de la divisa "+ Tipo + " es: $ "+ valorReal);
		repit();
	}
	
	
	public static void repit() {
		Object mensajeOpc=JOptionPane.showConfirmDialog(null, "¿Desea Continuar?", null, JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		int mensaje= (Integer) mensajeOpc;
		if(mensaje==0) {
			Ejecutable intento=new Ejecutable();
			intento.menuinicio();
		}
		else if(mensaje==1) {
			JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR EL CONVERSOR", null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
}// Principal 
