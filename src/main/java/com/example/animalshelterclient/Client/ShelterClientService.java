package com.example.animalshelterclient.Client;

import com.example.animalshelterclient.Dtos.ShelterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ShelterClientService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/shelter";

    public List<ShelterDto> getAllShelters() {
        ResponseEntity<List<ShelterDto>> response = restTemplate.exchange(
                baseUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<ShelterDto>>() {});
        return response.getBody();
    }

    public ShelterDto getShelterById(long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, ShelterDto.class);
    }

    public ShelterDto createShelter(ShelterDto shelterDto) {
        return restTemplate.postForObject(baseUrl, shelterDto, ShelterDto.class);
    }

    public void updateShelter(long id, ShelterDto shelterDto) {
        restTemplate.put(baseUrl + "/" + id, shelterDto);
    }

    public void deleteShelter(long id) {
        restTemplate.delete(baseUrl + "/" + id);

}}
