package musichub.main;

import java.util.List;
import java.util.Scanner;

import musichub.business.Album;
import musichub.business.Categorie;
import musichub.business.Chanson;
import musichub.business.Genre;
import musichub.business.Langue;
import musichub.business.LivreAudio;
import musichub.business.Playlist;
import musichub.util.XmlReader;
import musichub.util.XmlWriter;

public class Main {

    List<Chanson> chansons;
    List<LivreAudio> livresAudio;
    List<Album> albums;
    List<Playlist> playlists;

    public Main () throws Exception {
        XmlReader reader = new XmlReader();

        this.chansons = reader.getChansons();
        this.livresAudio = reader.getLivresAudio();
        this.albums = reader.getAlbums();
        this.playlists = reader.getPlaylists();
    }

    private Chanson newChanson(Scanner sc) {
        System.out.print("\nEntrez un id (integer) $> ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un titre (string) $> ");
        String titre = sc.nextLine();
        System.out.print("Entrez une durée (secondes) $> ");
        int duree = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un artiste (string) $> ");
        String artiste = sc.nextLine();
        System.out.print("Entrez un contenu (string) $> ");
        String contenu = sc.nextLine();
        System.out.print("Entrez un genre (JAZZ, CLASSIQUE, HIPHOP, ROCK, POP, RAP) $> ");
        Genre genre = Genre.valueOf(sc.nextLine());
        System.out.print("Entrez une date (aaaa-mm-jj) $> ");
        String date = sc.nextLine();
        System.out.println();

        Chanson chanson = new Chanson(id, titre, duree, artiste, contenu, genre, date);

        return chanson;
    }

    private LivreAudio newLivreAudio(Scanner sc) {
        System.out.print("\nEntrez un id (integer) $> ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un titre (string) $> ");
        String titre = sc.nextLine();
        System.out.print("Entrez une durée (secondes) $> ");
        int duree = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un auteur (string) $> ");
        String auteur = sc.nextLine();
        System.out.print("Entrez un contenu (string) $> ");
        String contenu = sc.nextLine();
        System.out.print("Entrez une langue (FRANCAIS, ANGLAIS, ITALIEN, ESPAGNOL, ALLEMAND) $> ");
        Langue langue = Langue.valueOf(sc.nextLine());
        System.out.print("Entrez une categorie (JEUNESSE, ROMAN, THEATRE, DISCOURS, DOCUMENTAIRE) $> ");
        Categorie categorie = Categorie.valueOf(sc.nextLine());
        System.out.println();

        LivreAudio livreAudio = new LivreAudio(id, titre, duree, auteur, contenu, langue, categorie);

        return livreAudio;
    }

    private void removePlaylist(Scanner sc) {
        System.out.print("\nQuelle playlist souhaitez-vous supprimer (id) ? $> ");
        int id = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < playlists.size(); i++) {
            if (this.playlists.get(i).getId() == id) {
                  this.playlists.remove(i);  
            }
        }
    }

    private boolean commandsHandlding(String cmd, Scanner sc) throws Exception {
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
            case "c":
                System.out.println("\nAjout d'une nouvelle chanson :");
                Chanson chanson = this.newChanson(sc);
                this.chansons.add(chanson);
                System.out.println(chanson);
                System.out.println("La chanson a bien été ajoutée.");
                break;
            case "a":
                // TODO :  rajout d’un nouvel album
                break;
            case "+":
                // TODO :   rajout d’une chanson existante à un album
                break;
            case "l":
                System.out.println("\nAjout d'un nouveau livre audio :");
                LivreAudio livreAudio = this.newLivreAudio(sc);
                this.livresAudio.add(livreAudio);
                System.out.println(livreAudio);
                System.out.println("Le livre audio a bien été ajouté.");
                break;
            case "p":
                // TODO : création d’une nouvelle playlist à partir de chansons et livres audio existants

                break;
            case "-":
                System.out.println("\nVoici vos playlists actuelles :");
                System.out.println(this.playlists);
                this.removePlaylist(sc);
                System.out.println("\nLa playlist a bien été supprimée.");
                
                break;
            case "s":
                XmlWriter writer = new XmlWriter();
                writer.save(this.chansons, this.livresAudio, this.albums, this.playlists);
                System.out.println("Les fichiers XML ont été mis à jour.");
                break;
            case "h": 
                this.menu();
                break;
            case "q": 
                again = false;
                break;
            default:
                System.out.println("\nCette commande n'est pas prise en charge");
                this.menu();
                break;
            }

        return again;
    }

    private void menu () {
        System.out.println("\nVoici la liste des commandes disponibles : \n");
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

    private void run () throws Exception {
        Scanner sc = new Scanner(System.in);
        
        boolean again = true;
        String cmd = null;

        this.menu();
        while (again) {
            System.out.print("\nEntrez une commande $> ");
            cmd = sc.nextLine();
            again =  this.commandsHandlding(cmd, sc);
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