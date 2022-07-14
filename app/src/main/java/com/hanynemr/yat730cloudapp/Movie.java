
package com.hanynemr.yat730cloudapp;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.DataQueryBuilder;

import java.util.Date;
import java.util.List;

public class Movie {
    private Date updated;
    private String ownerId;
    private String objectId;
    private String genre;
    private Date created;
    private String poster;
    private String title;

    public static Movie findById(String id) {
        return Backendless.Data.of(Movie.class).findById(id);
    }

    public static void findByIdAsync(String id, AsyncCallback<Movie> callback) {
        Backendless.Data.of(Movie.class).findById(id, callback);
    }

    public static Movie findFirst() {
        return Backendless.Data.of(Movie.class).findFirst();
    }

    public static void findFirstAsync(AsyncCallback<Movie> callback) {
        Backendless.Data.of(Movie.class).findFirst(callback);
    }

    public static Movie findLast() {
        return Backendless.Data.of(Movie.class).findLast();
    }

    public static void findLastAsync(AsyncCallback<Movie> callback) {
        Backendless.Data.of(Movie.class).findLast(callback);
    }

    public static List<Movie> find(DataQueryBuilder queryBuilder) {
        return Backendless.Data.of(Movie.class).find(queryBuilder);
    }

    public static void findAsync(DataQueryBuilder queryBuilder, AsyncCallback<List<Movie>> callback) {
        Backendless.Data.of(Movie.class).find(queryBuilder, callback);
    }

    public Date getUpdated() {
        return updated;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getCreated() {
        return created;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Movie save() {
        return Backendless.Data.of(Movie.class).save(this);
    }

    public void saveAsync(AsyncCallback<Movie> callback) {
        Backendless.Data.of(Movie.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Movie.class).remove(this);
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Movie.class).remove(this, callback);
    }
}