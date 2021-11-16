package br.com.projetonttdata.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetonttdata.api.entity.Categoria;
import br.com.projetonttdata.api.services.CategoriaService;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {

	private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/")
	public @ResponseBody ResponseEntity<List<Categoria>> listar() {
		try {
			return ResponseEntity.ok().body(categoriaService.listar());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/")
	public @ResponseBody ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
		try {
			return ResponseEntity.ok().body(categoriaService.save(categoria));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

}
