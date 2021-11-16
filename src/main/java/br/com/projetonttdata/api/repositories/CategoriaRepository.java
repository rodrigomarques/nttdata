package br.com.projetonttdata.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetonttdata.api.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
