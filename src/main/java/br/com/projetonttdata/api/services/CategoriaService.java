package br.com.projetonttdata.api.services;

import java.util.List;

import br.com.projetonttdata.api.entity.Categoria;

public interface CategoriaService {
	
	Categoria save(Categoria categoria);
	List<Categoria> listar();
}
