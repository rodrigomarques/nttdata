package br.com.projetonttdata.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.projetonttdata.api.dto.ProdutoDTO;
import br.com.projetonttdata.api.entity.Produto;

public interface ProdutoService {
	
	Produto save(final Produto produto)throws Exception;
	Produto upate(final Long id, final Produto produto)throws Exception;
	Produto desativar(final Long id)throws Exception;
	void deletar(final Long id)throws Exception;
	Page<ProdutoDTO> buscarProdutos(PageRequest pageRequest);
	Page<ProdutoDTO> buscarProdutos(final String nome, PageRequest pageRequest);
}
