package com.notas.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nota")
public class ClienteRest {
	@GetMapping("/all")
	public String devolverTodos() {
		return "notas";
	}
}
