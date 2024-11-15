package com.example.animalshelterclient.Client;

import com.example.animalshelterclient.Dtos.AnimalsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalsClientService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/shelter";

    public List<AnimalsDto> getAllAnimals() {
        ResponseEntity<List<AnimalsDto>> response = restTemplate.exchange(
                baseUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<AnimalsDto>>() {});
        return response.getBody();
    }

    public AnimalsDto getAnimalById(long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, AnimalsDto.class);
    }

    public AnimalsDto createAnimal(AnimalsDto animalsDto) {
        return restTemplate.postForObject(baseUrl, animalsDto, AnimalsDto.class);
    }

    public void updateAnimal(long id, AnimalsDto animalsDto) {
        restTemplate.put(baseUrl + "/" + id, animalsDto);
    }

    public void deleteAnimal(long id) {
        restTemplate.delete(baseUrl + "/" + id);
    }
}