
import java.util.List;
import java.lang.Math;

public class Street {

    Point firstPoint;
    Point secondPoint;
    String name;
    List<IntersectionI> intersections; 
    Integer id;
    
    
    
    public void setIdNumber(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPoints(Point firstPoint, Point secondPoint){
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Point getFirstPoint(){
        return this.firstPoint;
    }

    public Point getSecondPoint(){
        return this.secondPoint;
    }

    public int getIdNumber(){
        return id;
    }

    //Distance Formula
    public Double getDistance(){
        //sqrt((x2-x1)^2+(y2-y1)^2)
        return Math.sqrt(Math.pow((secondPoint.getx()-firstPoint.getx()),2.0)+Math.pow((secondPoint.gety()-firstPoint.gety()),2.0) );
        
    }

    public String toString();
}

