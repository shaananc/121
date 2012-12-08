
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class BreadthFirstSearch {

    GraphMaker graph;

    public BreadthFirstSearch(GraphMaker graph) {
        this.graph = graph;
    }

    HashMap<IntersectionI, List<IntersectionI>> bfsTraverse(IntersectionI source) {
        
        /* to try and get good output */
        List<List<IntersectionI>> llist = new ArrayList();
        
        HashMap<IntersectionI, List<IntersectionI>> result = new HashMap();
        HashSet<IntersectionI> marked = new HashSet();

        Queue<IntersectionI> q = new LinkedList();
        q.add(source);
        marked.add(source);
        

        while (!q.isEmpty()) {
            IntersectionI cint = q.remove();
            Point cloc = cint.getLocation();
            System.out.println("New Node".concat(cint.getLocation().toString()));

            PriorityQueue<eStreet> streets = new PriorityQueue();
            Iterator<StreetI> itr = cint.getStreetList().iterator();

            while (itr.hasNext()) {
                eStreet i = new eStreet(itr.next());
                streets.add(i);

            }

            List<IntersectionI> children = new ArrayList();
            while (!streets.isEmpty()) {
                StreetI cstreet = streets.remove();
                System.out.println(cstreet.getDistance().toString().concat(",").concat(cstreet.toString()));
                Point op = null;
                if (cstreet.getFirstPoint().equals(cloc)) {
                    op = cstreet.getSecondPoint();
                } else if (cstreet.getSecondPoint().equals(cloc)) {
                    op = cstreet.getFirstPoint();
                }

                IntersectionI nint = graph.inters.get(op);
                if (!marked.contains(nint)) {
                    q.add(nint);
                    children.add(cint);
                    children.add(nint);
                    marked.add(nint);
                }
            }
            result.put(cint, children);
            llist.add(children);


        }

        JavaScriptPointsWriter.points3(graph.filename, llist);
        return result;
    }
}
