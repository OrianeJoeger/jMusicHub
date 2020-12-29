package musichub.main;

import java.util.Collection;

import musichub.business.Album;
import musichub.business.Chanson;
import musichub.business.IJouable;
import musichub.business.LivreAudio;
import musichub.business.Playlist;
import musichub.util.XmlReader;

public class Main {
    public static void main(String[] args) {

        try {
            XmlReader reader = new XmlReader();
            // Collection<Chanson> chansons = reader.getChansons();
            // Collection<LivreAudio> livresaudio = reader.getLivreAudios();
            Collection<Album> albums = reader.getAlbums();
            // Collection<Playlist> playlists = reader.getPlaylist();

            // for (IJouable chanson : chansons) {
            //     System.out.println(chanson);
            // }

            // for (IJouable livreaudio : livresaudio) {
            //     System.out.println(livreaudio);
            // }

            for (Album album : albums) {
                System.out.println(album);
            }

            // for (Playlist playlist : playlists) {
            //     System.out.println(playlist);
            // }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}