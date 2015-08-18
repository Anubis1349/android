package Data;
import com.project.hacksim.RunningApplication;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import com.google.gson.*;

/**
 * Created by Kerman on 23.4.2015.
 */
public class Util {
    public static Random rnd=new Random();

    public static void shrani(RunningApplication r, String ime){
        try {
            File file = new File(ime);
            file.getParentFile().mkdirs();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            PrintWriter pw = new PrintWriter(file);
            pw.println(gson.toJson(r)); //a is my object
            pw.close();
        } catch (IOException e) {
            System.out.println("Error save team!");
        }
    }
    public static RunningApplication nalozi(String ime){
        try {
            File file = new File(ime);
            FileInputStream fstream = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader( new InputStreamReader(in));
            StringBuffer sb = new StringBuffer();
            String strLine;
            while ((strLine = br.readLine()) != null) {sb.append(strLine).append('\n');}
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            RunningApplication a = gson.fromJson(sb.toString(), RunningApplication.class);
            if (a == null) { System.out.println("Error: fromJson Format error");
            } else { System.out.println(a.toString()); };
            return a;
        } catch (IOException e) {
            System.out.println("Error load Team");
        }
        return null;
    }
}
