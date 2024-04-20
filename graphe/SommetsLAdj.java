package graphe;

import java.util.ArrayList;

public class SommetsLAdj {
    private String NomSommet;
    private ArrayList<String> LAdj;//Liste des sommets adjacent

    private ArrayList<Integer> LValu;//Liste des valuations des arcs

    public SommetsLAdj(String NomSommet)
    {
        this.NomSommet = NomSommet;
        this.LAdj = new ArrayList<>();
        this.LValu = new ArrayList<>();
    }

    public String getNom(){
        return this.NomSommet;
    }

    public ArrayList<String> getListeAdj(){
        return this.LAdj;
    }

    public Integer getValuation(String Sommet){
        for(int i = 0; i < this.LValu.size();++i){
            if(this.LAdj.get(i).equals(Sommet))
            {
                return this.LValu.get(i);
            }
        }
        return -1;
    }

    public void ajouterAdj(String Sommet, Integer valeur){
        this.LAdj.add(Sommet);
        this.LValu.add(valeur);
    }

    public void suprAdj(String Sommet){
        int indice = 0;
        for(int i = 0; i < this.LAdj.size(); ++i){
            if(this.LAdj.get(i).equals(Sommet))
                indice = i;
        }
        this.LAdj.remove(indice);
        this.LValu.remove(indice);
    }

    public boolean EstAdj(String Sommet){
        for(int i = 0; i < this.LAdj.size(); ++i){
            if(this.LAdj.get(i).equals(Sommet))
                return true;
        }
        return false;
    }
}
