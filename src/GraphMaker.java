
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.lang.IllegalArgumentException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class GraphMaker {

    HashMap<Point, List<StreetI>> points;
    HashMap<Point, IntersectionI> inters;
    HashSet<StreetI> streets;

    public GraphMaker(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        points = new HashMap();
        inters = new HashMap();
        streets = new HashSet();

        // For each movie
        // skip first line
        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            String split[] = line.split(",");
            StreetI cur_street = new Street();
            IntersectionI inter;
            Point pointFirst = new Point(Double.parseDouble(split[1]), Double.parseDouble(split[2]));
            Point pointSecond = new Point(Double.parseDouble(split[3]), Double.parseDouble(split[4]));
            cur_street.setIdNumber(Integer.parseInt(split[0]));
            cur_street.setPoints(pointFirst, pointSecond);
            cur_street.setName(split[5]);
            streets.add(cur_street);

            // Check for intersection
            Point[] ip = new Point[2];
            ip[0] = null;
            ip[1] = null;


            List<StreetI> temp = new ArrayList();
            temp.add(cur_street);

            if (points.containsKey(pointFirst)) {
                ip[0] = pointFirst;
                // TODO possible bug. Make sure this updates the internal oe
                points.get(pointFirst).add(cur_street);


            } else {
                points.put(pointFirst, temp);

            }
            if (points.containsKey(pointSecond)) {
                points.get(pointSecond).add(cur_street);
                ip[1] = pointSecond;

            } else {
                points.put(pointSecond, temp);
            }

            // for each intersection
            int i = 0;
            while (i < 2) {
                if (ip[i] == null) {
                    i++;
                    continue;
                }
                // check if the intersection is new
                if (!inters.containsKey(ip[i])) {
                    inter = new Intersection();
                    inter.setPointOfIntersection(ip[i]);
                } else {
                    inter = inters.get(ip[i]);
                }

                List<StreetI> lstreets = points.get(ip[i]);
                inter.setStreetList(lstreets);
                inters.put(ip[i], inter);
                i++;
            }










        }
        int a = 1;
        a = a + 2;


    }

    public static void main(String[] args) {
        System.out.println("test\n");
        try {
            GraphMaker a = new GraphMaker("ny.txt");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
