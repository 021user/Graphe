package graphe;

import java.util.ArrayList;
import java.util.List;

public class GrapheLAdj extends Graphe{

    private ArrayList<SommetsLAdj> LSommets;

    public GrapheLAdj(){
        this.LSommets = new ArrayList<>();
    }
    @Override
    public boolean contientSommet(String sommet){//Regarde si le sommet existe déjà.
        for(int i = 0; i < this.LSommets.size(); ++i)
        {
            if(this.LSommets.get(i).getNom().equals(sommet))
                return true;
        }
        return false;
    }

    @Override
    public boolean contientArc(String src, String dest){//Regarde si l'Arc existe.
        for(int i = 0; i < this.LSommets.size(); ++i){
            if(this.LSommets.get(i).getNom().equals(src))
                return this.LSommets.get(i).EstAdj(dest);
        }
        return false;
    }

    @Override
    public int getValuation(String src, String dest){//Return la Valuation d'un arc sinon -1.
        for(int i = 0; i < this.LSommets.size();++i){
            if(this.LSommets.get(i).getNom().equals(src))
                return this.LSommets.get(i).getValuation(dest);
        }
        return -1;
    }

    @Override
    public void ajouterSommet(String noeud){
        if(!this.contientSommet(noeud))
            this.LSommets.add(new SommetsLAdj(noeud));
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur){//Ajoute un arc si les conditions sont bonnes
        if (valeur < 0)//Regarde si la valeure est positif
            throw new IllegalArgumentException("Les valuations ne doivent pas etre negatives " + valeur);
        if(!this.contientSommet(source))//Rajoute le Sommet source si il n'existe pas
            this.ajouterSommet(source);
        if(!this.contientSommet(destination))//Rajoute le Sommet destination si il n'existe pas
            this.ajouterSommet(destination);
        for(int i = 0; i < this.LSommets.size();++i){
            if(this.LSommets.get(i).getNom().equals(source)){
                if(this.LSommets.get(i).EstAdj(destination))
                    throw new IllegalArgumentException("L'arc existe déjà");
                this.LSommets.get(i).ajouterAdj(destination,valeur);
            }
        }
    }

    @Override
    public void oterArc(String source, String destination){
        if(!this.contientArc(source,destination))
            throw new IllegalArgumentException("L'arc cherché n'existe pas");
        for(int i = 0; i < this.LSommets.size();++i){
            if(this.LSommets.get(i).getNom().equals(source)){
                this.LSommets.get(i).suprAdj(destination);
            }
        }
    }

    @Override
    public void oterSommet(String noeud) {//Supprime un sommet
        int indice = -1;
        for (int i = 0; i < this.LSommets.size(); ++i) {
            if (this.LSommets.get(i).getNom().equals(noeud))
                indice = i;
        }
        if (indice >= 0) {
            for (int i = 0; i < this.LSommets.size(); ++i) {
                for (int j = 0; j < this.LSommets.get(i).getListeAdj().size(); ++j) {
                    if (this.LSommets.get(i).getListeAdj().get(j).equals(noeud))
                        this.LSommets.get(i).getListeAdj().remove(j);
                }
            }
            this.LSommets.remove(indice);
        }
    }

    @Override
    public List<String> getSommets(){//Return la liste de Sommet
        List<String> ListeSommets = new ArrayList<>();
        for(int i = 0; i < this.LSommets.size(); ++i){
            ListeSommets.add(this.LSommets.get(i).getNom());
        }
        return ListeSommets;
    }

    @Override
    public List<String> getSucc(String sommet){//Return la liste des successeurs d'un sommet
        for(int i = 0; i < this.LSommets.size();++i){
            if(this.LSommets.get(i).getNom().equals(sommet))
            {
                return this.LSommets.get(i).getListeAdj();
            }
        }
        return new ArrayList<String>();
    }
}
