package com.historiasclinicas.entidades;
// Generated 18-feb-2017 9:47:15 by Hibernate Tools 5.2.0.Beta1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Errorescongenitos generated by hbm2java
 */
@Entity
@Table(name = "errorescongenitos", catalog = "histocons")
public class Errorescongenitos implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7241811895731636817L;
	private Boolean biotidinasa;
	private Integer biotNorm;
	private Integer fenilcetNorm;
	private Boolean fenilcetonuria;
	private Boolean fqp;
	private Integer fqpNorm;
	private Integer galacNom;
	private Boolean galactosemia;
	private Integer hidroNorm;
	private Boolean hidroxiprogres;
	private Boolean hipotCong;
	private Integer hipotNorm;
	private Integer id;
	private String otrosErrores;
	private int paciente;

	public Errorescongenitos() {
	}

	public Errorescongenitos(int paciente) {
		this.paciente = paciente;
	}

	public Errorescongenitos(int paciente, Boolean hipotCong, Integer hipotNorm, Boolean fenilcetonuria,
			Integer fenilcetNorm, Boolean fqp, Integer fqpNorm, Boolean biotidinasa, Integer biotNorm,
			Boolean galactosemia, Integer galacNom, Boolean hidroxiprogres, Integer hidroNorm, String otrosErrores) {
		this.paciente = paciente;
		this.hipotCong = hipotCong;
		this.hipotNorm = hipotNorm;
		this.fenilcetonuria = fenilcetonuria;
		this.fenilcetNorm = fenilcetNorm;
		this.fqp = fqp;
		this.fqpNorm = fqpNorm;
		this.biotidinasa = biotidinasa;
		this.biotNorm = biotNorm;
		this.galactosemia = galactosemia;
		this.galacNom = galacNom;
		this.hidroxiprogres = hidroxiprogres;
		this.hidroNorm = hidroNorm;
		this.otrosErrores = otrosErrores;
	}

	@Column(name = "biotidinasa")
	public Boolean getBiotidinasa() {
		return biotidinasa;
	}

	@Column(name = "biotNorm")
	public Integer getBiotNorm() {
		return biotNorm;
	}

	@Column(name = "fenilcetNorm")
	public Integer getFenilcetNorm() {
		return fenilcetNorm;
	}

	@Column(name = "fenilcetonuria")
	public Boolean getFenilcetonuria() {
		return fenilcetonuria;
	}

	@Column(name = "fqp")
	public Boolean getFqp() {
		return fqp;
	}

	@Column(name = "fqpNorm")
	public Integer getFqpNorm() {
		return fqpNorm;
	}

	@Column(name = "galacNom")
	public Integer getGalacNom() {
		return galacNom;
	}

	@Column(name = "galactosemia")
	public Boolean getGalactosemia() {
		return galactosemia;
	}

	@Column(name = "hidroNorm")
	public Integer getHidroNorm() {
		return hidroNorm;
	}

	@Column(name = "hidroxiprogres")
	public Boolean getHidroxiprogres() {
		return hidroxiprogres;
	}

	@Column(name = "hipotCong")
	public Boolean getHipotCong() {
		return hipotCong;
	}

	@Column(name = "hipotNorm")
	public Integer getHipotNorm() {
		return hipotNorm;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "otrosErrores", length = 65535)
	public String getOtrosErrores() {
		return otrosErrores;
	}

	@Column(name = "paciente", nullable = false)
	public int getPaciente() {
		return paciente;
	}

	public void setBiotidinasa(Boolean biotidinasa) {
		this.biotidinasa = biotidinasa;
	}

	public void setBiotNorm(Integer biotNorm) {
		this.biotNorm = biotNorm;
	}

	public void setFenilcetNorm(Integer fenilcetNorm) {
		this.fenilcetNorm = fenilcetNorm;
	}

	public void setFenilcetonuria(Boolean fenilcetonuria) {
		this.fenilcetonuria = fenilcetonuria;
	}

	public void setFqp(Boolean fqp) {
		this.fqp = fqp;
	}

	public void setFqpNorm(Integer fqpNorm) {
		this.fqpNorm = fqpNorm;
	}

	public void setGalacNom(Integer galacNom) {
		this.galacNom = galacNom;
	}

	public void setGalactosemia(Boolean galactosemia) {
		this.galactosemia = galactosemia;
	}

	public void setHidroNorm(Integer hidroNorm) {
		this.hidroNorm = hidroNorm;
	}

	public void setHidroxiprogres(Boolean hidroxiprogres) {
		this.hidroxiprogres = hidroxiprogres;
	}

	public void setHipotCong(Boolean hipotCong) {
		this.hipotCong = hipotCong;
	}

	public void setHipotNorm(Integer hipotNorm) {
		this.hipotNorm = hipotNorm;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOtrosErrores(String otrosErrores) {
		this.otrosErrores = otrosErrores;
	}

	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}

}
