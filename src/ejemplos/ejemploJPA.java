package ejemplos;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;



import entidades.Cargo;
import entidades.DatoLaboral;
import entidades.DatoPersonal;
import entidades.Empleado;
import entidades.EstadoCivil;
import entidades.Hijo;

public class ejemploJPA {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EjemplosFuncinal");
		EntityManager manager=factory.createEntityManager();
		
		
		
		manager.getTransaction().begin();
		
		
		/*
		 * DatoLaboral datoLaboral=manager.find(DatoLaboral.class, 1);
		 * System.out.println(datoLaboral.getCargo().getDescripcion()); DatoPersonal
		 * datoPersonal=manager.find(DatoPersonal.class, 1);
		 * System.out.println(datoPersonal.getHijo().getChicas()); Empleado empleado=
		 * new Empleado(); empleado.setNombre("pepe"); empleado.setDni("123456t");
		 * empleado.setTelefono("92929292"); empleado.setFechaAlta(new
		 * GregorianCalendar(2018,5,15)); empleado.setFechaNacimiento(new
		 * GregorianCalendar(1985,10,5)); empleado.setDatosLaborale(datoLaboral);
		 * empleado.setDatosPersonale(datoPersonal); manager.persist(empleado);
		 */
		
		Query query=manager.createQuery("from Empleado e");
		
		List<Empleado> empleados=query.getResultList();
		for (Empleado empleado : empleados) {
			System.out.println(empleado.getDatosLaborale().getCargo().getDescripcion());
		}
		manager.getTransaction().commit();
		
		
		manager.close();
		
	}
}
