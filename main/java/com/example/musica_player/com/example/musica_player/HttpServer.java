package com.example.musica_player;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class HttpServerWrapper {

    private HttpServer server;

    public HttpServerWrapper(URI baseUri, ResourceConfig config) {
        this.server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
    }

    public void start() {
        this.server.start();
    }

    public void shutdownNow() {
        this.server.shutdownNow();
    }
}
