package musichub.util;

import musichub.business.Chanson;
import musichub.business.Genre;
import musichub.business.Langue;
import musichub.business.LivreAudio;
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

    public Collection<Chanson> getChansons() throws Exception {

        String id, titre, duree, artiste, contenu, genre, date;
        LinkedList<Chanson> chansons = new LinkedList<Chanson> ();
        Document doc = this.dBuilder.parse("files/elements.xml");
        NodeList nList = doc.getElementsByTagName("Chanson");

        doc.getDocumentElement().normalize();
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

    public Collection<LivreAudio> getLivreAudios() throws Exception {

        String id, titre, duree, auteur, contenu, langue, categorie;
        LinkedList<LivreAudio> livresaudio = new LinkedList<LivreAudio> ();
        Document doc = this.dBuilder.parse("files/elements.xml");
        NodeList nList = doc.getElementsByTagName("LivreAudio");

        doc.getDocumentElement().normalize();
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


}
