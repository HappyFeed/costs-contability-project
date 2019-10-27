package model;

public class Orden {
	
	private String nombre;
	private String periodo;
	private String estado;
	private double md;
	private double cif;
	private double mod;
	public static String ACTUAL;
	public static String ANTERIOR;
	public static String TERMINADO;
	public static String PROCESO;
	public static String VENDIDA;
	
	public Orden(String nombre, String periodo, String estado, double md, double cif, double mod) {
		this.nombre = nombre;
		this.periodo = periodo;
		this.estado = estado;
		this.md = md;
		this.cif = cif;
		this.mod = mod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getMd() {
		return md;
	}

	public void setMd(double md) {
		this.md = md;
	}

	public double getCif() {
		return cif;
	}

	public void setCif(double cif) {
		this.cif = cif;
	}

	public double getMod() {
		return mod;
	}

	public void setMod(double mod) {
		this.mod = mod;
	}
	
	
	
	
	

}
