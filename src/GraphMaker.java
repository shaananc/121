
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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    List<IntersectionI> inters;
    HashSet<StreetI> streets;

    public GraphMaker(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        points = new HashMap();
        inters = new ArrayList();
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

//            if (cur_street.getName().equals("9th Ave")) {
//                int a = 0;
//                a = 1;
//            }

            // List containing just the current street
            List<StreetI> temp = new ArrayList();
            temp.add(cur_street);

            // If have seen the first point before
            if (points.containsKey(pointFirst)) {
                ip[0] = pointFirst;
                points.get(pointFirst).add(cur_street);

            } else {
                points.put(pointFirst, temp);
            }

            // If have seen the second point before
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

                // Get a list of all the streets at that point
                Iterator<StreetI> lstreets = points.get(ip[i]).iterator();
                // For each street at that intersection
                while (lstreets.hasNext()) {
                    StreetI curs = lstreets.next();
                    if (!curs.equals(cur_street)) {
                        IntersectionI inter = new Intersection();
                        List<StreetI> finall = new ArrayList();
                        finall.add(cur_street);
                        finall.add(curs);
                        inter.setStreetList(finall);
                        inter.setPointOfIntersection(ip[i]);
                        inters.add(inter);
                    }
                }


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
            System.out.print(cur_p.toString());
            System.out.print(" Adjacent to:");
            writer.write(cur_p.toString());
            writer.write(" Adjacent to:");
            Iterator<StreetI> streetitr = points.get(cur_p).iterator();
            //for each street in the intersection
            while (streetitr.hasNext()) {
                StreetI cur_street = streetitr.next();
                System.out.print(cur_street.toString());
                System.out.print(",");
                writer.write(cur_street.toString());
                writer.write(",");

            }
            writer.write("\n");
            System.out.print("\n");
        }
        writer.close();
    }

    public static void main(String[] args) {
        System.out.println("test\n");
        try {
            GraphMaker a = new GraphMaker("ny.txt");
        } catch (IOException ex) {
            Logger.getLogger(GraphMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
