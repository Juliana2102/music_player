package com.example.musica_player;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class HttpServerWrapper {

    private HttpServerWrapper server;

    public HttpServerWrapper(URI baseUri, ResourceConfig config) {
        this.server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
    }

    public void start() {
        try {
            this.server.start();
            System.out.println("Server started at " + server.getListener("grizzly").getHost() + ":"
                    + server.getListener("grizzly").getPort());
        } catch (Exception e) {
            System.err.println("There was an error starting the server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void shutdownNow() {
        this.server.shutdownNow();
    }
}
