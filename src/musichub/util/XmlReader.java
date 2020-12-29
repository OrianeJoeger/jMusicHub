package musichub.util;

import musichub.business.Chanson;
import musichub.business.Genre;
import musichub.business.IJouable;
import musichub.business.Langue;
import musichub.business.LivreAudio;
import musichub.business.Playlist;
import musichub.business.Album;
import musichub.business.Categorie;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class XmlReader {

    DocumentBuilder dBuilder;

    public XmlReader() throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        this.dBuilder = dbFactory.newDocumentBuilder();
    }

    private List<Chanson> extractChanson(NodeList nList) {

        String id, titre, duree, artiste, contenu, genre, date;
        List<Chanson> chansons = new LinkedList<Chanson> ();

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;

            id = eElement.getElementsByTagName("id").item(0).getTextContent();
            titre = eElement.getElementsByTagName("titre").item(0).getTextContent();
            duree = eElement.getElementsByTagName("duree").item(0).getTextContent();
            artiste = eElement.getElementsByTagName("artiste").item(0).getTextContent();
            contenu = eElement.getElementsByTagName("contenu").item(0).getTextContent();
            genre = eElement.getElementsByTagName("genre").item(0).getTextContent();
            date = eElement.getElementsByTagName("date").item(0).getTextContent();

            Chanson chanson = new Chanson(
                Integer.parseInt(id),
                titre,
                Integer.parseInt(duree),
                artiste,
                contenu,
                Genre.valueOf(genre),
                date
            );
            chansons.add(chanson);
        }
        Collections.sort(chansons);

        return chansons;
    }

    private List<LivreAudio> extractLivreAudio(NodeList nList) {

        String id, titre, duree, auteur, contenu, langue, categorie;
        List<LivreAudio> livresaudio = new LinkedList<LivreAudio> ();

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;

            id = eElement.getElementsByTagName("id").item(0).getTextContent();
            titre = eElement.getElementsByTagName("titre").item(0).getTextContent();
            duree = eElement.getElementsByTagName("duree").item(0).getTextContent();
            auteur = eElement.getElementsByTagName("auteur").item(0).getTextContent();
            contenu = eElement.getElementsByTagName("contenu").item(0).getTextContent();
            langue = eElement.getElementsByTagName("langue").item(0).getTextContent();
            categorie = eElement.getElementsByTagName("categorie").item(0).getTextContent();

            LivreAudio livreaudio = new LivreAudio(
                Integer.parseInt(id),
                titre,
                Integer.parseInt(duree),
                auteur,
                contenu,
                Langue.valueOf(langue),
                Categorie.valueOf(categorie)
            );
            livresaudio.add(livreaudio);
        }
        Collections.sort(livresaudio);

        return livresaudio;
    }

    public Collection<Chanson> getChansons() throws Exception {

        List<Chanson> chansons = null;

        Document doc = this.dBuilder.parse("files/elements.xml");
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("Chanson");        
        chansons = this.extractChanson(nList);

        return chansons;
    }

    public Collection<LivreAudio> getLivreAudios() throws Exception {

        Collection<LivreAudio> livresaudio = null;
        Document doc = this.dBuilder.parse("files/elements.xml");
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("LivreAudio");
        livresaudio = this.extractLivreAudio(nList);
        
        return livresaudio;
    }

    public Collection<Album> getAlbums() throws Exception {

        String id, titre, duree, artiste, date;
        List<Chanson> chansons;
        List<Album> albums = new LinkedList<Album> ();
        
        Document doc = this.dBuilder.parse("files/albums.xml");
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Album");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;

            id = eElement.getElementsByTagName("id").item(0).getTextContent();
            titre = eElement.getElementsByTagName("titre").item(0).getTextContent();
            duree = eElement.getElementsByTagName("duree").item(0).getTextContent();
            artiste = eElement.getElementsByTagName("artiste").item(0).getTextContent();
            date = eElement.getElementsByTagName("date").item(0).getTextContent();
            chansons = this.extractChanson(eElement.getElementsByTagName("Chanson"));

            Album album = new Album(
                Integer.parseInt(id),
                titre,
                Integer.parseInt(duree),
                chansons,
                artiste,
                date
            );
            albums.add(album);
        }
        Collections.sort(albums);

        return albums;
    }

    public Collection<Playlist> getPlaylist() throws Exception {

        String id, titre;
        List<Chanson> chansons = null;
        List<LivreAudio> livresaudio = null;
        Collection<IJouable> elements = new LinkedList<IJouable> ();
        List<Playlist> playlists = new LinkedList<Playlist> ();
        
        Document doc = this.dBuilder.parse("files/playlists.xml");
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Playlist");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;

            id = eElement.getElementsByTagName("id").item(0).getTextContent();
            titre = eElement.getElementsByTagName("nom").item(0).getTextContent();
            chansons = this.extractChanson(eElement.getElementsByTagName("Chanson"));
            livresaudio = this.extractLivreAudio(eElement.getElementsByTagName("LivreAudio"));
            elements.addAll(chansons);
            elements.addAll(livresaudio);

            Playlist playlist = new Playlist(
                Integer.parseInt(id),
                titre,
                elements
            );
            playlists.add(playlist);
        }
        Collections.sort(playlists);

        return playlists;
    }
}
