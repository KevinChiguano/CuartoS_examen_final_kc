package uce.edu.demo.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "avion")
public class Avion {
	
	@Id
    @Column(name = "avio_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "avio_id_seq")
    @SequenceGenerator(name = "avio_id_seq", sequenceName = "avio_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "avio_numero")
	private String numero;
	
	@Column(name = "avio_capacidad_asiento")
	private Integer capacidadAsiento;
	
	@Column(name = "avio_nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "avion")
	private List<Vuelo> vuelos;

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getCapacidadAsiento() {
		return capacidadAsiento;
	}

	public void setCapacidadAsiento(Integer capacidadAsiento) {
		this.capacidadAsiento = capacidadAsiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
	

}
