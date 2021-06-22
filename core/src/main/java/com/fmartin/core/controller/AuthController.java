/**
 * 
 */
package com.fmartin.core.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmartin.core.DTO.JwtDTO;
import com.fmartin.core.DTO.LoginUsuario;
import com.fmartin.core.DTO.Mensaje;
import com.fmartin.core.DTO.NuevoUsuario;
import com.fmartin.core.entity.Rol;
import com.fmartin.core.entity.Usuario;
import com.fmartin.core.enums.RolNombre;
import com.fmartin.core.security.jwt.JwtProvider;
import com.fmartin.core.service.RolService;
import com.fmartin.core.service.UsuarioService;

/**
 * @author fmgar
 *
 */

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(new Mensaje("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
		}

		if (usuarioService.existePorNombre(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity<>(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		if (usuarioService.existePorEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity<>(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);

		Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
				nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
		Set<String> rolesStr = new HashSet<String>();
		Set<Rol> roles = new HashSet<Rol>();
		for (String rol : rolesStr) {
			switch (rol) {
			case "admin":
				Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
				roles.add(rolAdmin);
				break;
			default:
				Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
				roles.add(rolUser);

			}
		}

		usuario.setRoles(roles);
		this.usuarioService.guardar(usuario);
		return new ResponseEntity<>(new Mensaje("usuario guardado"), HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
		
		this.usuarioService.getByIdUsuario(3l);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDTO jwDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity<JwtDTO>(jwDTO, HttpStatus.OK);
		
	}
	
	@GetMapping("/authorities")
	public ResponseEntity<List<SimpleGrantedAuthority>> getAuthorities(){
		return new ResponseEntity<List<SimpleGrantedAuthority>>(this.usuarioService.getAuthorities(), HttpStatus.OK);
	}

}
