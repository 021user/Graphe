package graphe;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.List;

public class GrapheLArcs extends Graphe {
    // Liste des arcs du graphe (voir Arc.java)
    private ArrayList<String> Sommets;//Liste des sommets
    private ArrayList<Arc> arcs;
    // Nombre de nœuds du graphe
    private int nombreNoeuds;

    public GrapheLArcs() {
        // Initialisation de la liste des arcs du graphe et du nombre de nœuds c'est en quelque sorte le constructeur
        this.arcs = new ArrayList<>();
        this.nombreNoeuds = 0;
        this.Sommets = new ArrayList<>();
    }

    @Override
    public boolean contientSommet(String sommet){//Regarde si le sommet existe déjà.
        for(int i = 0; i < this.Sommets.size(); ++i)
        {
            if(this.Sommets.get(i).equals(sommet))
                return true;
        }
        return false;
    }

    @Override
    public boolean contientArc(String src, String dest){//Regarde si l'Arc existe.
        for(int i = 0; i < this.nombreNoeuds; ++i)
        {
            if(this.arcs.get(i).getSource().equals(src) && this.arcs.get(i).getDestination().equals(dest))
                return true;
        }
        return false;
    }

    @Override
    public int getValuation(String src, String dest){//Return la Valuation d'un arc sinon -1
        for(int i = 0; i < this.nombreNoeuds; ++i){
            if(this.arcs.get(i).getSource().equals(src) && this.arcs.get(i).getDestination().equals(dest))
                return this.arcs.get(i).getValuation();
        }
        return -1;
    }

    @Override
    public void ajouterSommet(String noeud){
        if(!this.contientSommet(noeud))//Regarde si le sommet n'existe pas
            this.Sommets.add(noeud);
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur){//Ajoute un arc si les conditions sont bonnes
        if(this.contientArc(source,destination))//Regarde si l'Arc existe
            throw new IllegalArgumentException("Un arc existe déjà entre les sommets : " + source + " et " + destination);
        if (valeur < 0)//Regarde si la valeure est positif
            throw new IllegalArgumentException("Les valuations ne doivent pas etre negatives " + valeur);
        this.arcs.add(new Arc(source,destination,valeur));
    }

    @Override
    public void oterArc(String source, String destination){
        int indice = -1;
        for(int i = 0; i < this.nombreNoeuds; ++i){
            if(this.arcs.get(i).getSource().equals(source) && this.arcs.get(i).getDestination().equals(destination))
                indice = i;
        }
        if(indice == -1)
            throw new IllegalArgumentException("Un arc existe déjà entre les sommets : " + source + " et " + destination);
        else
            this.arcs.remove(indice);

    }

    @Override
    public void oterSommet(String noeud){//Supprime un sommet donne
        int indice = -1;
        for(int i = 0; i < this.Sommets.size();++i){
            if(this.Sommets.get(i).equals(noeud))
                indice = i;
        }
        if(indice >= 0)
            this.Sommets.remove(indice);
    }

    @Override
    public List<String> getSommets(){//Return la liste de Sommet
        return this.Sommets;
    }

    @Override
    public List<String> getSucc(String sommet){//Return la liste des successeurs d'un sommet
        List<String> Succ = new ArrayList<>();
        for(int i = 0; i < this.nombreNoeuds;++i){
            if(this.arcs.get(i).getSource().equals(sommet))
                Succ.add(this.arcs.get(i).getDestination());
        }
        return Succ;
    }

}
