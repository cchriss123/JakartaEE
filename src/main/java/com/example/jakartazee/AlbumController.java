package com.example.jakartazee;

import com.example.jakartazee.exception.IdNotFoundException;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/albums")
public class AlbumController {

    @Inject
    AlbumRepository repository;

    @Inject
    Mapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AlbumDto> getAll(@QueryParam("name") String name) {
        return name == null ? mapper.map(repository.findAll()) : mapper.map(repository.findAllByName(name));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AlbumDto getOne(@PathParam("id") Long id) {
        var album = repository.findOne(id).map(mapper::map);
        return album.orElseThrow(() -> new IdNotFoundException("Not found ID: " + id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOne(@Valid AlbumDto albumDto) {
        var album = mapper.map(albumDto);
        repository.insertAlbum(album);
        return Response.created(URI.create("albums/" + album.getId())).build();
    }

    @DELETE
    @Path("/{id}")
    public void deleteOne(@PathParam("id") Long id) {
        repository.deleteAlbum(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, AlbumDto albumDto) {
        var updatedAlbum = repository.findOne(id)
                .map(a -> repository.update(id, albumDto))
                .orElseThrow(() -> new IdNotFoundException("Not found ID: " + id));
        return Response.ok().entity(mapper.map(updatedAlbum)).build();
    }
}
