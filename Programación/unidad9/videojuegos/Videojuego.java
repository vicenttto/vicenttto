package unidad9.videojuegos;

import java.util.Date;

public class Videojuego {

	// `id_juego`, `titulo`, `descripcion`, `id_genero1`, `id_genero2`, `id_secuela`, `precio`, `fecha_lanzamiento`, `puntuacion`, `clasificacion_edad`
	
	private String id;
	private String titulo;
	private String descripcion;
	private String id_genero1;
	private String id_genero2;
	private String id_secuela;
	private double precio;
	private int puntuacion;
	private int clasificacion_edad;
	private Date fecha_lanzamiento;
	
	public Videojuego(String id, String titulo, String descripcion, String id_genero1, String id_genero2,
			String id_secuela, double precio, int puntuacion, int clasificacion_edad, Date fecha_lanzamiento) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.id_genero1 = id_genero1;
		this.id_genero2 = id_genero2;
		this.id_secuela = id_secuela;
		this.precio = precio;
		this.puntuacion = puntuacion;
		this.clasificacion_edad = clasificacion_edad;
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getId_genero1() {
		return id_genero1;
	}

	public void setId_genero1(String id_genero1) {
		this.id_genero1 = id_genero1;
	}

	public String getId_genero2() {
		return id_genero2;
	}

	public void setId_genero2(String id_genero2) {
		this.id_genero2 = id_genero2;
	}

	public String getId_secuela() {
		return id_secuela;
	}

	public void setId_secuela(String id_secuela) {
		this.id_secuela = id_secuela;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getClasificacion_edad() {
		return clasificacion_edad;
	}

	public void setClasificacion_edad(int clasificacion_edad) {
		this.clasificacion_edad = clasificacion_edad;
	}

	public Date getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}

	public void setFecha_lanzamiento(Date fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", id_genero1="
				+ id_genero1 + ", id_genero2=" + id_genero2 + ", id_secuela=" + id_secuela + ", precio=" + precio
				+ ", puntuacion=" + puntuacion + ", clasificacion_edad=" + clasificacion_edad + ", fecha_lanzamiento="
				+ fecha_lanzamiento + "]";
	}
	
	
	
	
}
