import java.util.List;
import java.util.ArrayList;

public class Street implements StreetI {

    Point firstPoint;
    Point secondPoint;
    String name;
    List<IntersectionI> intersections; 
    Integer id;
    
    public Street(){
        intersections = new ArrayList();
    }
    
    
    @Override
    public void setIdNumber(int id){
        this.id = id;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void setPoints(Point firstPoint, Point secondPoint){
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public Point getFirstPoint(){
        return this.firstPoint;
    }

    @Override
    public Point getSecondPoint(){
        return this.secondPoint;
    }

    @Override
    public int getIdNumber(){
        return id;
    }

    //Distance Formula
    @Override
    public Double getDistance(){
        //sqrt((x2-x1)^2+(y2-y1)^2)
        return Math.sqrt(Math.pow((secondPoint.getx()-firstPoint.getx()),2.0)+Math.pow((secondPoint.gety()-firstPoint.gety()),2.0) );
        
    }

    @Override
    public String toString(){
        return "(".
                concat(Double.toString(firstPoint.getx())).
                concat(",").
                concat(Double.toString(firstPoint.gety())).
                concat(",").
                concat(name).
                concat(Double.toString(secondPoint.getx())).
                concat(Double.toString(secondPoint.gety()));
    }
}

