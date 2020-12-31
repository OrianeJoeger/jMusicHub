package musichub.main;

import java.util.Scanner;
import musichub.util.XmlReader;

public class Main {

    public static boolean commandsHandlding(String cmd) {
        boolean again = true;

        try {
            XmlReader reader = new XmlReader();

            switch(cmd) {
                case "albums":
                    System.out.println(reader.getAlbums());
                    break;
                case "chansons":
                    System.out.println(reader.getChansons());
                    break;
                case "livres audio":
                    System.out.println(reader.getLivreAudios());
                    break;
                case "playlists":
                    System.out.println(reader.getPlaylists());
                    break;
                case "h":
                    menu();
                    break;
                case "q":
                    again = false;
                    break;
                default:
                    System.out.println("Cette commande n'est pas prise en charge");
                    break;
              }
        } catch (Exception e) {
            System.err.println(e);
        }

        return again;
    }

    public static void menu () {
        System.out.println("\nVoici la liste des commandes possibles : \n");
        System.out.println("--------- AFFICHAGE ---------");
        System.out.println("albums : lister les albums ");
        System.out.println("chansons : lister les chansons ");
        System.out.println("livres audio : lister les livres audio ");
        System.out.println("playlists : lister les playlists ");
        System.out.println("\n--------- AJOUT / SUPPRESSION ---------");
        System.out.println("c : rajout d’une nouvelle chanson ");
        System.out.println("a : rajout d’un nouvel album ");
        System.out.println("+ : rajout d’une chanson existante à un album");
        System.out.println("l : rajout d’un nouveau livre audio");
        System.out.println("p : création d’une nouvelle playlist à partir de chansons et livres audio existants");
        System.out.println("- : suppression d’une playlist");
        System.out.println("s : sauvegarde des playlists, des albums, des chansons et des livres audios dans les fichiers xml respectifs");
        System.out.println("\n--------- AUTRES ---------");
        System.out.println("q : Quitter le programme");
        System.out.println("h : aide avec les détails des commandes");
    }

    public static void main(String[] args)  {
        System.out.println("\nBienvenue dans JMUSICHUB");
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        String cmd = null;

        menu();
        while (again) {
            System.out.print("\nEntrez une commande $> ");
            cmd = sc.nextLine();
            again =  commandsHandlding(cmd);
        }
        sc.close();
        System.out.println("\nMerci d'avoir utilisé nos services.");
        System.out.println("A bientot !\n");
    }
}