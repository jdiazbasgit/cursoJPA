package entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * The persistent class for the empleados database table.
 * 
 */
@Entity
@Table(name="empleados")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String dni;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_alta")
	@Fetch(FetchMode.JOIN)
	private GregorianCalendar fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_nacimiento")
	@Fetch(FetchMode.JOIN)
	private GregorianCalendar fechaNacimiento;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to DatoLaboral
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="datos_laborale_id")
	@JoinFetch(JoinFetchType.OUTER)
	private DatoLaboral datosLaborale;

	//bi-directional many-to-one association to DatoPersonal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="datos_personale_id")
	@JoinFetch(JoinFetchType.OUTER)
	private DatoPersonal datosPersonale;

	public Empleado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	

	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(GregorianCalendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public DatoLaboral getDatosLaborale() {
		return this.datosLaborale;
	}

	public void setDatosLaborale(DatoLaboral datosLaborale) {
		this.datosLaborale = datosLaborale;
	}

	public DatoPersonal getDatosPersonale() {
		return this.datosPersonale;
	}

	public void setDatosPersonale(DatoPersonal datosPersonale) {
		this.datosPersonale = datosPersonale;
	}

}