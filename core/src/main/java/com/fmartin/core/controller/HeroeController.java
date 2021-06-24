package com.fmartin.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmartin.core.DTO.HeroeDto;
import com.fmartin.core.entity.Heroe;
import com.fmartin.core.exception.CoreException;
import com.fmartin.core.service.HeroeService;

@RestController
@RequestMapping("/api/heroes")
@CrossOrigin(origins = "http://localhost:4200")
public class HeroeController {
	@Autowired
	HeroeService heroeService;
	
	@Autowired
    private ModelMapper modelMapper;
		
	@GetMapping("/all")
	public ResponseEntity<List<HeroeDto>> getAll(){
		List<Heroe> lstHeroe = this.heroeService.getHeroes();
		return new ResponseEntity<>(lstHeroe.stream().map(this::convertToDto).collect(Collectors.toList()), HttpStatus.OK);
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<HeroeDto> getById(@PathVariable("id") String id){
		return new ResponseEntity<>(this.convertToDto(this.heroeService.getById(id)), HttpStatus.OK);
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<HeroeDto> create(@RequestBody HeroeDto heroeDto){
		Heroe heroe = this.convertToEntity(heroeDto);
		return new ResponseEntity<>(this.convertToDto(this.heroeService.create(heroe)), HttpStatus.CREATED);
	}
	
	@PutMapping("/modificar/{idHeroe}")
	public ResponseEntity<HeroeDto> update(@RequestBody HeroeDto heroeDto, @PathVariable String idHeroe){
		Heroe heroe = this.convertToEntity(heroeDto);
		return new ResponseEntity<>(this.convertToDto(this.heroeService.update(heroe)), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{idHeroe}")
	public ResponseEntity<Boolean> delete(@PathVariable String idHeroe){
		this.heroeService.delete(idHeroe);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	private HeroeDto convertToDto(Heroe heroe) {
		return modelMapper.map(heroe, HeroeDto.class);
	}
	
	private Heroe convertToEntity(HeroeDto heroeDto) {
		return modelMapper.map(heroeDto, Heroe.class);
	}

}
