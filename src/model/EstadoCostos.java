package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EstadoCostos {
	
	private String nombreEmpresa;
	private String periodoRealizacion;
	private String texto;
	private double variacion;
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
	private double cifReales;
	
	private ArrayList<Orden> ordenes;
	
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
	
	public void setOrdenes(ArrayList<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public void setPeriodoRealizacion(String periodoRealizacion) {
		this.periodoRealizacion = periodoRealizacion;
	}

	public double getCifReales() {
		return cifReales;
	}

	public void setCifReales(double cifReales) {
		this.cifReales = cifReales;
	}

	public void exportCostState(String path) throws FileNotFoundException {
		  PrintWriter pw= new PrintWriter(new File(path));
		  String evalu="";
		  File f=new File(path);
		  String nameFile=f.getName();
		  if(nameFile.equals("data/EstadoDeCostos.txt")) {
			  
		  }else {
			  for(int i=0;i<ordenes.size();i++) {
				  if (ordenes.get(i).getPeriodo().equals("ACTUAL")) {
				  invInicialMD+=ordenes.get(i).getMd();
				  mod+=ordenes.get(i).getMod();
				  cif+=ordenes.get(i).getCif();
				  }
				  if (ordenes.get(i).getPeriodo().equals("ANTERIOR")&&ordenes.get(i).getEstado().equals("PROCESO")) {
					  invInicialPP+=ordenes.get(i).totalCosto();
				  }	 else if (ordenes.get(i).getPeriodo().equals("ACTUAL")&&ordenes.get(i).getEstado().equals("PROCESO")) {
					invFinalPP+=ordenes.get(i).totalCosto();
				  }
				  
				  if (ordenes.get(i).getPeriodo().equals("ANTERIOR")&&ordenes.get(i).getEstado().equals("TERMINADA")) {
					invInicialPT+=ordenes.get(i).totalCosto();
				  }else if (ordenes.get(i).getPeriodo().equals("ACTUAL")&&ordenes.get(i).getEstado().equals("TERMINADA")) {
					invFinalPT+=ordenes.get(i).totalCosto();
				  }
				  
				  variacion=cifReales-cif;
				  if(variacion<0) {
					texto="Sub";
				  }else if (variacion>0) {
					texto="Sobre";
				  }else {
					texto="es igual";
				  }
			
				  
				  
			  }
			  
			  setConsumoDeMD();
			  setCostoAgregadosdeProduccion();
			  setCostoTotalPT();
			  setCostoDeVenta();
			  
			  evalu+="----------------------------------------------------------------------------" + "\n";
			  evalu+=" "+nombreEmpresa + "\n";
			  evalu+=" Estado de Costos"+ "\n";
			  evalu+=" "+periodoRealizacion +"\n";
			  evalu+="----------------------------------------------------------------------------" + "\n"+ "\n";
			  evalu+=" Inventario Inicial de Material Directo         $"+invInicialMD+"\n";
			  evalu+=" Compras de Material Directo                    $"+compras+"\n";
			  evalu+=" Inventario Final de Material Directo           $-"+invFinalMD+"\n";
			  evalu+=" ______________________________________________________________"+"\n";
			  evalu+=" Consumo de Material Directo                    $"+consumoDeMD+"\n";
			  evalu+=" Mano de Obra Directa                           $"+mod+"\n";
			  evalu+=" Costos Indirectos de Fabricación               $"+cif+"\n";
			  evalu+=" _______________________________________________________________"+"\n";
			  evalu+=" Costos Agregados de Producción                 $"+costoAgregadosdeProduccion+"\n";
			  evalu+=" Inventario Inicial de Productos en Proceso     $"+invInicialPP+"\n";
			  evalu+=" Inventario Final de Productos en Proceso       $-"+invFinalPP+"\n";
			  evalu+=" _______________________________________________________________"+"\n";
			  evalu+=" Costos Total de Producto Terminado             $"+costoTotalPT+"\n";
			  evalu+=" Inventario Inicial de Producto Terminado       $"+invInicialPT+"\n";
			  evalu+=" Inventario Final de Producto Terminado         $-"+invFinalPT+"\n";
			  evalu+=" _______________________________________________________________"+"\n";
			  evalu+=" Costos de Venta                                $"+costoDeVenta+"\n"+"\n"+"\n";
			  evalu+=" Su variación con respecto a los Costos Indirectos de Fabricación Reales es: "+variacion+"Y esta es"+texto+"\n";

		  } 
		  pw.println(evalu);
		  pw.close();
	  }
	

}
