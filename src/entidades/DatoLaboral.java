package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * The persistent class for the datos_laborales database table.
 * 
 */
@Entity
@Table(name="datos_laborales")
@NamedQuery(name="DatoLaboral.findAll", query="SELECT d FROM DatoLaboral d")
public class DatoLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int salario;

	//bi-directional many-to-one association to Cargo
	@ManyToOne(fetch=FetchType.LAZY) 
	//@JoinColumn(name="cargos_id") 
	@JoinFetch(JoinFetchType.OUTER)
	private Cargo cargo;


	@Transient
	private String edad;


	public DatoLaboral() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalario() {
		return this.salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}


}