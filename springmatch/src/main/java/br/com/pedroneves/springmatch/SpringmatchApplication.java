package br.com.pedroneves.springmatch;

import br.com.pedroneves.springmatch.model.DadosSerie;
import br.com.pedroneves.springmatch.service.ConsumoApi;
import br.com.pedroneves.springmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=c981e94d");

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

		System.out.println(dados);
	}
}
