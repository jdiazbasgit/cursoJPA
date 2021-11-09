package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * The persistent class for the datos_personales database table.
 * 
 */
@Entity
@Table(name="datos_personales")
public class DatoPersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Estado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="estados_civiles_id")
	@JoinFetch(JoinFetchType.OUTER)
	private EstadoCivil estadosCivile;

	//bi-directional many-to-one association to Hijo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hijos_id")
	@JoinFetch(JoinFetchType.OUTER)
	private Hijo hijo;

	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EstadoCivil getEstadosCivile() {
		return this.estadosCivile;
	}

	public void setEstadosCivile(EstadoCivil estadosCivile) {
		this.estadosCivile = estadosCivile;
	}

	public Hijo getHijo() {
		return this.hijo;
	}

	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}

}