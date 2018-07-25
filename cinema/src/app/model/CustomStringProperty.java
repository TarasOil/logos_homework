package app.model;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomStringProperty extends SimpleStringProperty implements Serializable {

    public CustomStringProperty(){
        super();
    }

    public CustomStringProperty(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(super.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        super.set(s.readUTF());
    }
}
