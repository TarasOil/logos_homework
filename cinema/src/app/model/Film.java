package app.model;

import java.io.Serializable;

public class Film implements Serializable {
    private CustomStringProperty name;
    private CustomStringProperty genre;
    private CustomIntegerProperty year;
    private CustomStringProperty producer;
    private CustomIntegerProperty length;

    public Film(String name, String genre, int year, String producer, int length) {
        this.name = new CustomStringProperty(name);
        this.genre = new CustomStringProperty(genre);
        this.year = new CustomIntegerProperty(year);
        this.producer = new CustomStringProperty(producer);
        this.length = new CustomIntegerProperty(length);
    }

    public String getName() {
        return name.get();
    }

    public CustomStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getGenre() {
        return genre.get();
    }

    public CustomStringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public int getYear() {
        return year.get();
    }

    public CustomIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public String getProducer() {
        return producer.get();
    }

    public CustomStringProperty producerProperty() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer.set(producer);
    }

    public int getLength() {
        return length.get();
    }

    public CustomIntegerProperty lengthProperty() {
        return length;
    }

    public void setLength(int length) {
        this.length.set(length);
    }

    @Override
    public String toString() {
        return name.get();
    }
}
