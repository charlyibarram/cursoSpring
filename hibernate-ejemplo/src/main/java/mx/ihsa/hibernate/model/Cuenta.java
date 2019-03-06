package mx.ihsa.hibernate.model;
// Generated 19/02/2019 02:54:12 PM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cuenta generated by hbm2java
 */
@Entity
@Table(name = "cuenta", schema = "public")
public class Cuenta implements java.io.Serializable {

	private int idCta;
	private Cliente cliente;
	private String noCta;
	private Date fchAlt;
	private Date fchCre;
	private Date fchMod;
	private String noTar;
	private Set<Movimiento> movimientos = new HashSet<Movimiento>(0);

	public Cuenta() {
	}

	public Cuenta(int idCta, Cliente cliente, Date fchAlt, Date fchCre) {
		this.idCta = idCta;
		this.cliente = cliente;
		this.fchAlt = fchAlt;
		this.fchCre = fchCre;
	}

	public Cuenta(int idCta, Cliente cliente, String noCta, Date fchAlt, Date fchCre, Date fchMod, String noTar,
			Set<Movimiento> movimientos) {
		this.idCta = idCta;
		this.cliente = cliente;
		this.noCta = noCta;
		this.fchAlt = fchAlt;
		this.fchCre = fchCre;
		this.fchMod = fchMod;
		this.noTar = noTar;
		this.movimientos = movimientos;
	}

	@Id

	@Column(name = "id_cta", unique = true, nullable = false)
	public int getIdCta() {
		return this.idCta;
	}

	public void setIdCta(int idCta) {
		this.idCta = idCta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cte", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Column(name = "no_cta", length = 20)
	public String getNoCta() {
		return this.noCta;
	}

	public void setNoCta(String noCta) {
		this.noCta = noCta;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fch_alt", nullable = false, length = 29)
	public Date getFchAlt() {
		return this.fchAlt;
	}

	public void setFchAlt(Date fchAlt) {
		this.fchAlt = fchAlt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fch_cre", nullable = false, length = 29)
	public Date getFchCre() {
		return this.fchCre;
	}

	public void setFchCre(Date fchCre) {
		this.fchCre = fchCre;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fch_mod", length = 29)
	public Date getFchMod() {
		return this.fchMod;
	}

	public void setFchMod(Date fchMod) {
		this.fchMod = fchMod;
	}

	@Column(name = "no_tar", length = 20)
	public String getNoTar() {
		return this.noTar;
	}

	public void setNoTar(String noTar) {
		this.noTar = noTar;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta")
	public Set<Movimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

}
