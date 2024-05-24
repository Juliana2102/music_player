package com.example.musica_player;

import com.example.musica_player.ResourceConfig;

public class ResourceConfig extends org.glassfish.jersey.server.ResourceConfig {

    public ResourceConfig packages(String packageName) {
        super.packages(packageName);
        return this;
    }
}
