package com.projeto.livraria.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.livraria.model.entities.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
