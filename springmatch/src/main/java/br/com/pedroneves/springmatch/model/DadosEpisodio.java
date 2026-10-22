package br.com.pedroneves.springmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String titulo,@JsonAlias("Episode") Integer numeroEp,@JsonAlias("imdbRating") String avaliacaoEp,@JsonAlias("Released") String dataLancamentoEp) {
}
