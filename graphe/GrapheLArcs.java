package graphe;

import graphe.Arc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GrapheLArcs {
    private List<Arc> arcs;
    private int nombreNoeuds;

    public GrapheLArcs(int nombreNoeuds) {
        this.arcs = new ArrayList<>();
        this.nombreNoeuds = nombreNoeuds;
    }

    public void ajouterArc(int source, int destination, int poids) {
        if (source <= 0 || source > nombreNoeuds || destination <= 0 || destination > nombreNoeuds) {
            throw new IllegalArgumentException("Numéro de nœud non valide");
        }
        arcs.add(new Arc(source, destination, poids));
    }

    public List<Arc> getArcs() {
        return new ArrayList<>(arcs);
    }

    public int getNombreNoeuds() {
        return nombreNoeuds;
    }
}
