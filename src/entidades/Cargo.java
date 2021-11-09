package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the cargos database table.
 * 
 */
@Entity
@Table(name="cargos")
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to DatoLaboral
	@OneToMany(mappedBy="cargo")
	private Set<DatoLaboral> datosLaborales;

	public Cargo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<DatoLaboral> getDatosLaborales() {
		return this.datosLaborales;
	}

	public void setDatosLaborales(Set<DatoLaboral> datosLaborales) {
		this.datosLaborales = datosLaborales;
	}

	public DatoLaboral addDatosLaborale(DatoLaboral datosLaborale) {
		getDatosLaborales().add(datosLaborale);
		datosLaborale.setCargo(this);

		return datosLaborale;
	}

	public DatoLaboral removeDatosLaborale(DatoLaboral datosLaborale) {
		getDatosLaborales().remove(datosLaborale);
		datosLaborale.setCargo(null);

		return datosLaborale;
	}

}