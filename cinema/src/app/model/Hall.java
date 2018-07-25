package app.model;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class Hall implements Serializable {
    private CustomIntegerProperty id;
    private CustomIntegerProperty capacity;

    public Hall(int id, int capacity) {
        this.id = new CustomIntegerProperty(id);
        this.capacity = new CustomIntegerProperty(capacity);
    }

    public int getId() {
        return id.get();
    }

    public CustomIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getCapacity() {
        return capacity.get();
    }

    public CustomIntegerProperty capacityProperty() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity.set(capacity);
    }

    @Override
    public String toString() {
        return String.valueOf(id.get());
    }
}
