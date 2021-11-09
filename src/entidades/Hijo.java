package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the hijos database table.
 * 
 */
@Entity
@Table(name="hijos")
public class Hijo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int chicas;

	private int chicos;

	

	public Hijo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChicas() {
		return this.chicas;
	}

	public void setChicas(int chicas) {
		this.chicas = chicas;
	}

	public int getChicos() {
		return this.chicos;
	}

	public void setChicos(int chicos) {
		this.chicos = chicos;
	}

	

	

}