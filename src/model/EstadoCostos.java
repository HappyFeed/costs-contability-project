package model;

public class EstadoCostos {
	
	private double invInicialMD;
	private double compras;
	private double invFinalMD;
	private double consumoDeMD;
	private double mod;
	private double cif;
	private double costoAgregadosdeProduccion;
	private double invInicialPP;
	private double invFinalPP;
	private double costoTotalPT;
	private double invInicialPT;
	private double invFinalPT;
	private double costoDeVenta;
	
	public EstadoCostos() {
	}

	public double getInvInicialMD() {
		return invInicialMD;
	}

	public void setInvInicialMD(double invInicialMD) {
		this.invInicialMD = invInicialMD;
	}

	public double getCompras() {
		return compras;
	}

	public void setCompras(double compras) {
		this.compras = compras;
	}

	public double getInvFinalMD() {
		return invFinalMD;
	}

	public void setInvFinalMD(double invFinalMD) {
		this.invFinalMD = invFinalMD;
	}

	public double getConsumoDeMD() {
		return consumoDeMD;
	}

	public void setConsumoDeMD() {
		this.consumoDeMD = invInicialMD+compras-invFinalMD;
	}

	public double getMod() {
		return mod;
	}

	public void setMod(double mod) {
		this.mod = mod;
	}

	public double getCif() {
		return cif;
	}

	public void setCif(double cif) {
		this.cif = cif;
	}

	public double getCostoAgregadosdeProduccion() {
		return costoAgregadosdeProduccion;
	}

	public void setCostoAgregadosdeProduccion() {
		this.costoAgregadosdeProduccion = consumoDeMD+mod+cif;
	}

	public double getInvInicialPP() {
		return invInicialPP;
	}

	public void setInvInicialPP(double invInicialPP) {
		this.invInicialPP = invInicialPP;
	}

	public double getInvFinalPP() {
		return invFinalPP;
	}

	public void setInvFinalPP(double invFinalPP) {
		this.invFinalPP = invFinalPP;
	}

	public double getCostoTotalPT() {
		return costoTotalPT;
	}

	public void setCostoTotalPT() {
		this.costoTotalPT = costoAgregadosdeProduccion+invInicialPP-invFinalPP;
	}

	public double getInvInicialPT() {
		return invInicialPT;
	}

	public void setInvInicialPT(double invInicialPT) {
		this.invInicialPT = invInicialPT;
	}

	public double getInvFinalPT() {
		return invFinalPT;
	}

	public void setInvFinalPT(double invFinalPT) {
		this.invFinalPT = invFinalPT;
	}

	public double getCostoDeVenta() {
		return costoDeVenta;
	}

	public void setCostoDeVenta() {
		this.costoDeVenta = costoTotalPT+invInicialPT-invFinalPT;
	}
	
	
	

}
