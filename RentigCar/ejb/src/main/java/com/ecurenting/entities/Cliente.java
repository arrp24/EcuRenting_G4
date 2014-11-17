package com.ecurenting.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="clicodigo")
	private Integer clicodigo;
	
	@Column(name="cliCedula")
	private BigDecimal cliCedula ;

	@Column(name="cliApellido")
	private String cliApellido;

	@Column(name="cliEmail")
	private String cliEmail;

	@Column(name="cliEmpresa")
	private String cliEmpresa;

	@Column(name="cliFecha")
	private Date cliFecha;

	@Column(name="cliNombre")
	private String cliNombre;

	@Column(name="cliTelefono")
	private BigDecimal cliTelefono;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas;
	public Cliente() {
	}

	public int getClicodigo() {
		return this.clicodigo;
	}

	public void setClicodigo(int clicodigo) {
		this.clicodigo = clicodigo;
	}

	public String getCliApellido() {
		return this.cliApellido;
	}

	public void setCliApellido(String cliApellido) {
		this.cliApellido = cliApellido;
	}

	public BigDecimal getCliCedula() {
		return this.cliCedula;
	}

	public void setCliCedula(BigDecimal cliCedula) {
		this.cliCedula = cliCedula;
	}

	public String getCliEmail() {
		return this.cliEmail;
	}

	public void setCliEmail(String cliEmail) {
		this.cliEmail = cliEmail;
	}

	public String getCliEmpresa() {
		return this.cliEmpresa;
	}

	public void setCliEmpresa(String cliEmpresa) {
		this.cliEmpresa = cliEmpresa;
	}

	public Date getCliFecha() {
		return this.cliFecha;
	}

	public void setCliFecha(Date cliFecha) {
		this.cliFecha = cliFecha;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public BigDecimal getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(BigDecimal cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setCliente(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setCliente(null);

		return reserva;
	}

}