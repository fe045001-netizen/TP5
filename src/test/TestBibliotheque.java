package test;

import java.util.Scanner;
import entities.*;

public class TestBibliotheque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez la capacité de la bibliothèque : ");
        int n = sc.nextInt();
        sc.nextLine();

        Bibliotheque biblio = new Bibliotheque(n);

        biblio.ajouter(new Roman("Les Yeux De Mona", "Thomas Schlesser", 1925, 300.0));
        biblio.ajouter(new Dictionnaire("Larousse", "Français"));

        int choix;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher tous les documents");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher un document par numéro");
            System.out.println("5. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Type de document à ajouter : ");
                    System.out.println("1. Roman");
                    System.out.println("2. Manuel");
                    System.out.println("3. Revue");
                    System.out.println("4. Dictionnaire");
                    int type = sc.nextInt();
                    sc.nextLine();

                    switch (type) {
                        case 1:
                            System.out.print("Titre : ");
                            String titreR = sc.nextLine();
                            System.out.print("Auteur : ");
                            String auteurR = sc.nextLine();
                            System.out.print("Nombre de pages : ");
                            int pagesR = sc.nextInt();
                            System.out.print("Prix : ");
                            double prix = sc.nextDouble();
                            biblio.ajouter(new Roman(titreR, auteurR, pagesR, prix));
                            break;

                        case 2:
                            System.out.print("Titre : ");
                            String titreM = sc.nextLine();
                            System.out.print("Auteur : ");
                            String auteurM = sc.nextLine();
                            System.out.print("Nombre de pages : ");
                            int pagesM = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Niveau : ");
                            String niveau = sc.nextLine();
                            biblio.ajouter(new Manuel(titreM, auteurM, pagesM, niveau));
                            break;

                        case 3:
                            System.out.print("Titre : ");
                            String titreV = sc.nextLine();
                            System.out.print("Mois : ");
                            String mois = sc.nextLine();
                            System.out.print("Année : ");
                            int annee = sc.nextInt();
                            biblio.ajouter(new Revue(titreV, mois, annee));
                            break;

                        case 4:
                            System.out.print("Titre : ");
                            String titreD = sc.nextLine();
                            System.out.print("Langue : ");
                            String langue = sc.nextLine();
                            biblio.ajouter(new Dictionnaire(titreD, langue));
                            break;

                        default:
                            System.out.println("Type invalide !");
                    }
                    break;

                case 2:
                    biblio.afficherDocuments();
                    break;

                case 3:
                    System.out.print("Numéro du document à supprimer : ");
                    int numS = sc.nextInt();
                    Document docS = biblio.document(numS);
                    if (docS != null && biblio.supprimer(docS))
                        System.out.println("Document supprimé !");
                    else
                        System.out.println("Document introuvable !");
                    break;

                case 4:
                    System.out.print("Numéro d'enregistrement : ");
                    int numR = sc.nextInt();
                    Document docR = biblio.document(numR);
                    if (docR != null)
                        System.out.println(docR);
                    else
                        System.out.println("Aucun document trouvé !");
                    break;

                case 5:
                    biblio.afficherAuteurs();
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 0);

        sc.close();
    }
}
