package ejemplos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimerEjemplo {

	public static void main(String[] args) {
		List<String> nombres=new ArrayList<>();
		for (int i = 0; i <1000000; i++) {
			nombres.add("pepe"+i);
		}
		
		nombres.stream().filter(nombre->Integer.parseInt(nombre.substring(nombre.lastIndexOf("e")+1))>500).filter(nombre->Integer.parseInt(nombre.substring(nombre.lastIndexOf("e")+1))%2==0)
		.forEach(nombre->System.out.println(nombre));
		

	}

}
