package musichub.main;
import java.util.Collection;
import musichub.business.Chanson;
import musichub.business.LivreAudio;
import musichub.util.XmlReader;

public class Main {
    public static void main(String[] args) {

        //LinkedList<IJouable> jouablelist = new LinkedList<IJouable> ();
    
        //Chanson chanson1 = new Chanson(1, "Numérologie", 229, "Freeze Corleone", null, Genre.RAP, "11-sept-2020");
        //Playlist playlist1 = new Playlist(1, "Playlist Hiver 2020", jouablelist);
        //playlist1.add(chanson1); 
        try {
            XmlReader reader = new XmlReader();
            Collection<Chanson> chansons = reader.getChansons();
            Collection<LivreAudio> livresaudio = reader.getLivreAudios();

            for (Chanson chanson : chansons) {
                System.out.println(chanson);
            }
            for (LivreAudio livreaudio : livresaudio) {
                System.out.println(livreaudio);
            }

        } catch (Exception e) {
            //TODO: handle exception
        }


    }
}