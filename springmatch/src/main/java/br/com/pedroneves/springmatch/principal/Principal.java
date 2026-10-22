package br.com.pedroneves.springmatch.principal;

import br.com.pedroneves.springmatch.model.DadosEpisodio;
import br.com.pedroneves.springmatch.model.DadosSerie;
import br.com.pedroneves.springmatch.model.DadosTemporada;
import br.com.pedroneves.springmatch.service.ConsumoApi;
import br.com.pedroneves.springmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=c981e94d";

    public void exibeMenu() {
        System.out.println("Digite o nome da série para busca: ");
        var nomeSerie = sc.nextLine();
        var json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
			DadosTemporada dadosTemp = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemp);
		}
		temporadas.forEach(System.out::println);

        for (int i = 0; i < dados.totalTemporadas(); i++) {
            List<DadosEpisodio> epsTemp = temporadas.get(i).episodios();
            for (int j = 0; j < epsTemp.size(); j++) {
                System.out.println(epsTemp.get(j).titulo());
            }
        }
    }
}
