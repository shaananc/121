
/**
 * A self explanatory class.
 * For this assignment you can assume that every point is essentially
 * an intersection. More precisely, the location of an intersection
 * is a point, and all points will be represented by an intersection, as
 * we have chosen a closed set of points (a closed graph).
 *
 * @author StudentName
 *
 */
public class Point {

    double x;
    double y;

    public double getx() {
        //TODO
        return x;
    }

    public void setx(double x) {
        this.x = x;
    }

    public double gety() {
        return y;
    }

    public void sety(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(".concat(Double.toString(this.x)).
                concat(Double.toString(this.y))
                .concat(")");
    }

    //These two methods override the normal java object functions
    //and may be implemented by the student
//    @Override
//    public int hashCode() {
//        //TODO: Implement hashCode
//        return -1;
//    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point && o.hashCode() == this.hashCode()){return true;}
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }
}
