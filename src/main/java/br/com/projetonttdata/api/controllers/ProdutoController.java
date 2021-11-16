package br.com.projetonttdata.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetonttdata.api.entity.Produto;
import br.com.projetonttdata.api.services.ProdutoService;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

	private static final Logger log = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired
	private ProdutoService prodService;
	
	@GetMapping(value = "/")
	public @ResponseBody ResponseEntity<List<Produto>> listar() {
		try {
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/")
	public @ResponseBody ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		try {
			
			return ResponseEntity.ok().body(prodService.save(produto));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/desativar/{id}")
	public @ResponseBody ResponseEntity<Produto> desativar(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok().body(prodService.desativar(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> deletar(@PathVariable("id") Long id) {
		try {
			prodService.deletar(id);
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PutMapping("/{id}")
	public @ResponseBody ResponseEntity<Produto> atualizar(@PathVariable("id") Long id, @RequestBody Produto produto) {
		try {
			return ResponseEntity.ok().body(prodService.upate(id, produto));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
}
