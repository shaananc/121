
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Iterator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class GraphMaker {

    // This is the adjacency list
    public HashMap<Point, List<StreetI>> points;
    // List of intersections
    public HashMap<Point, eIntersection> inters;
    // List of streets
    public HashSet<StreetI> streets;
    
    //Filename public
    public String filename;

    public GraphMaker(String filename) throws IOException {
        this.filename = filename;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        points = new HashMap();
        inters = new HashMap();
        streets = new HashSet();

        // skip first line
        line = reader.readLine();
        // for each street line
        while ((line = reader.readLine()) != null) {
            // Split the string
            String split[] = line.split(",");


            // Make the two Points
            Point pointFirst = new Point(Double.parseDouble(split[1]), Double.parseDouble(split[2]));
            Point pointSecond = new Point(Double.parseDouble(split[3]), Double.parseDouble(split[4]));

            // Make the street
            StreetI cur_street = new Street();
            cur_street.setIdNumber(Integer.parseInt(split[0]));
            cur_street.setPoints(pointFirst, pointSecond);
            cur_street.setName(split[5]);
            streets.add(cur_street);

            // Check for intersection
            Point[] ip = new Point[2];
            ip[0] = null;
            ip[1] = null;




            // If have seen the first point before
            if (points.containsKey(pointFirst)) {
                ip[0] = pointFirst;
                points.get(pointFirst).add(cur_street);

            } else {
                // List containing just the current street
                List<StreetI> temp = new ArrayList();
                temp.add(cur_street);
                points.put(pointFirst, temp);
            }

            // If have seen the second point before


            if (points.containsKey(pointSecond)) {
                if (pointFirst.x == 39.949838 && pointFirst.y == -75.192633 && pointSecond.x == 39.949787 && pointSecond.y == -75.192646) {
                    int a;
                    a = 0;
                }
                //Hash code for bugone: 1815457517
                Point tp = new Point(39.949660, -75.192674);
                Point tg = new Point(39.949787, -75.192646);

                List<StreetI> streets2 = points.get(pointSecond);
                streets2.add(cur_street);




                ip[1] = pointSecond;
            } else {
                // List containing just the current street
                List<StreetI> temp = new ArrayList();
                temp.add(cur_street);
                points.put(pointSecond, temp);
            }

            // for each intersection
            int i = 0;
            while (i < 2) {
                if (ip[i] == null) {
                    i++;
                    continue;
                }

                // Get a list of all the streets at that point
                List<StreetI> lstreets = points.get(ip[i]);
                if (!lstreets.contains(cur_street)) {
                    lstreets.add(cur_street);
                }
                eIntersection inter = new eIntersection();
                List<StreetI> finall = new ArrayList();
                inter.setStreetList(lstreets);
                inter.setPointOfIntersection(ip[i]);
                inters.put(ip[i], inter);


                i++;
            }



        }











        int a = 1;
        a = a + 2;

        output();
    }

    private void output() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("adjacency.txt"));
        Iterator<Point> itr = points.keySet().iterator();

        //for each intersection
        while (itr.hasNext()) {
            Point cur_p = itr.next();
            writer.write(cur_p.toString());
            writer.write(" Adjacent to:");
            Iterator<StreetI> streetitr = points.get(cur_p).iterator();
            //for each street in the intersection
            while (streetitr.hasNext()) {

                StreetI cur_street = streetitr.next();
                writer.write("(");
                if (cur_p.equals(cur_street.getFirstPoint())) {

                    writer.write(Double.toString(cur_street.getFirstPoint().getx()));
                    writer.write(",");
                    writer.write(Double.toString(cur_street.getFirstPoint().gety()));

                } else {
                    writer.write(Double.toString(cur_street.getSecondPoint().getx()));
                    writer.write(",");
                    writer.write(Double.toString(cur_street.getSecondPoint().gety()));
                }
                writer.write(",");
                writer.write(cur_street.getName());
                writer.write(",");
                writer.write(Integer.toString(cur_street.getIdNumber()));
                writer.write(")");

                writer.write(",");

            }
            writer.write("\n");
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("test\n");

        GraphMaker a = new GraphMaker("ny.txt");




    }
}
