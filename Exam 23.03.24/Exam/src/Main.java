import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, List<Program>> map = new HashMap<>();

        List<String> schedule = Main.readFiles("schedule.txt");


        String currentChannelName = null;
        String currentProgramTime = null;
        String currentProgramName = null;

        for (int i = 0; i < schedule.size(); i++) {
            char firstChar = schedule.get(i).charAt(0);
            if (firstChar == '#') {
                currentChannelName = schedule.get(i);
            } else {
                currentProgramTime = schedule.get(i);
                currentProgramName = schedule.get(++i);

                map.put(currentChannelName, );
            }
        }


        while(true) {

        }
    }

    public static List<String> readFiles(String fileName) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fileName));
        List<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.nextLine());
        }
        s.close();
        return list;
    }
}