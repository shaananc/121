
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
public class JavaScriptPointsWriter {

    public static void output(String filename, List<?> o) {
        if (o.get(0) instanceof IntersectionI) {
            List<IntersectionI> l = (List<IntersectionI>) o;
            points1(filename, l);
        }

    }

    private static void points1(String filename, List<IntersectionI> l) {

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("html/points1.js", true));
            String aname = "points1_".concat(filename);
            aname = aname.replace(".txt", "");
            aname = aname.replace("input/", "");
            writer.write("// JavaScript file\nvar ".concat(aname).concat(" = new Array();\n\n// Data\n"));

            Iterator<IntersectionI> itr = l.iterator();
            Integer i = 0;
            while (itr.hasNext()) {

                IntersectionI in = itr.next();
                Point cp = in.getLocation();
                writer.write(aname.concat("[").concat(i.toString()).concat("] =").concat(Double.toString(cp.getx())).concat(";\n"));
                i++;
                writer.write(aname.concat("[").concat(i.toString()).concat("] =").concat(Double.toString(cp.gety())).concat(";\n"));
                i++;
            }


            writer.write("\n\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ShortestPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void points2(String filename, Set<StreetI> l) {

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("html/points2.js", true));
            String aname = "points2_".concat(filename);
            aname = aname.replace(".txt", "");
            aname = aname.replace("input/", "");
            writer.write("// JavaScript file\nvar ".concat(aname).concat(" = new Array();\n\n// Data\n"));

            Iterator<StreetI> itr = l.iterator();

            Integer i = 0;
            while (itr.hasNext()) {

                StreetI in = itr.next();
                Point cp = in.getFirstPoint();
                writer.write(aname.concat("[").concat(i.toString()).concat("] =").concat(Double.toString(cp.getx())).concat(";\n"));
                i++;
                writer.write(aname.concat("[").concat(i.toString()).concat("] =").concat(Double.toString(cp.gety())).concat(";\n"));
                i++;
                cp = in.getSecondPoint();
                writer.write(aname.concat("[").concat(i.toString()).concat("] =").concat(Double.toString(cp.getx())).concat(";\n"));
                i++;
                writer.write(aname.concat("[").concat(i.toString()).concat("] =").concat(Double.toString(cp.gety())).concat(";\n"));
                i++;

            }


            writer.write("\n\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ShortestPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void points3(String filename, List<List<IntersectionI>> l) {

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("html/points3.js", true));
            String aname = "points3_".concat(filename);
            aname = aname.replace(".txt", "");
            aname = aname.replace("input/", "");
            writer.write("// JavaScript file\nvar ".concat(aname).concat(" = new Array();\n\n// Data\n"));

            Iterator<List<IntersectionI>> itr = l.iterator();
            Integer i = 0;
            while (itr.hasNext()) {
                Iterator<IntersectionI> itr2 = itr.next().iterator();

                while (itr2.hasNext()) {
                    IntersectionI in = itr2.next();
                    Point cp = in.getLocation();
                    writer.write(aname.concat("[").concat(i.toString()).concat("] =").concat(Double.toString(cp.getx())).concat(";\n"));
                    i++;
                    writer.write(aname.concat("[").concat(i.toString()).concat("] =").concat(Double.toString(cp.gety())).concat(";\n"));
                    i++;
                }

            }


            writer.write("\n\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ShortestPath.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
