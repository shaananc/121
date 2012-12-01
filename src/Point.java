
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
        //TODO: Implement toString
        return "(".concat(this.x.toString()).concat(this.y.toString()).concat(")");
    }

    //These two methods override the normal java object functions
    //and may be implemented by the student
    @Override
    public int hashCode() {
        //TODO: Implement hashCode
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point j = (Point) o;
            if (this.x == j.x && this.y == j.y) {
                return true;
            }
        }

        return false;
    }
}
