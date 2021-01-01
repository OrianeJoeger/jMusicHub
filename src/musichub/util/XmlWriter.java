package musichub.util;

import java.util.Collection;

import musichub.business.Album;
import musichub.business.Chanson;
import musichub.business.LivreAudio;
import musichub.business.Playlist;

public class XmlWriter {

    public XmlWriter() {
        //TODO: constructeur
    }

    private void saveElements(Collection<Chanson> chansons, Collection<LivreAudio> livresaudios) {
        //TODO: a des chansons et livresaudio dans le fichier elements.xml
    }

    private void saveAlbums(Collection<Album> albums) {
        //TODO: sauvegarde des albums dans le fichier albums.xml
    }

    private void savePlaylists(Collection<Playlist> playlists) {
        //TODO: sauvegarde des playlists dans le fichier playlists.xml
    }

    public void save (Collection<Chanson> chansons, Collection<LivreAudio> livresaudios, Collection<Album> albums, Collection<Playlist> playlists) {
        this.saveElements(chansons, livresaudios);
        this.saveAlbums(albums);
        this.savePlaylists(playlists);
    }
}
