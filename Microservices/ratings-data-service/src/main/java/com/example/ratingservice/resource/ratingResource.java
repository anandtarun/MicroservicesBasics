package com.example.ratingservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingservice.model.rating;

@RestController
@RequestMapping("/ratingdata")
public class ratingResource {

	@RequestMapping("/{movieId}")
	public rating getRating(@PathVariable("movieId") String movieId) {
		return new rating(movieId, 4);
	}
}
