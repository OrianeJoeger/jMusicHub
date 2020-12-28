package musichub.business;

import java.util.Collection;

public class Album extends AbstractOeuvre {

    private Collection<IJouable> chanson;
    private String artiste;
    private String date;

    public Album (int id, String titre, int duree, Collection<IJouable> chanson, String artiste, String date) {
        super(id, titre, duree);
        this.chanson = chanson;
        this.artiste = artiste;
        this.date = date;
    }

    public Collection<IJouable> getChanson () {
        return chanson;
    }

    public void setChanson (Collection<IJouable> chanson) {
        this.chanson = chanson;
    }

    public String getArtiste () {
        return artiste;
    }

    public void setArtiste (String artiste) {
        this.artiste = artiste;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String toString() {
        return "---------\n"
            + "Album :\n"
            + "id = " + this.getId() + "\n"
            + "titre = " + this.getTitre() + "\n"
            + "duree = " + this.getDuree() + "\n"
            + "artiste = " + this.getArtiste() + "\n"
            + "date = " + this.getDate() + "\n"
            + "chansons = " + this.getChanson();
    }
}
