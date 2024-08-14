import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class quiz {
    private static int numberRight = 0;
    private static int numberWrong = 0;
    private static HashMap<String, String> hashmap;
    //use CASESENSITIVE = true if you want to practice capitalization for inputs
    private final static boolean CASESENSITIVE = true;
    public static void main(String[] args) {
        String filename = "commonelements.txt";
        //filename- put full path if it is not working
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
                hashmap.put(lines.get(i).trim(), lines.get(i+1).trim());
            }
            scanner.close();
            Scanner scanner2 = new Scanner(System.in);
            quizSymbol(scanner2);
            if((numberWrong + numberRight) != 0){
                System.out.println("You got " + numberRight + "/" + (numberRight+numberWrong) + "("+ ((double)(100 * numberRight))/((double)(numberRight + numberWrong)) + "%).");
            }
            scanner2.close();
        } catch(FileNotFoundException e) {
            System.out.println("File was not found.");
        }
    }
    private static void quizSymbol(Scanner scanner) {
        if(hashmap.isEmpty()) {
            return;
        }
        String symbol = (String)(hashmap.keySet().toArray()[(int)(Math.random() * (hashmap.size()))]);
        String element = hashmap.get(symbol);
        System.out.println(symbol);
        String input = scanner.nextLine();
        if(!CASESENSITIVE) {
            input = input.toLowerCase();
        }
        if(!input.equals("close")) {
            if(input.equals(element)) {
                System.out.println("Correct!");
                hashmap.remove(symbol, element);
                numberRight++;
            } else {
                System.out.println("You're an idiot. The answer was " + element);
                numberWrong++;
            }
            quizSymbol(scanner);
        }
    }
}
