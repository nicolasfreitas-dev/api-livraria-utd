package com.projeto.livraria.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto.livraria.model.entities.Livro;
import com.projeto.livraria.model.repositories.LivroRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LivroService {

    private LivroRepository livroRepository;

    public Optional<Livro> getLivroById(Long id) {
        return livroRepository.findById(id);
    }

    public List<Livro> getLivros() {
        return livroRepository.findAll();
    }

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro updateLivro(Long id, Livro livro) {

        Livro resposta = getLivroById(id).orElse(null);

        if (resposta != null) {

            if (livro.getTitulo() != null)
                resposta.setTitulo(livro.getTitulo());

            if (livro.getAutor() != null)
                resposta.setAutor(livro.getAutor());

            if (livro.getPreco() != null)
                resposta.setPreco(livro.getPreco());

            return livroRepository.save(resposta);
        }

        return null;
    }

    public Livro deleteLivro(Long id) {
        Livro resposta = getLivroById(id).orElse(null);

        if (resposta != null) {
            livroRepository.delete(resposta);
            return resposta;
        }

        return null;
    }
}
