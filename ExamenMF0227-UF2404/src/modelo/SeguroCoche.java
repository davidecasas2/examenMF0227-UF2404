package modelo;

import java.util.Calendar;

public class SeguroCoche extends Poliza {

	protected String matricula;
	protected int anyoCarnet;
	public static final double PORCENTAJE_ANTIGUEDAD = 0.015;
	public static final double RECARGO_NOVEL=75;
	public static final double RECARGO_SINIESTRO=0.03;
	
	
	
	public SeguroCoche() {
		super();
		this.matricula="";
		this.anyoCarnet=Calendar.getInstance().get(Calendar.YEAR);;
	}
	
	public SeguroCoche(String idPoliza, String nombre, String apellidos, String dni, int anyo, String formaPago,
			double primaBase, int numSieniestrosHistorico, String matricula, int anyoCarnet) {
		super(idPoliza, nombre, apellidos, dni, anyo, formaPago, primaBase, numSieniestrosHistorico);
		this.matricula = matricula;
		this.anyoCarnet = anyoCarnet;
	}

	// getters y setter

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getAnyoCarnet() {
		return anyoCarnet;
	}

	public void setAnyoCarnet(int anyoCarnet) {
		this.anyoCarnet = anyoCarnet;
	}
	
	

	@Override
	public String toString() {
		return "SeguroCoche [idPoliza=" + idPoliza + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", anyo=" + anyo + ", formaPago=" + formaPago + ", primaBase=" + primaBase
				+ ", numSieniestrosHistorico=" + numSieniestrosHistorico + ", matricula=" + matricula + ", anyoCarnet="
				+ anyoCarnet + "]";
	}

	@Override
	public double calcularPrima() {
		int antSeguro= 
				Calendar.getInstance().get(Calendar.YEAR)-anyo;
		int antCarnet =
				Calendar.getInstance().get(Calendar.YEAR)-anyoCarnet;
		
		if (antSeguro>10) {
			antSeguro=10;
		}
		double primaTotal = primaBase - 
				(primaBase*PORCENTAJE_ANTIGUEDAD)*antSeguro;
		if (antCarnet<5) {
			primaTotal=primaTotal+RECARGO_NOVEL;
		}
		primaTotal = primaTotal + primaTotal*RECARGO_SINIESTRO
				*numSieniestrosHistorico;
		
		return primaTotal;
	}
}
