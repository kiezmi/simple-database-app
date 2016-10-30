package logic;

public class Mantainment {
	private String maquina, fecha, tipoActuacion, actuacion, tiempo;
	private int coste;
	private String comentario;

	public Mantainment(String maquina, String fecha, String tipoActuacion, String actuacion, int coste, String tiempo,
			String comentario) {
		setMaquina(maquina);
		setFecha(fecha);
		setTipoActuacion(tipoActuacion);
		setActuacion(actuacion);
		setCoste(coste);
		setTiempo(tiempo);
		setComentario(comentario);
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		if(maquina == null) throw new ExceptionInInitializerError("Value maquina can not be null");
		if(maquina.length()<1) throw new ExceptionInInitializerError("Value maquina can not be empty");
		this.maquina = maquina;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		if(fecha == null) throw new ExceptionInInitializerError("Value fecha can not be null");
		if(fecha.length()<1) throw new ExceptionInInitializerError("Value fecha can not be empty");
		this.fecha = fecha;
	}

	public String getTipoActuacion() {
		return tipoActuacion;
	}

	public void setTipoActuacion(String tipoActuacion) {
		if(tipoActuacion == null) throw new ExceptionInInitializerError("Value tipoActuacion can not be null");
		if(tipoActuacion.length()<1) throw new ExceptionInInitializerError("Value tipoActuacion can not be empty");
		this.tipoActuacion = tipoActuacion;
	}

	public String getActuacion() {
		return actuacion;
	}

	public void setActuacion(String actuacion) {
		if(actuacion == null) throw new ExceptionInInitializerError("Value actuacion can not be null");
		if(actuacion.length()<1) throw new ExceptionInInitializerError("Value actuacion can not be empty");
		this.actuacion = actuacion;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		if(coste < 0) throw new ExceptionInInitializerError("Value coste can not be negative");
		this.coste = coste;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		if(tiempo == null) throw new ExceptionInInitializerError("Value tiempo can not be null");
		if(tiempo.length()<1) throw new ExceptionInInitializerError("Value tiempo can not be empty");
		this.tiempo = tiempo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		if(comentario == null) throw new ExceptionInInitializerError("Value comentario can not be null");
		if(comentario.length()<1) throw new ExceptionInInitializerError("Value comentario can not be empty");
		this.comentario = comentario;
	}
}
