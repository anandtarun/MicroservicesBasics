package com.example.movies.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.movies.model.CatalogItem;
import com.example.movies.model.Movie;
import com.example.movies.model.rating;

@RestController
@RequestMapping("/catalog")
public class movieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	Movie movie;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		List<rating> ratings = Arrays.asList(new rating("foo", 4), new rating("mad", 5));

		return ratings.stream().map(rating -> {

			restTemplate.getForObject("http://localhost:8082/movies/foo/" + rating.getMovieId(), Movie.class);
			new CatalogItem(movie.getName(), "TestName", rating.getRating());
		}).collect(Collectors.toList());

		return Collections.singletonList(new CatalogItem("Transformers", "Test", 4));
	}
}
//new CatalogItem(movie.getName(), "TestName", rating.getRating())