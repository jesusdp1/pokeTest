package com.pokeTest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pokeTest.model.Pokemon;
import com.pokeTest.model.EvolutionChain;
import com.pokeTest.model.EvolvesTo;
import com.pokeTest.model.PokemonForm;
import com.pokeTest.model.PokemonSpecies;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/pokeTest")
public class PokeTestController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "/get/{value}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> get(@PathVariable String value) {
		List<String> listEvolution = new ArrayList<String>();
		String url = "https://pokeapi.co/api/v2/pokemon/" + value;
		String urlForms = "https://pokeapi.co/api/v2/pokemon-form/" + value;

		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("user-agent", "Application");
			HttpEntity<String> entity = new HttpEntity<>(headers);
			Pokemon pokemon = restTemplate.exchange(url, HttpMethod.GET, entity, Pokemon.class).getBody();
			PokemonForm form = restTemplate.exchange(urlForms, HttpMethod.GET, entity, PokemonForm.class).getBody();

			String urlEvolution = "https://pokeapi.co/api/v2/evolution-chain/" + pokemon.getId();
			String urlDescription = "https://pokeapi.co/api/v2/pokemon-species/" + pokemon.getId();

			EvolutionChain evolutions = restTemplate
					.exchange(urlEvolution, HttpMethod.GET, entity, EvolutionChain.class).getBody();
			PokemonSpecies description = restTemplate
					.exchange(urlDescription, HttpMethod.GET, entity, PokemonSpecies.class).getBody();
			for (EvolvesTo evolvesTo : evolutions.getChain().getEvolves_to()) {
				if (!evolvesTo.getEvolves_to().isEmpty()) {
					for (EvolvesTo evolvesTo2 : evolvesTo.getEvolves_to()) {
						listEvolution.add(evolvesTo2.getSpecies().getName());
					}
					listEvolution.add(evolvesTo.getSpecies().getName());

				}
			}
			pokemon.setEvolutions(listEvolution);
			pokemon.setDescription(description.getFlavor_text_entries().iterator().next().getFlavor_text());
			pokemon.setImage(form);
			return new ResponseEntity<>(pokemon, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(new Pokemon("Pokemon Not Found"), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
}
