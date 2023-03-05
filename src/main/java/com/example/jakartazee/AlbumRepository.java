package com.example.jakartazee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class AlbumRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void insertAlbum(Album album){
        entityManager.persist(album);
    }

    public List<Album> findAll(){
        var query = entityManager.createQuery("SELECT a FROM Album a");
        return query.getResultList();
    }

    public Optional<Album> findOne(Long id){
        return Optional.ofNullable(entityManager.find(Album.class, id));
    }

    public List<Album> findAllByName(String name) {
        var query = entityManager.createQuery("SELECT a FROM Album a WHERE a.name LIKE :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    public Album update(Long id, Album album){
        var entity = entityManager.find(Album.class, id);
        entity.setName(album.getName());
        entity.setArtist(album.getArtist());
        entity.setPrice(album.getPrice());
        entityManager.persist(entity);
        return entity;
    }

    public void deleteAlbum(Long id){
        var album = findOne(id);
        album.ifPresent((a)-> entityManager.remove(a));

    }
}
