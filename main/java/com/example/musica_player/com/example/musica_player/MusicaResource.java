package com.example.musica_player;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/musicas")
public class MusicaResource {

    private static List<Musica> musicas = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Musica> getAllMusicas() {
        return musicas;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Musica getMusicaById(@PathParam("id") Long id) {
        return musicas.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createMusica(Musica musica) {
        musicas.add(musica);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateMusica(@PathParam("id") Long id, Musica musica) {
        Musica existingMusica = getMusicaById(id);
        if (existingMusica != null) {
            existingMusica.setTitulo(musica.getTitulo());
            existingMusica.setArtista(musica.getArtista());
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteMusica(@PathParam("id") Long id) {
        musicas = musicas.stream().filter(m -> !m.getId().equals(id)).collect(Collectors.toList());
    }
}
