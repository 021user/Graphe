package graphe;
import java.util.*;

public class Dijkstra {
    public static void dijkstra(IGraphe g, String debut, Map<String, Integer> dist, Map<String, String> prev){
        dist.put(debut,0);
        prev.put(g.getSommets().get(0),null);
        for(int i = 1; i < g.getSommets().size(); ++i){
            dist.put(g.getSommets().get(i),Integer.MAX_VALUE);
            prev.put(g.getSommets().get(i),null);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        pq.add(new AbstractMap.SimpleEntry<>(debut,0));
        Set<String> Deja_utilise = new HashSet<>();
        while(!pq.isEmpty()){
            Map.Entry<String, Integer> sommet = pq.poll();
            if(!Deja_utilise.contains(sommet.getKey())){
                for(int i = 0; i < g.getSucc(sommet.getKey()).size();++i){
                    if(dist.get(g.getSommets().get(i)) > sommet.getValue() + g.getValuation(sommet.getKey(),g.getSommets().get(i))){
                        dist.put(g.getSommets().get(i), sommet.getValue() + g.getValuation(sommet.getKey(),g.getSommets().get(i)));
                        prev.put(g.getSommets().get(i), sommet.getKey());
                        pq.add(new AbstractMap.SimpleEntry<>(g.getSommets().get(i),sommet.getValue() + g.getValuation(sommet.getKey(),g.getSommets().get(i)) ));
                    }
                }
                Deja_utilise.add(sommet.getKey());
            }
        }
    }
}
