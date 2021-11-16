package br.com.projetonttdata.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetonttdata.api.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
