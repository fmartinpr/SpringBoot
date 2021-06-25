package com.notas.core.configuration;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	//Método para crear el JWT y enviarlo al cliente en el header de la respuesta
	static void addAuthentication(HttpServletResponse response, String username) {
		
		String token = Jwts.builder().setSubject(username)
			
		//Hash con el que firmamos la clave
		.signWith(SignatureAlgorithm.HS512, "P@tit0")
		.compact();
		
		//agregamos el encabezado el token
		response.addHeader("Authorization", "Bearer " + token);
	}
	
	//Método para validar el token enviado por el cliente
	public static Authentication getAuthentication(HttpServletRequest request) {
		
		//Obtenemos el token que viene en el encabezado de la petición
		String token = request.getHeader("Authorization");
		
		//si hay un token presente entonces los validamos
		if(token != null) {
			String user = Jwts.parser()
					.setSigningKey("P@tit0")
					.parseClaimsJws(token.replace("Bearer", "")) //este metodo es el que valida
					.getBody()
					.getSubject();
			
			// Recordamos que para las demás peticiones que no sean /login
			// no requerimos una autenticacion por username/password
			// por este motivo podemos devolver un UsernamePasswordAuthenticactionToken sin password
			return user != null ?
					new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) :
					null;
			
		}else {
			return null;
		}
	}

}
