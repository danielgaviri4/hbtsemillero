package com.hbt.semillero.enums;
/**
 * 
 * <b>Descripción:<b> Clase que determina el enum de estado
 * <b>Caso de Uso:<b> hbt semillero
 * @author Daniel Gaviria
 * @version
 */
public enum EstadoEnum{
	
	ACTIVO("enum.estado.activo"), 
	INACTIVO("enum.estado.inactivo");
	
	
	/**
	 * Atributo que contiene la clave del mensaje para la internacionalizacion
	 */
	private String estado;

	/**
	 * Constructor que recibe como parametro el codigo del mensaje
	 * 
	 * @param codigoMensaje, Clave del mensaje para para internacionalizacion
	 */
	EstadoEnum(String estado) {
		this.estado = estado;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	

}
