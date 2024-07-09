package com.literatura.literalura.client;

import com.literatura.literalura.model.GutendexResponse;
import com.literatura.literalura.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GutendexClient {

    @Autowired
    private RestTemplate restTemplate;

    public Libro buscarLibroPorTitulo(String titulo) {
        String url = "https://gutendex.com/books?search=" + titulo;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        if (response != null && !response.getResults().isEmpty()) {
            return response.getResults().get(0);
        }
        return null;
    }
}
