package musichub.business;

import java.util.Collection;

public class Album extends AbstractOeuvre {

    private Collection<Chanson> chanson;
    private String artiste;
    private String date;

    public Album (int id, String titre, int duree, Collection<Chanson> chanson, String artiste, String date) {
        super(id, titre, duree);
        this.chanson = chanson;
        this.artiste = artiste;
        this.date = date;
    }

    public Collection<Chanson> getChanson () {
        return chanson;
    }

    public void setChanson (Collection<Chanson> chanson) {
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
}
