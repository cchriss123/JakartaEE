package com.example.jakartazee;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/albums")
public class AlbumController {

    @Inject
    AlbumRepository repository;

    @Inject
    Mapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AlbumDto> getAll(@QueryParam("name") String name) {
        if (name == null)
            return mapper.map(repository.findAll());
        return mapper.map(repository.findAllByName(name));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<AlbumDto> getOne(@PathParam("id") Long id) {
        return repository.findOne(id).map(mapper::map);
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
        return Response.ok().entity(mapper.map(repository.update(id, mapper.map(albumDto)))).build();
    }

}
