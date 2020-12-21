package musichub.main;
import java.util.LinkedList;
import musichub.business.Chanson;
import musichub.business.Genre;
import musichub.business.Playlist;
import musichub.business.IJouable;

public class Main {
    public static void main(String[] args) {

    LinkedList<IJouable> jouablelist = new LinkedList<IJouable> ();
   
    Chanson chanson1 = new Chanson(1, "Numérologie", 229, "Freeze Corleone", null, Genre.RAP, "11-sept-2020");
    Playlist playlist1 = new Playlist(1, "Playlist Hiver 2020", jouablelist);
    playlist1.add(chanson1);    
    }
}