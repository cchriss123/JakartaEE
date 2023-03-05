package com.example.jakartazee;

import java.math.BigDecimal;

public class AlbumDto {

    private Long id;
    private String name;
    private String artist;
    private BigDecimal price;

    public AlbumDto() {
    }

    public AlbumDto(Album album) {
        this.id = album.getId();
        this.name = album.getName();
        this.artist = album.getArtist();
        this.price = album.getPrice();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
