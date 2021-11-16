package br.com.projetonttdata.api.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.projetonttdata.api.entity.Categoria;
import br.com.projetonttdata.api.repositories.CategoriaRepository;
import br.com.projetonttdata.api.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);

	@Autowired
	private CategoriaRepository repository;

	@Override
	public Categoria save(Categoria categoria) throws Exception{
		log.info("Save categoria", categoria);
		repository.save(categoria);
		return categoria;
	}

	@Override
	public List<Categoria> listar() {
		return repository.findAll( Sort.by(Sort.Direction.ASC, "nomeCategoria"));
	}

}
