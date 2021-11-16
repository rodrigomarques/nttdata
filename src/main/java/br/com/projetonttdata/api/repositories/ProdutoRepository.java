package br.com.projetonttdata.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projetonttdata.api.entity.Produto;

@Repository
@Transactional(readOnly = true)
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> buscarNome(@Param("pnome") String nome);
	Page<Produto> buscarNome(@Param("pnome") String nome, Pageable pageable);
	
}
