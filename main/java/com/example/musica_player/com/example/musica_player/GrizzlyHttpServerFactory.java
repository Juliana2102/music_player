package com.example.musica_player;

import java.net.URI;

public class GrizzlyHttpServerFactory {

    public static HttpServer createHttpServer(URI baseUri, ResourceConfig config) {
        return GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
    }

}
