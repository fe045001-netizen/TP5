package entities;

public class Bibliotheque {
    private Document[] documents;
    private int capacite;
    private int nbDocs;

    public Bibliotheque(int capacite) {
        this.capacite = capacite;
        this.documents = new Document[capacite];
        this.nbDocs = 0;
    }

    public boolean ajouter(Document doc) {
        if (nbDocs < capacite) {
            documents[nbDocs++] = doc;
            return true;
        }
        return false;
    }

    public boolean supprimer(Document doc) {
        for (int i = 0; i < nbDocs; i++) {
            if (documents[i].equals(doc)) {
                documents[i] = documents[nbDocs - 1];
                documents[nbDocs - 1] = null;
                nbDocs--;
                return true;
            }
        }
        return false;
    }

    public Document document(int numEnreg) {
        for (int i = 0; i < nbDocs; i++) {
            if (documents[i].getNumEnreg() == numEnreg)
                return documents[i];
        }
        return null;
    }

    public void afficherDocuments() {
        if (nbDocs == 0) {
            System.out.println("Aucun document dans la bibliothèque.");
            return;
        }
        for (int i = 0; i < nbDocs; i++) {
            System.out.println(documents[i]);
        }
    }

    public void afficherAuteurs() {
        System.out.println("Liste des auteurs :");
        for (int i = 0; i < nbDocs; i++) {
            if (documents[i] instanceof Livre) {
                System.out.println(((Livre) documents[i]).getAuteur());
            }
        }
    }
}
