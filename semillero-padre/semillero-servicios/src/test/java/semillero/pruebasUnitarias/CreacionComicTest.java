package semillero.pruebasUnitarias;

import static org.junit.Assert.assertArrayEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;
import com.hbt.semillero.rest.CreacionComicRest;

import junit.framework.Assert;

/**
 * 
 * <b>Descripción:<b> Clase que determina las pruebas unitarias para la creacion
 * de comics. <b>Caso de Uso:<b> hbt semillero
 * 
 * @author Daniel Gaviria
 * @version
 */
public class CreacionComicTest {

	private final static Logger log = Logger.getLogger(CreacionComicTest.class);

	/**
	 * Atributo que determina la lista de comics, lista de activos, lista inactivos.
	 */
	public ArrayList<ComicDTO> lstComicDTO = new ArrayList<>();
	public ArrayList<ComicDTO> lstComicDTOActivos;
	public ArrayList<ComicDTO> lstComicDTOInactivos;

	/**
	 * 
	 * Metodo encargado de enviar mensaje de inicio de pruebas <b>Caso de Uso</b>
	 * 
	 * @author Daniel Gaviria
	 *
	 */
	@BeforeTest
	public void inicializar() {
		/**
		 * Llamo al metodo privado de llenar lista comics, y a los metodos de separacion de comics.
		 */
		if (lstComicDTO.isEmpty()) {
			llenarListaComics();
		}
		this.lstComicDTOActivos = separacionDeComicsActivos();
		this.lstComicDTOInactivos = separacionDeComicsInactivos();
		BasicConfigurator.configure();// inicializa el logger con una config basica
		log.info(":::::::::INICIAN PRUEBAS UNITARIAS:::::::::");
	}

	/**
	 * 
	 * Metodo encargado de realizar la separacion de comics activos 
	 * <b>Caso de Uso</b>hbt semillero
	 * @author Daniel Gaviria
	 *
	 */
	private ArrayList<ComicDTO> separacionDeComicsActivos() {
		ArrayList<ComicDTO> lstTemp = new ArrayList<>();
		for (ComicDTO comicDTO : lstComicDTO) {
			if (comicDTO.getEstadoEnum() == EstadoEnum.ACTIVO) {
				lstTemp.add(comicDTO);
			}
		}
		return lstTemp;
	}

	/**
	 * 
	 * Metodo encargado de realizar la separacion de comics inactivos 
	 * <b>Caso de Uso</b>hbt semillero
	 * @author Daniel Gaviria
	 *
	 */
	private ArrayList<ComicDTO> separacionDeComicsInactivos() {
		ArrayList<ComicDTO> lstTemp = new ArrayList<>();
		for (ComicDTO comicDTO : lstComicDTO) {
			if (comicDTO.getEstadoEnum() == EstadoEnum.INACTIVO) {
				lstTemp.add(comicDTO);
			}

		}
		return lstTemp;

	}
	/**
	 * 
	 * Metodo encargado de creacion de los 10 comics donde escogi 6 inactivos
	 * <b>Caso de Uso</b>hbt semillero
	 * @author Usuario
	 *
	 */
	private void llenarListaComics() {
		/**
		 * Atributo que determina la fecha para la creacion de los comics
		 */
		LocalDate localDate = LocalDate.now();

		/**
		 * Creacion 6 de comicDtos inactivos para la realizacion de la prueba unitaria.
		 */
		ComicDTO comicDTO1 = new ComicDTO("1", "comic1", "editorial1", TematicaEnum.AVENTURAS, "coleccion1", 25,
				new BigDecimal(15000000), "autor1", true, localDate, EstadoEnum.INACTIVO, 1000L);
		ComicDTO comicDTO2 = new ComicDTO("2", "comic2", "editorial2", TematicaEnum.BELICO, "coleccion2", 25,
				new BigDecimal(15000000), "autor2", false, localDate, EstadoEnum.INACTIVO, 1000L);
		ComicDTO comicDTO3 = new ComicDTO("3", "comic3", "editorial3", TematicaEnum.DEPORTIVO, "coleccion3", 25,
				new BigDecimal(15000000), "autor3", true, localDate, EstadoEnum.INACTIVO, 1000L);
		ComicDTO comicDTO4 = new ComicDTO("4", "comic4", "editorial4", TematicaEnum.FANTASTICO, "coleccion4", 25,
				new BigDecimal(15000000), "autor4", false, localDate, EstadoEnum.INACTIVO, 1000L);
		ComicDTO comicDTO5 = new ComicDTO("5", "comic5", "editorial5", TematicaEnum.HISTORICO, "coleccion5", 25,
				new BigDecimal(15000000), "autor5", true, localDate, EstadoEnum.INACTIVO, 1000L);
		ComicDTO comicDTO6 = new ComicDTO("6", "comic6", "editorial6", TematicaEnum.AVENTURAS, "coleccion6", 25,
				new BigDecimal(15000000), "autor6", false, localDate, EstadoEnum.INACTIVO, 1000L);

		/**
		 * Creacion 4 de comicDtos activos para la realizacion de la prueba unitaria.
		 */
		ComicDTO comicDTO7 = new ComicDTO("7", "comic7", "editorial7", TematicaEnum.AVENTURAS, "coleccion7", 25,
				new BigDecimal(15000000), "autor7", true, localDate, EstadoEnum.ACTIVO, 1000L);
		ComicDTO comicDTO8 = new ComicDTO("8", "comic8", "editorial8", TematicaEnum.DEPORTIVO, "coleccion8", 25,
				new BigDecimal(15000000), "autor8", false, localDate, EstadoEnum.ACTIVO, 1000L);
		ComicDTO comicDTO9 = new ComicDTO("9", "comic9", "editorial9", TematicaEnum.HISTORICO, "coleccion9", 25,
				new BigDecimal(15000000), "autor9", true, localDate, EstadoEnum.ACTIVO, 1000L);
		ComicDTO comicDTO10 = new ComicDTO("10", "comic10", "editorial10", TematicaEnum.CIENCIA_FICCION, "coleccion10",
				25, new BigDecimal(15000000), "autor10", false, localDate, EstadoEnum.ACTIVO, 1000L);

		/**
		 * Añadiendo comics a un array creado para facilitar la elaboracion de metodos.
		 */
		lstComicDTO.add(comicDTO1);
		lstComicDTO.add(comicDTO2);
		lstComicDTO.add(comicDTO3);
		lstComicDTO.add(comicDTO4);
		lstComicDTO.add(comicDTO5);
		lstComicDTO.add(comicDTO6);
		lstComicDTO.add(comicDTO7);
		lstComicDTO.add(comicDTO8);
		lstComicDTO.add(comicDTO9);
		lstComicDTO.add(comicDTO10);
	}

	/**
	 * 
	 * Metodo encargado de validar la lista de activos con una prueba unitaria
	 * <b>Caso de Uso</b> hbt semillero
	 * 
	 * @author Daniel Gaviria
	 *
	 */
	@Test
	public void validarListaActivos() {

		log.info("Inicia ejecucion del metodo validarListaActivos()");

		Assert.assertNotNull(lstComicDTOActivos);
		for (ComicDTO comicDTO : lstComicDTOActivos) {
			if (comicDTO.getEstadoEnum() == EstadoEnum.ACTIVO) {
				System.out.println(comicDTO.toString());
			}
		}

		log.info("Finaliza la ejecucion del metodo validarListaActivos()");
	}
	/**
	 * 
	 * Metodo encargado de validar la lista de inactivos con una prueba unitaria y la impresion de el mensaje solicitado por 
	 * el profesor mediante una excepcion.
	 * <b>Caso de Uso</b> hbt semillero
	 * 
	 * @author Daniel Gaviria
	 *
	 */
	@Test
	public void validarListaInactivos() {

		log.info("Inicia ejecucion del metodo validarListaInactivos()");
		ArrayList<String> lstTemp = new ArrayList<>();
		
		Assert.assertNotNull(lstTemp);
		try {
			
			for (ComicDTO comicDTO : lstComicDTOInactivos) {
				if (comicDTO.getEstadoEnum() == EstadoEnum.INACTIVO) {
					lstTemp.add(comicDTO.getNombre());
				}
			}	
			
			throw new Exception("Se genero una excepcion");				
			
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(),"Se genero una excepcion");
			System.out.println("Se ha detectado que de " + lstComicDTO.size() + " comics se encontraron que "
					+ lstComicDTOActivos.size() + " se encuentran activos y " + lstComicDTOInactivos.size()
					+ " inactivos. Los comics inactivos son:" + lstTemp.toString());
		}

		log.info("Finaliza la ejecucion del metodo validarListaInactivos()");
	}
	/**
	 * 
	 * Metodo encargado de enviar mensaje de finalizacion de pruebas 
	 * <b>Caso de Uso</b> hbt semillero
	 * 
	 * @author Daniel Gaviria
	 *
	 */
	@AfterTest
	public void finalizaPruebasUnitarias() {
		log.info(":::::::::FINALIZA PRUEBAS UNITARIAS:::::::::");
	}
}
