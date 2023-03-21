package Conversor;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JOptionPane;

import Desarrollo.Ejecutable;

public class UnidadConversor {
	public void menuKiolm() {
		Object[] menuKilom= {"Metros a Pies", "Metros a Yardas", "Metro a Milla", "Metro a Kilometros", "Metro a Centimetros"}; 
		Object OpKilo= JOptionPane.showInputDialog(null, "CONVERTIDOR DE LONGITUD ","Lista metros" , JOptionPane.DEFAULT_OPTION, null, menuKilom,menuKilom[0]);
		JOptionPane.showMessageDialog(null, "Usted eligio:  " + OpKilo);
		String OpKiloElegida= (String) OpKilo;
		
		
		if(OpKiloElegida!=null) {
			
			try {
				String Longitud;
				Longitud= JOptionPane.showInputDialog("Ingrese cantidad a convertir");
				double longituInt= Double.parseDouble(Longitud);
						
				if (Longitud!= null  ) {
					JOptionPane.showMessageDialog(null, "El monto a Convertir es "+ Longitud);
					UnidadConversor convKilometros=new UnidadConversor();
					convKilometros.logitudResultado(OpKiloElegida, longituInt);
					
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

	
	public void logitudResultado(String conversion, double lngitud){
		double resultado=0;
		double pie= 3.281;
		double yarda=1.094;
		double millas=1609;
		String dato="";
		
		
		
		switch(conversion) {
		
			case "Metros a Pies" :
				resultado=lngitud*pie;
				dato="Pies";
				break;
			case "Metros a Yardas":
				resultado=lngitud*yarda;
				dato="Yardas";
				break;
			case "Metro a Milla":
				resultado=lngitud/millas;
				dato="Millas";
				break;
			case "Metro a Kilometros":
				resultado= lngitud/1000;
				dato="Kilometros";
				break;
			case "Metro a Centimetros":
				resultado=lngitud*100;
				dato="Centimetros";
				break;
			case "Pies a Metros":
				resultado=lngitud*pie;
				dato="Pies";
				break;
			
			default:
			break;
			
				
			
				
		}
		BigDecimal valorReal2 = new BigDecimal(resultado).setScale(2, RoundingMode.HALF_UP);	
		
		JOptionPane.showMessageDialog(null,"El valor de la conversión  "+ conversion+ " es : "+ valorReal2 + dato);
		
		ConversorMoneda.repit();
		
	}
	

}
