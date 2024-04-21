package graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheMAdj extends Graphe {
	private int[][] MVolume;
    private ArrayList<String> NomSommet ;

    private int NbSommets;
    
    public GrapheMAdj() {
        this.MVolume = new int[0][0];
        this.NomSommet = new ArrayList<>();
        this.NbSommets = 0;
    }

    public int Indice(String sommet){
        for(int i = 0; i < this.NbSommets;++i){
            if(this.NomSommet.get(i).equals(sommet))
                return i;
        }
        return -1;
    }


	@Override
    public void ajouterSommet(String noeud) {
        if(!this.contientSommet(noeud)){
            this.NomSommet.add(noeud);
            this.NbSommets+=1;
            int[][] newM = new int [this.NbSommets][this.NbSommets];
            for(int i = 0; i < this.NbSommets;++i){
                if(i == this.NbSommets-1)
                {
                    for(int j = 0; j < this.NbSommets;++j){
                        newM[i][j] = -1;
                    }
                }
                else{
                    for(int j = 0; j < this.NbSommets;++j){
                        if(j == this.NbSommets-1){
                            newM[i][j] = -1;
                        }
                        else{
                            newM[i][j] = this.MVolume[i][j];
                        }
                    }
                }
            }
            this.MVolume = newM;
        }
    }

	public void ajouterArc(String source, String destination, Integer valeur) {
        if (valeur < 0)//Regarde si la valeure est positif
            throw new IllegalArgumentException("Les valuations ne doivent pas etre negatives " + valeur);
        int x = this.Indice(source);
        int y = this.Indice(destination);
        if(x == -1)
            this.ajouterSommet(source);
        if(y == -1)
            this.ajouterSommet(destination);
        x = this.Indice(source);
        y = this.Indice(destination);
        if(this.MVolume[x][y] != -1)
            throw new IllegalArgumentException("L'arc existe déjà");
        else
            this.MVolume[x][y] = valeur;
	}


    @Override
    public void oterSommet(String noeud) {//A corriger
        if(this.contientSommet(noeud)){
            int x = this.Indice(noeud);
            int[][] newM = new int[this.NbSommets-1][this.NbSommets-1];
            int cpt1 = 0;//Compteur de taille de newM
            int cpt2 = 0;//Compteur de taille de newM
            for(int i = 0; i < this.NbSommets;++i){
                if(i != x)
                {
                    for(int j = 0; j < this.NbSommets;++j){
                        if(j != x) {
                            newM[cpt1][cpt2] = this.MVolume[i][j];
                            cpt2+=1;
                        }
                    }
                    cpt1+=1;
                }
                cpt2 = 0;
            }
            this.NomSommet.remove(x);
            this.NbSommets-=1;
            this.MVolume = newM;
        }
    }

    @Override
    public void oterArc(String source, String destination) {
        int x = this.Indice(source);
        int y = this.Indice(destination);
        if(x == -1 || y == -1 || this.MVolume[x][y] == -1)
            throw new IllegalArgumentException("L'arc n'existe pas");
        else
            this.MVolume[x][y] = -1;
    }

    @Override
    public List<String> getSucc(String sommet) {
        ArrayList<String> Succ = new ArrayList<>();
        int x = this.Indice(sommet);
        for(int i = 0; i < this.NbSommets;++i){
            if(this.MVolume[x][i] > 0)
            {
                Succ.add(this.NomSommet.get(i));
            }
        }
        return Succ;
    }


    @Override
    public List<String> getSommets() {
        return this.NomSommet;
    }

    @Override
    public int getValuation(String src, String dest) {
        if(!this.contientArc(src,dest))
            return -1;
        int x = this.Indice(src);
        int y = this.Indice(dest);
        return this.MVolume[x][y];
    }

    @Override
    public boolean contientSommet(String sommet) {
        for(int i = 0; i < this.NomSommet.size(); ++i)
        {
            if(this.NomSommet.get(i).equals(sommet))
                return true;
        }
        return false;
    }

    @Override
    public boolean contientArc(String src, String dest) {
        int x = this.Indice(src);
        int y = this.Indice(dest);
        if(x == -1 || y == -1 || this.MVolume[x][y] == -1)
            return false;
        return true;
    }

}
