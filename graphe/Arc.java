package graphe;

public class Arc {
    private int source;
    private int destination;
    private int poids;

    // Constructeur pour un arc avec une source, une destination et un poids qui sera indiqué lors de
    // l'ajout de l'arc dans le graphe (voir GrapheLArcs.java)
    public Arc(int source, int destination, int poids) {
        this.source = source;
        this.destination = destination;
        this.poids = poids;
    }

    // Constructeur pour un arc avec une source, une destination et un poids qui sera indiqué lors de
    // l'ajout de l'arc dans le graphe (voir GrapheLArcs.java)
    public Arc(String source, String destination, int poids) {
        this.source = Integer.parseInt(source);
        this.destination = Integer.parseInt(destination);
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
    @Override
    public String toString() {
        return "Arc{" +
                "source=" + source +
                ", destination=" + destination +
                ", poids=" + poids +
                '}';
    }

    public Integer getValuation() {
        return poids;
    }
}
