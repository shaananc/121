
import java.util.List;

public class Intersection {

	/**
	 * Returns the point at which this intersection is located at.
	 * @return A point.
	 */
         Point loc;
    
	public Point getLocation(){
            return loc;
        }

	/**
	 * Returns the list of streets that pass through this intersection.
	 * @return A street list.
	 */
	public List<StreetI> getStreetList();

	/**
	 * Sets the point at which this intersection is located at.
	 * @param p
	 */
	public void setPointOfIntersection(final Point p);

	/**
	 * Sets the list of streets that pass through this intersection.
	 * @param list
	 */
	public void setStreetList(final List<StreetI> list);

	/**
	 * Determines whether this intersection is connected another intersection.
	 * @param intersection to check for connectivity
	 * @return the street that links the two intersections, null if none.
	 */
	public StreetI isConnected(final IntersectionI intersection);
}


