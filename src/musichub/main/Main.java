package musichub.main;

import java.util.Collection;
import java.util.Scanner;

import musichub.business.Album;
import musichub.business.Chanson;
import musichub.business.LivreAudio;
import musichub.business.Playlist;
import musichub.util.XmlReader;

public class Main {

    Collection<Chanson> chansons;
    Collection<LivreAudio> livresAudio;
    Collection<Album> albums;
    Collection<Playlist> playlists;

    public Main () throws Exception {
        XmlReader reader = new XmlReader();

        this.chansons = reader.getChansons();
        this.livresAudio = reader.getLivresAudio();
        this.albums = reader.getAlbums();
        this.playlists = reader.getPlaylists();
    }

    private boolean commandsHandlding(String cmd) {
        boolean again = true;

        switch(cmd) {
            case "albums":
                System.out.println(this.albums);
                break;
            case "chansons":
                System.out.println(this.chansons);
                break;
            case "livres audio":
                System.out.println(this.livresAudio);
                break;
            case "playlists":
                System.out.println(this.playlists);
                break;
            case "h":
                this.menu();
                break;
            case "q":
                again = false;
                break;
            default:
                System.out.println("Cette commande n'est pas prise en charge");
                this.menu();
                break;
            }

        return again;
    }

    private void menu () {
        System.out.println("\nVoici la liste des commandes possibles : \n");
        System.out.println("--------- AFFICHAGE ---------");
        System.out.println("albums       : lister les albums ");
        System.out.println("chansons     : lister les chansons ");
        System.out.println("livres audio : lister les livres audio ");
        System.out.println("playlists    : lister les playlists ");
        System.out.println("\n--------- AJOUT / SUPPRESSION ---------");
        System.out.println("c   :   Ajouter une nouvelle chanson ");
        System.out.println("a   :   Ajouter un nouvel album ");
        System.out.println("+   :   Ajouter une chanson existante à un album");
        System.out.println("l   :   Ajouter un nouveau livre audio");
        System.out.println("p   :   Créer une nouvelle playlist à partir de chansons et livres audio existants");
        System.out.println("-   :   Supprimer une playlist");
        System.out.println("s   :   Sauvegarder les playlists, albums, hansons et livres audios dans leurs fichiers xml respectifs");
        System.out.println("\n--------- AUTRES ---------");
        System.out.println("h   :   Afficher le détail des commandes");
        System.out.println("q   :   Quitter le programme");
    }

    private void run () {
        Scanner sc = new Scanner(System.in);
        
        boolean again = true;
        String cmd = null;

        this.menu();
        while (again) {
            System.out.print("\nEntrez une commande $> ");
            cmd = sc.nextLine();
            again =  this.commandsHandlding(cmd);
        }
        sc.close();
    } 

    public static void main(String[] args)  {

        System.out.println("\nBienvenue dans JMUSICHUB");

        try {
            Main application = new Main ();
            application.run(); 
        } catch (Exception e) {
            System.err.println(e);
        }
        
        System.out.println("\nMerci d'avoir utilisé nos services.");
        System.out.println("A bientot !\n");
    }
}