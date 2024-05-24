package com.example.musica_player;

import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws IOException {
        URI baseUri = URI.create("http://localhost:8080/");
        ResourceConfig config = new ResourceConfig().packages("com.example.musica_player");
        HttpServerWrapper serverWrapper = new HttpServerWrapper(baseUri, config);
        serverWrapper.start();
        System.out.println("Server started at " + baseUri);

        // Keep the server running until terminated manually
        System.in.read();
        serverWrapper.shutdownNow();
    }
}
