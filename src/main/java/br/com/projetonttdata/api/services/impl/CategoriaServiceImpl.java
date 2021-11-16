package br.com.projetonttdata.api.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.projetonttdata.api.entity.Categoria;
import br.com.projetonttdata.api.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);

	//@Autowired
	//private EmpresaRepository empresaRepository;

	@Override
	public Categoria save(Categoria categoria) {
		log.info("Save categoria", categoria);
		return categoria;
	}

	@Override
	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
