
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
class UnionFind<T> {

    List<HashSet<T>> all;

    public UnionFind() {
        all = new ArrayList<HashSet<T>>();


    }
    
    public void Add(T x){
        if(Find(x) == null){
            HashSet<T> a = new HashSet();
            a.add(x);
            all.add(a);
        }
    }

    public HashSet<T> Find(T x) {

        Iterator<HashSet<T>> itr = all.iterator();
        while (itr.hasNext()) {
            HashSet<T> cs = itr.next();
            if (cs.contains(x)) {
                return cs;
            }
        }
        
        return null;
    }

    public void Union(T x, T y) {
        HashSet<T> a = Find(x);
        HashSet<T> b = Find(y);
        a.addAll(b);
        all.remove(b);
        
    }
    
    public void test(){
        
    }
    
}
