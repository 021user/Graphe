	package graphe;

	import java.util.*;


	// ajouterSommet ne fait rien si un sommet est deja present
	// ajouterArc leve une IllegalArgumentException si l'arc est deja present
	// ajouterArc ajoute les sommets s'ils ne sont pas deja presents
	// oterSommet ne fait rien si le sommet n'est pas dans le graphe
	// oterArc leve une IllegalArgumentException si l'arc n'est pas present
	public interface IGraphe extends IGrapheConst {
		void ajouterSommet(String noeud);
		void ajouterArc(String source, String destination, Integer valeur);
		void oterSommet(String noeud);
		void oterArc(String source, String destination);

		// construit un graphe vide a partir d'une chaine
		// au format "A-B(5), A-C(10), B-C(3), C-D(8), E:";
		default void peupler(String str) {
			assert this.getSommets().isEmpty();
			String[] arcs = str.split(",\\s*");
			for (String arc : arcs) {
				String[] elements = arc.trim().split("-");
				// extrait le noeud source et ote ":" si nécessaire dans le nom
				String src = elements[0].replaceAll(":", "");
				ajouterSommet(src);
				if (elements.length == 1)
					continue; // pas de destination
				String target = elements[1];
				if (!target.isEmpty()) {
					 String dest = target.substring(0, target.indexOf('('));
					 int val = Integer.parseInt(target
							.substring(target.indexOf('(') + 1,
										   target.indexOf(')')));
					 ajouterSommet(dest);
					 ajouterArc(src, dest, val);
				}
			}
		}

        default void dijkstra(IGraphe g, String debut, Map<String, Integer> dist, Map<String, String> prev){
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
