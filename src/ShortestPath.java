
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class ShortestPath {

    public GraphMaker graph;

    public ShortestPath(GraphMaker graph) {
        this.graph = graph;
    }

    List<IntersectionI> dijkstraPath(IntersectionI start, IntersectionI end) {

        PriorityQueue<eIntersection> pq = new PriorityQueue();

        Iterator<eIntersection> itr = graph.inters.values().iterator();


        // Set up the priority queue
        eIntersection estart = null;
        eIntersection eend = null;
        while (itr.hasNext()) {
            eIntersection cure = itr.next();
            if (cure.equals(start)) {
                //estart = new eIntersection(cure,0);
                cure.dist = 0.0;
                pq.add(cure);
            } else if (cure.equals(end)) {
                //eend = new eIntersection(cure,Double.NEGATIVE_INFINITY);
                eend = cure;
                cure.dist = Double.POSITIVE_INFINITY;
                pq.add(eend);
            } else {
                pq.add(new eIntersection(cure, Double.POSITIVE_INFINITY));
            }

        }

        //The actual algorithm
        while (!pq.isEmpty()) {
            eIntersection u = pq.remove();
            if (u.equals(eend)) {
                break;
            }
            if (u.dist.equals(Double.POSITIVE_INFINITY)) {
                break;
            }

            // To get neighbors:
            // Get the intersection at the end of each neightbor street
            ListIterator<StreetI> sitr = u.streets.listIterator();
            while (sitr.hasNext()) {
                StreetI cur_street = sitr.next();
                Point ipoint = null;
                if (cur_street.getFirstPoint().equals(u.loc)) {
                    ipoint = cur_street.getSecondPoint();
                } else {
                    ipoint = cur_street.getFirstPoint();
                }
                // v is the neighbor
                eIntersection v = graph.inters.get(ipoint);

                //alt is the calculated distance value
                Double alt = u.dist + cur_street.getDistance();

                if (alt < v.dist) {
                    v.dist = alt;
                    v.prev = u;
                    v.pstreet = cur_street;
                    pq.remove(v);
                    pq.add(v);
                }

            }

        }


        List<IntersectionI> result = new ArrayList();
        eIntersection cb = eend;

            while (cb.prev != null) {
         
                result.add(cb);
                cb = cb.prev;
            }

        result.add(start);    
        
        Collections.reverse(result);
        
        return result;
    }

    public static void main(String[] args) {
 
        
        ShortestPath a;
        try {
            File dir = new File("input");
            File[] sub = dir.listFiles();
            for(int i =0; i<sub.length; i++){
                //if(!sub[i].getName().equals("ny.txt")){continue;}
                a = new ShortestPath(new GraphMaker(sub[i].getPath().toString()));
            Iterator<eIntersection> b = a.graph.inters.values().iterator();
            IntersectionI ia = b.next();
            IntersectionI ib = b.next();
//            int j = 0;
//            while (j < 11 && b.hasNext()) {
//                ib = b.next();
//                j++;
//            }

            JavaScriptPointsWriter.output(sub[i].getPath().toString(),a.dijkstraPath(ia, ib));
            
            MinSpanningTree mst = new MinSpanningTree(a.graph);
            JavaScriptPointsWriter.points2(sub[i].getPath().toString(), mst.getMST());
            
            BreadthFirstSearch bfs = new BreadthFirstSearch(a.graph);
            bfs.bfsTraverse(ib);
            //JavaScriptPointsWriter.points3(sub[i].getPath().toString(), bfs.bfsTraverse(ib));
                
                
            }
            
            
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

   
}
