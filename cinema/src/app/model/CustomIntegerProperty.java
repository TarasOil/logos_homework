package app.model;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomIntegerProperty extends SimpleIntegerProperty implements Serializable {

    public CustomIntegerProperty(){
        super();
    }

    public CustomIntegerProperty(int n){
        super(n);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(super.intValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        super.set(s.readInt());
    }
}
