package br.com.projetonttdata.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetonttdata.api.entity.Categoria;
import br.com.projetonttdata.api.response.Response;
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
			return ResponseEntity.internalServerError().body(null);
		}
	}

	@PostMapping("/")
	public @ResponseBody ResponseEntity<Response<Categoria>> salvar(@Valid @RequestBody Categoria categoria, BindingResult result) {
		Response<Categoria> response = new Response<Categoria>();
		try {
			if(result.hasErrors()) {
				result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(response);
			}
			response.setData(categoriaService.save(categoria));
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(null);
		}
	}

}
