package musichub.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class Album extends AbstractOeuvre implements Comparable<Album> {

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

    public void addChanson (Chanson chanson) {
        this.chanson.add(chanson);
    }

    public String toString() {
        return "\nAlbum :\n"
            + "     id = " + this.getId() + "\n"
            + "     titre = " + this.getTitre() + "\n"
            + "     duree = " + this.getDuree() + "\n"
            + "     artiste = " + this.getArtiste() + "\n"
            + "     date = " + this.getDate() + "\n"
            + "     chansons = " + this.getChanson() + "\n\n";
    }

    public int compareTo(Album album) {
        int diff = 0;
        Date date1 = null;
        Date date2 = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            date1 = sdf.parse(this.getDate());
        } catch (ParseException e) {
            return 1;
        }

        try {
            date2 = sdf.parse(album.getDate());
        } catch (ParseException e) {
            return -1;
        }

        diff = date2.compareTo(date1);

        return diff;
    }
}
