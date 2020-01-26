/**
 * 
 */
package com.fmartin.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fmartin.core.service.ProductoService;

/**
 * @author fmgar
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoServiceTest {
	
	@Autowired
	ProductoService productoService;
	

    @Test
	public void getActiculos() {
		productoService.obtenerTodos();
	}

}
