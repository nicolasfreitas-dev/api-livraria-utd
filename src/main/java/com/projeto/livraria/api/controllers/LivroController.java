package com.projeto.livraria.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.livraria.model.entities.Livro;
import com.projeto.livraria.model.services.LivroService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("livros")
public class LivroController {

    private LivroService livroService;

    @GetMapping("/")
    public ResponseEntity<List<Livro>> getLivros() {

        List<Livro> livros = livroService.getLivros();

        return ResponseEntity.ok().body(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {

        Livro livro = livroService.getLivroById(id).orElse(null);

        return livro != null ? ResponseEntity.ok().body(livro) : ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Livro> saveLivro(@RequestBody Livro livro) {

        return ResponseEntity.ok().body(livroService.saveLivro(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> saveLivro(@PathVariable Long id, @RequestBody Livro livro) {

        Livro resposta = livroService.updateLivro(id, livro);

        return resposta != null ? ResponseEntity.ok().body(resposta) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Livro> deleteLivro(@PathVariable Long id) {

        Livro resposta = livroService.deleteLivro(id);

        return resposta != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
