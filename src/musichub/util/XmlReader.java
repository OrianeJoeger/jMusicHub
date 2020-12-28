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
import java.util.LinkedList;


public class XmlReader {

    DocumentBuilder dBuilder;

    public XmlReader() throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        this.dBuilder = dbFactory.newDocumentBuilder();
    }

    private Collection<IJouable> extractChanson(NodeList nList) {

        String id, titre, duree, artiste, contenu, genre, date;
        Collection<IJouable> chansons = new LinkedList<IJouable> ();

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

        return chansons;
    }

    private Collection<IJouable> extractLivreAudio(NodeList nList) {

        String id, titre, duree, auteur, contenu, langue, categorie;
        Collection<IJouable> livresaudio = new LinkedList<IJouable> ();

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

        return livresaudio;
    }

    public Collection<IJouable> getChansons() throws Exception {

        Collection<IJouable> chansons = null;
        Document doc = this.dBuilder.parse("files/elements.xml");
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("Chanson");        
        chansons = this.extractChanson(nList);

        return chansons;
    }

    public Collection<IJouable> getLivreAudios() throws Exception {

        Collection<IJouable> livresaudio = null;
        Document doc = this.dBuilder.parse("files/elements.xml");
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("LivreAudio");
        livresaudio = this.extractLivreAudio(nList);
        
        return livresaudio;
    }

    public Collection<Album> getAlbums() throws Exception {

        String id, titre, duree, artiste, date;
        Collection<IJouable> chansons;
        Collection<Album> albums = new LinkedList<Album> ();
        
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

        return albums;
    }

    public Collection<Playlist> getPlaylist() throws Exception {

        String id, titre;
        Collection<IJouable> elements = null;
        Collection<Playlist> playlists = new LinkedList<Playlist> ();
        
        Document doc = this.dBuilder.parse("files/playlists.xml");
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("Playlist");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;

            id = eElement.getElementsByTagName("id").item(0).getTextContent();
            titre = eElement.getElementsByTagName("titre").item(0).getTextContent();
            elements = this.extractChanson(eElement.getElementsByTagName("Chanson"));
            elements.addAll(this.extractLivreAudio(eElement.getElementsByTagName("LivreAudio")));
            // System.out.println(elements);
            // System.out.println("---------------");

            Playlist playlist = new Playlist(
                Integer.parseInt(id),
                titre,
                elements
            );
            playlists.add(playlist);
        }

        return playlists;
    }
}
