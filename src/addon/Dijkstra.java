package addon;
import java.util.*;

public class Dijkstra {
    public static void dijkstra(IGraphe g, String debut, Map<String, Integer> dist, Map<String, String> prev){
        dist.put(debut,0);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));//Queue de priorité
        pq.add(new AbstractMap.SimpleEntry<>(debut,0));//On ajoute le sommet début avec 0 de distance
        Set<String> Deja_utilise = new HashSet<>();//Liste de sommet qui permettra de savoir si on est déjà passé par un sommet
        while(!pq.isEmpty()){
            Map.Entry<String, Integer> sommet = pq.poll();//Le sommet avec la plus petite distance
            if(!Deja_utilise.contains(sommet.getKey())){
                List<String> succ = g.getSucc(sommet.getKey());//Les successeur du sommet
                for(int i = 0; i < succ.size();++i){
                    Integer valeure;
                    valeure = dist.getOrDefault(succ.get(i), Integer.MAX_VALUE);//Calcule de la distance du sommet
                    if(valeure > sommet.getValue() + g.getValuation(sommet.getKey(),succ.get(i))){//Si la distance est plus petite
                        dist.put(succ.get(i), sommet.getValue() + g.getValuation(sommet.getKey(),succ.get(i)));//On rajoute ou on met à jour dist
                        prev.put(succ.get(i), sommet.getKey());//On rajoute ou on met à jour prev
                        pq.add(new AbstractMap.SimpleEntry<>(succ.get(i),sommet.getValue() + g.getValuation(sommet.getKey(),succ.get(i))));//On ajoute le sommet trouvé à la queue
                    }
                }
                Deja_utilise.add(sommet.getKey());//On ajoute le sommet à la liste des sommets déjà visitées
            }
        }
    }
}
