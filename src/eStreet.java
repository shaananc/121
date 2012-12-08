/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class eStreet extends Street implements Comparable {
    
            public eStreet(StreetI s){
            this.firstPoint = s.getFirstPoint();
            this.name = s.getName();
            this.secondPoint = s.getSecondPoint();
            this.id = s.getIdNumber();
            
        }
        
        @Override
        public int compareTo(Object o) {
            if (o instanceof eStreet){
            return Double.compare(this.getDistance(),((eStreet)o).getDistance());
            }
            else return 0;
        }
    
}
