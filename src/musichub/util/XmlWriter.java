package musichub.util;

import musichub.business.Album;
import musichub.business.Chanson;
import musichub.business.LivreAudio;
import musichub.business.Playlist;

public class XmlWriter {

    public XmlWriter() {
        //TODO: constructeur
    }

    private void saveElements(Chanson chansons, LivreAudio livresaudio) {
        //TODO: a des chansons et livresaudio dans le fichier elements.xml
    }

    private void saveAlbums(Album albums) {
        //TODO: sauvegarde des albums dans le fichier albums.xml
    }

    private void savePlaylists(Playlist playlists) {
        //TODO: sauvegarde des playlists dans le fichier playlists.xml
    }

    public void save (Chanson chanson, LivreAudio livresaudio, Album albums, Playlist playlists) {
        this.saveElements(chanson, livresaudio);
        this.saveAlbums(albums);
        this.savePlaylists(playlists);
    }
}
