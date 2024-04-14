package graphe;

import java.util.ArrayList;
import java.util.List;

public class GrapheLArcs {
    // Liste des arcs du graphe (voir Arc.java)
    private List<Arc> arcs;
    // Nombre de nœuds du graphe
    private int nombreNoeuds;

    public GrapheLArcs(int nombreNoeuds) {
        // Initialisation de la liste des arcs du graphe et du nombre de nœuds c'est en quelque sorte le constructeur
        this.arcs = new ArrayList<>();
        this.nombreNoeuds = nombreNoeuds;
    }

    public void ajouterArc(int source, int destination, int poids) {
        // Vérification de la validité des nœuds source et destination
        // Condition de validité : 0 < source <= nombreNoeuds et 0 < destination <= nombreNoeuds donc compris entre 1 et nombreNoeuds
        // et ajout de l'arc dans la liste des arcs du graphe
        // sinon lancer une exception
        if (source <= 0 || source > nombreNoeuds || destination <= 0 || destination > nombreNoeuds) {
            throw new IllegalArgumentException("Numéro de nœud non valide");
        }
        arcs.add(new Arc(source, destination, poids));
    }

    public List<Arc> getArcs() {
        // Retourner la liste des arcs du graphe
        return new ArrayList<>(arcs);
    }

    public int getNombreNoeuds() {
        // Retourner le nombre de nœuds du graphe
        return nombreNoeuds;
    }
}
