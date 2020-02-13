/**
 * 
 */
package com.fmartin.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fmartin.core.entity.Direccion;
import com.fmartin.core.entity.LineaPedido;
import com.fmartin.core.entity.Pedido;
import com.fmartin.core.entity.Producto;
import com.fmartin.core.entity.Usuario;
import com.fmartin.core.service.LineaPedidoService;
import com.fmartin.core.service.PedidoService;
import com.fmartin.core.service.ProductoService;
import com.fmartin.core.service.UsuarioService;

/**
 * @author fmgar
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoServiceTest {
	
	@Autowired
	ProductoService productoService;
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	LineaPedidoService lineaPedidoService;
	
	//@Test
	public void GenerarDatos() {

		List<Pedido> pedidos = new ArrayList<>();
		List<Producto> productos = productoService.obtenerTodos();
		Set<Direccion> direcciones = new HashSet<>();
		Usuario usuario = usuarioService.getByNombreUsuario("fmartin").get();
		
		direcciones.add(new Direccion("Calle 1", "Sevilla"));
		direcciones.add(new Direccion("Calle 2", "Sevilla"));
		direcciones.add(new Direccion("Calle 3", "Sevilla"));
		direcciones.add(new Direccion("Calle 4", "Sevilla"));
		direcciones.add(new Direccion("Calle 5", "Sevilla"));

		for (int i = 1; i < 2000; i++) {
			Pedido pedido = new Pedido("ES" + i);
			pedido.setDirecciones(direcciones);
			pedido.setUsuario(usuario);
			pedido.setLineas(new ArrayList<>());
			for(int x = 1; x < 19; x++) {
				LineaPedido linea = new LineaPedido(i*x*new Date().getMinutes(), pedido, productos.get(x-1));
				pedido.getLineas().add(linea);
			}
			pedido.setDirecciones(direcciones);
			pedidos.add(pedido);
		}
		
		this.pedidoService.guardar(pedidos);
		
		
		
		//System.out.print(pedidos);
	}
	
	//@Test
	public void mostrarTodos() {
		Long tiempo = new Date().getTime();
		this.pedidoService.mostrarTodos();
		tiempo = tiempo - new Date().getTime();
		
		System.out.println("Tiempo Ejecución: " + tiempo);
	}
	
	@Test
	public void mostrarTodosFetch() {
		Long tiempo = new Date().getTime();
		//Set<Pedido> pedidos = this.pedidoService.mostrarTodosFetch();
		Pedido pedido = this.pedidoService.getPedido(1L);
		System.out.println(pedido.getLineas());
		LineaPedido linea = pedido.getLineas().get(0);
		linea.setPedido(null);
		pedido.getLineas().remove(linea);
		//this.pedidoService.guardar(pedido);
		//this.lineaPedidoService.eliminar(1L);
		pedido = this.pedidoService.getPedido(1L);
		System.out.println(pedido.getLineas());
		
		/*for(Pedido pedido : pedidos){
			pedido.getUsuario().setRoles(usuarioService.getByIdUsuarioRoles(pedido.getUsuario().getId()));
		}*/
		
		tiempo =  new Date().getTime() - tiempo;
		
		System.out.println("Tiempo Ejecución: " + tiempo);
	}
}
