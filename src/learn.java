import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class learn {
    private static String filename = "labsafetyterms.txt";
    private static HashMap<String, String> hashmap;
    public static void main(String args[]) {
        hashmap = new HashMap<>();
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            List<String> lines = new ArrayList<>();
            while(scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            for(int i = 0; i < lines.size() - 1; i+=2) {
                //replace (i) and (i+1) to reverse terms
                hashmap.put(lines.get(i+1).trim(), lines.get(i).trim());
            }
            scanner.close();
            learn();
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    private static void learn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String key = (String)(hashmap.keySet().toArray()[(int)(Math.random() * (hashmap.size()))]);
            //change keySet to valueSet if you want to learn opposite
            System.out.println(hashmap.get(key) + " is\n");
            System.out.println(key + "\n\n\n\n"); 
            if (scanner.nextLine().equals("close")) {
                break;
            }
        }
        scanner.close();
    }
}
