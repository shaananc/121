
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class MinSpanningTree {
    


    GraphMaker graph;

    public MinSpanningTree(GraphMaker graph) {
        this.graph = graph;
    }

    public Set<StreetI> getMST() {
        Set<StreetI> ret = new HashSet();
        UnionFind<Point> uf = new UnionFind();
        PriorityQueue<eStreet> pq = new PriorityQueue();
        for (StreetI st : graph.streets) {
            eStreet ste = new eStreet(st);
            pq.add(ste);
            uf.Add(ste.firstPoint);
            uf.Add(ste.secondPoint);
        }


        while (!pq.isEmpty() && ret.size() < graph.streets.size() - 1) {
            StreetI str = pq.remove();
            Point a = str.getFirstPoint();
            Point b = str.getSecondPoint();
            if (uf.Find(a) != uf.Find(b)) {
                uf.Union(a, b);
                ret.add(str);

            }
        }

        return ret;
    }
}
