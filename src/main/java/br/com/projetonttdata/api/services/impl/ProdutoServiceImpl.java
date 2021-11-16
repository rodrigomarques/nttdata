package br.com.projetonttdata.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.projetonttdata.api.entity.Categoria;
import br.com.projetonttdata.api.entity.Produto;
import br.com.projetonttdata.api.entity.Status;
import br.com.projetonttdata.api.repositories.CategoriaRepository;
import br.com.projetonttdata.api.repositories.ProdutoRepository;
import br.com.projetonttdata.api.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private static final Logger log = LoggerFactory.getLogger(ProdutoServiceImpl.class);

	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Produto save(final Produto produto) throws Exception {
		if(produto.getCategoria() == null) throw new Exception("Categoria não pode ser nula");
		
		final Categoria categoria = categoriaRepository.findById(produto.getCategoria().getId()).get();
		produto.setCategoria(categoria);		
		produto.setStatus(Status.ATIVO);
		
		return repository.save(produto);
	}

	@Override
	public Produto upate(final Long id, final Produto produto) throws Exception {
		Produto prod = repository.getById(id);
		if(prod == null) throw new Exception("Produto não encontrado");
		
		prod.clone(produto);
		prod.setStatus(Status.ATIVO);
		return repository.save(prod);
	}

	@Override
	public void deletar(final Long id) throws Exception {
		Produto prod = repository.getById(id);
		if(prod == null) throw new Exception("Produto não encontrado");
		
		repository.delete(prod);
	}
	
	@Override
	public Produto desativar(final Long id) throws Exception {
		Produto prod = repository.findById(id).get();
		if(prod == null) throw new Exception("Produto não encontrado");
		
		prod.setStatus(Status.INATIVO);
		repository.save(prod);
		return prod;
	}

	@Override
	public Page<Produto> buscarProdutos(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Produto> buscarProdutos(final String nome, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
