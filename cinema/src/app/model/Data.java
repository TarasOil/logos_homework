package app.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public final class Data {

    public static ObservableList<Film> filmList = FXCollections.observableList(new ArrayList<>());
    public static ObservableList<Hall> hallList = FXCollections.observableList(new ArrayList<>());
    public static ObservableList<Session> sessionList = FXCollections.observableList(new ArrayList<>());

    private Data() {
    }

    public static void writeFile() throws Exception {
        FileOutputStream fos = new FileOutputStream("film.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Film film : filmList) {
            oos.writeObject(film);
        }
        fos = new FileOutputStream("hall.out");
        oos = new ObjectOutputStream(fos);
        for (Hall hall : hallList) {
            oos.writeObject(hall);
        }
        fos = new FileOutputStream("session.out");
        oos = new ObjectOutputStream(fos);
        for (Session session : sessionList) {
            oos.writeObject(session);
        }
        oos.close();
        fos.close();
    }

    //fix this
    public static void readFile() throws Exception {
        File f = new File("film.out");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(f.exists()) {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            try {
                Film film;
                while ((film = (Film) ois.readObject()) != null) {
                    Data.filmList.add(film);
                }
            } catch (EOFException e) {

            } finally {
                ois.close();
                fis.close();
            }
        }

        f = new File("hall.out");

        if(f.exists()) {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            try {
                Hall hall;
                while ((hall = (Hall) ois.readObject()) != null) {
                    Data.hallList.add(hall);
                }
            } catch (EOFException e) {

            } finally {
                ois.close();
                fis.close();
            }
        }

        f = new File("session.out");

        if(f.exists()) {
            fis = new FileInputStream("session.out");
            ois = new ObjectInputStream(fis);

            try {
                Session session;
                while ((session = (Session) ois.readObject()) != null) {
                    Data.sessionList.add(session);
                }
            } catch (EOFException e) {

            } finally {
                ois.close();
                fis.close();
            }
        }
    }

}
