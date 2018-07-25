package app.model;

import java.io.Serializable;

public class Session implements Serializable {
    private Film film;
    private Hall hall;
    private CustomDate date;

    public Session(Film film, Hall hall, CustomDate date) {
        this.film = film;
        this.hall = hall;
        this.date = date;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public CustomDate getDate() {
        return date;
    }

    public void setDate(CustomDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Session{" +
                "film=" + film +
                ", hall=" + hall +
                ", date=" + date +
                '}';
    }
}
