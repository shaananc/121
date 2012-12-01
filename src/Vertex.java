
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Vertex implements Comparable<Vertex>{

    public Object obj;
    public List<Edge> adj;
    public Vertex prev;
    public double mind = Double.POSITIVE_INFINITY;
    
    @Override
    public int compareTo(Vertex o){
        return Double.compare(mind, o.mind);
    }

}