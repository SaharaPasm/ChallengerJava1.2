package Desarrollo;
import javax.swing.JOptionPane;
import Conversor.ConversorMoneda;
import Conversor.UnidadConversor;

public class Ejecutable  {

	public void menuinicio() {
		//menu de opciones 1
		JOptionPane.showMessageDialog(null, "BIENVENIDO A CONVERTIDOR 2023 " );
		Object [] menu= {"1- Conversor de Moneda", "2- Conversor de Longitud", "3- Salir"}; 
		Object opc= JOptionPane.showInputDialog(null, "MENU PRINCIPAL ","Menú" , JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
		JOptionPane.showMessageDialog(null, "Usted eligio:  " + opc);
		String opcmenu1 = (String)opc;
		
		if (opcmenu1!=null) {
			switch(opcmenu1) {
				case "1- Conversor de Moneda":
					ConversorMoneda conversormoneda= new ConversorMoneda();
					conversormoneda.menuConversor();
						
					break;
			
				case "2- Conversor de Longitud":
					UnidadConversor kilometros= new UnidadConversor();
					kilometros.menuKiolm();
				
					break;
			
				case  "3- Salir":
					JOptionPane.showMessageDialog(null,"GRACIAS POR USAR EL CONVERSOR ");
					break;
				default:
					
					break;
						
			}
			}
		else {
			JOptionPane.showMessageDialog(null, "NO ESCOGIO NINGUNA OPCION ", null, JOptionPane.INFORMATION_MESSAGE);
			
		}
			
		}
		
	}


