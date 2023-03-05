package com.example.jakartazee;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class Mapper {

    public List<AlbumDto> map(List<Album> all) {
        return all.stream().map(AlbumDto::new).toList();
    }

    public Album map(AlbumDto albumDto) {
        var album = new Album();
        album.setId(albumDto.getId());
        album.setName(albumDto.getName());
        album.setArtist(albumDto.getArtist());
        album.setPrice(albumDto.getPrice());
        return album;
    }

    public AlbumDto map(Album album) {
        return new AlbumDto(album);
    }
}
