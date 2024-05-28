package graphe;
import Test.TestUnitaire;

public class Main {
    public static void main(String[] args) {
        Graphe g1 = new GrapheLAdj();
        Graphe g2 = new GrapheLArcs();
        Graphe g3 = new GrapheMAdj();

        // Pour tester GrapheLAdj
        // TestUnitaire.Test(g1);

        // Pour tester GrapheLArcs
        // TestUnitaire.Test(g2);

        // Pour tester GrapheMAdj
        // TestUnitaire.Test(g3);
    }

}
