/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class eIntersection extends Intersection implements Comparable {

    Double dist = Double.POSITIVE_INFINITY;
    eIntersection prev = null;
    StreetI pstreet = null;

    public eIntersection(IntersectionI inter) {
        this.loc = inter.getLocation();
        this.streets = inter.getStreetList();

    }

    public eIntersection() {
        ;
    }

    public eIntersection(IntersectionI inter, double dist) {
        this.loc = inter.getLocation();
        this.streets = inter.getStreetList();
        this.dist = dist;
    }

    @Override
    public int compareTo(Object t) {
        // Negative is to short smallest to largest
        return Double.compare(dist, ((eIntersection) t).dist);
    }

    @Override
    public boolean equals(Object t) {
        if (((eIntersection) t).hashCode() == this.hashCode()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.loc != null ? this.loc.hashCode() : 0);
        hash = 89 * hash + (this.streets != null ? this.streets.hashCode() : 0);
        return hash;
    }
}
