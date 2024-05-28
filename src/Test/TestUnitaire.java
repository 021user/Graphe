package Test;

import addon.IGraphe;

public class TestUnitaire {
    public static void Test(IGraphe A) {

        A.ajouterSommet("A");
        A.ajouterSommet("B");
        A.ajouterSommet("C");
        A.ajouterSommet("D");
        A.ajouterSommet("A");
        assert(A.contientSommet("C"));
        System.out.println(A.getSommets());
        assert(!A.contientArc("A","B"));
        assert(A.getValuation("A","B") == -1);
        A.ajouterArc("A","B",3);
        assert(A.contientArc("A","B"));
        assert(A.getValuation("A","B") == 3);
        System.out.println("Taille du volume : "+A.getValuation("Z","A"));
        //A.ajouterArc("A","B",3);
        A.ajouterArc("E","F",5);
        System.out.println(A.getSommets());
        assert(A.contientArc("E","F"));
        assert(A.getValuation("E","F") == 5);
        A.ajouterArc("E","C",5);
        A.ajouterArc("E","A",5);
        System.out.println(A.getSucc("E"));
        //A.oterArc("E","B");
        A.oterArc("E","A");
        assert(!A.contientArc("E","A"));
        assert(A.getValuation("E","A") == -1);
        System.out.println(A.getSucc("E"));
        A.ajouterArc("A","E",4);
        A.ajouterArc("D","E",7);
        System.out.println(A.getSucc("E"));
        A.oterSommet("E");
        System.out.println(A.getSommets());
        assert(!A.contientArc("A","E"));
        assert(!A.contientArc("D","E"));
        A.ajouterArc("I","A",8);
        A.ajouterArc("I","D",7);
        System.out.println(A.getSommets());
        System.out.println(A.getSucc("I"));
        A.oterSommet("I");
        System.out.println(A.getSommets());
    }
}