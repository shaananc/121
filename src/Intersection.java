
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Intersection implements IntersectionI {

	/**
	 * Returns the point at which this intersection is located at.
	 * @return A point.
	 */
         Point loc;
         List<StreetI> streets;
    
         public Intersection(){
             streets = new ArrayList();
         }
         
	public Point getLocation(){
            return loc;
        }

	/**
	 * Returns the list of streets that pass through this intersection.
	 * @return A street list.
	 */
	public List<StreetI> getStreetList(){
            return streets;
        }

	/**
	 * Sets the point at which this intersection is located at.
	 * @param p
	 */
	public void setPointOfIntersection(final Point p){
            loc = p;
        }

	/**
	 * Sets the list of streets that pass through this intersection.
	 * @param list
	 */
	public void setStreetList(final List<StreetI> list){
            streets = list;
        }

	/**
	 * Determines whether this intersection is connected another intersection.
	 * @param intersection to check for connectivity
	 * @return the street that links the two intersections, null if none.
	 */
	public StreetI isConnected(final IntersectionI intersection){
            List ostreets = intersection.getStreetList();
            Iterator<StreetI> itr = ostreets.iterator();
            while(itr.hasNext()){
                int index;
                index = streets.indexOf(itr.next());
                if (index!=-1){
                    return streets.get(index);
                }
            }
            return null;
        }


        

}


