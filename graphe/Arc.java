package graphe;

public class Arc {
    private String source;
    private String destination;
    private Integer poids;

    // Constructeur pour un arc avec une source, une destination et un poids qui sera indiqué lors de
    // l'ajout de l'arc dans le graphe (voir GrapheLArcs.java)
    public Arc(String source, String destination, Integer poids) {
        this.source = source;
        this.destination = destination;
        this.poids = poids;
    }

    // Getter pour la source de l'arc
    public String getSource() {
        return String.valueOf(source);
    }

    // Getter pour la destination de l'arc
    public String getDestination() {
        return String.valueOf(destination);
    }

    // Getter pour le poids de l'arc
    public int getPoids() {
        return poids;
    }

    // Override pour pouvoir comparer les arcs dans les tests unitaires
    public int getValuation() {
        return poids;
    }
}
