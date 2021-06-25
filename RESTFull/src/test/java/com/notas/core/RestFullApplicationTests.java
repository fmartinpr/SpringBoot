package com.notas.core;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.notas.core.model.MNota;
import com.notas.core.service.NotaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestFullApplicationTests {
	/*@Autowired
	@Qualifier("servicio")
	private NotaService servicio;*/

	@Test
	public void contextLoads() {
		//List<MNota> lista = servicio.obtener();
		 String cadena = "<p><img src=\"https://evyalmsdes.endesa.es/webservice/pluginfile.php/221/mod_quiz/intro/error3.png\" alt=\"TEst_errro\" width=\"250\" height=\"120\" class=\"img-responsive atto_image_button_text-bottom\" /><br /></p><p><b>Prueba</b></p>";
		 int posicionInicial = cadena.indexOf("src=\"");
		 int posicionFinal = cadena.indexOf("\" ", posicionInicial);
		 String cadenaAux = cadena.substring(posicionInicial+5, posicionFinal);
		 cadena.replaceAll(cadenaAux, cadenaAux+"token");
		 

	}

}
