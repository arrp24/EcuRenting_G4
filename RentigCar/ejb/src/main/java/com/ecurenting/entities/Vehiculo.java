package com.ecurenting.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehCodigo")
	private Integer vehCodigo;

	@Column(name="vehAnio")
	private int vehAnio;

	@Column(name="vehColor")
	private String vehColor;

	@Column(name="vehFecha")
	private Date vehFecha;

	@Column(name="vehKm")
	private BigInteger vehKm;

	@Column(name="vehMarca")
	private String vehMarca;

	@Column(name="vehModelo")
	private String vehModelo;

	@Column(name="vehPlaca")
	private String vehPlaca;

	@Column(name="vehProveedor")
	private String vehProveedor;

	//bi-directional many-to-one association to Mantenimiento
	@OneToMany(mappedBy="vehiculo")
	private List<Mantenimiento> mantenimientos;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="vehiculo")
	private List<Ruta> rutas;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="vehiculo")
	private List<Usuario> usuarios;

	//bi-directional many-to-one association to Monitoreo
	@ManyToOne
	@JoinColumn(name="monCodigo")
	private Monitoreo monitoreo;

	//bi-directional many-to-one association to Alquiler
	@ManyToOne
	@JoinColumn(name="alqCodigo")
	private Alquiler alquiler;

	public Vehiculo() {
	}

	public int getVehCodigo() {
		return this.vehCodigo;
	}

	public void setVehCodigo(int vehCodigo) {
		this.vehCodigo = vehCodigo;
	}

	public int getVehAnio() {
		return this.vehAnio;
	}

	public void setVehAnio(int vehAnio) {
		this.vehAnio = vehAnio;
	}

	public String getVehColor() {
		return this.vehColor;
	}

	public void setVehColor(String vehColor) {
		this.vehColor = vehColor;
	}

	public Date getVehFecha() {
		return this.vehFecha;
	}

	public void setVehFecha(Date vehFecha) {
		this.vehFecha = vehFecha;
	}

	public BigInteger getVehKm() {
		return this.vehKm;
	}

	public void setVehKm(BigInteger vehKm) {
		this.vehKm = vehKm;
	}

	public String getVehMarca() {
		return this.vehMarca;
	}

	public void setVehMarca(String vehMarca) {
		this.vehMarca = vehMarca;
	}

	public String getVehModelo() {
		return this.vehModelo;
	}

	public void setVehModelo(String vehModelo) {
		this.vehModelo = vehModelo;
	}

	public String getVehPlaca() {
		return this.vehPlaca;
	}

	public void setVehPlaca(String vehPlaca) {
		this.vehPlaca = vehPlaca;
	}

	public String getVehProveedor() {
		return this.vehProveedor;
	}

	public void setVehProveedor(String vehProveedor) {
		this.vehProveedor = vehProveedor;
	}

	public List<Mantenimiento> getMantenimientos() {
		return this.mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public Mantenimiento addMantenimiento(Mantenimiento mantenimiento) {
		getMantenimientos().add(mantenimiento);
		mantenimiento.setVehiculo(this);

		return mantenimiento;
	}

	public Mantenimiento removeMantenimiento(Mantenimiento mantenimiento) {
		getMantenimientos().remove(mantenimiento);
		mantenimiento.setVehiculo(null);

		return mantenimiento;
	}

	public List<Ruta> getRutas() {
		return this.rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public Ruta addRuta(Ruta ruta) {
		getRutas().add(ruta);
		ruta.setVehiculo(this);

		return ruta;
	}

	public Ruta removeRuta(Ruta ruta) {
		getRutas().remove(ruta);
		ruta.setVehiculo(null);

		return ruta;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setVehiculo(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setVehiculo(null);

		return usuario;
	}

	public Monitoreo getMonitoreo() {
		return this.monitoreo;
	}

	public void setMonitoreo(Monitoreo monitoreo) {
		this.monitoreo = monitoreo;
	}

	public Alquiler getAlquiler() {
		return this.alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

}