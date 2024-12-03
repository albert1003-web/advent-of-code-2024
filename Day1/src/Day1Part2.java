import java.io.*;
import java.util.*;

public class Day1Part2 {
    public static void main(String[] args) {
        try {
            // Provide the file path as an argument
            IO io = new IO("/Users/albertming/Desktop/advent-of-code-2024/advent-of-code-2024/Day1/src/input.txt");

            List<Integer> firstList = new ArrayList<>();
            HashMap<Integer, Integer> secondMap = new HashMap<>();
            int diff = 0;


            while (io.hasNextLine()) { // Ensure you read until the end of the file
                String curr = io.nextLine();
                curr = curr.trim();
                int index = curr.indexOf(' ');
                int first = Integer.parseInt(curr.substring(0, index));
                int second = Integer.parseInt(curr.substring(index + 3, curr.length()));
                firstList.add(first);
                if(secondMap.containsKey(second)) {
                    secondMap.put(second, 1 + secondMap.get(second));
                } else {
                    secondMap.put(second, 1);
                }
            }
            for (int i = 0; i < firstList.size(); i++) {
                int curr = firstList.get(i);
                if(secondMap.containsKey(curr)) {
                    diff += curr * secondMap.get(curr);
                }
            }

            System.out.println(diff);
            io.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class IO {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        private PrintWriter writer;

        public IO(String filePath) throws FileNotFoundException {
            reader = new BufferedReader(new FileReader(filePath));
            writer = new PrintWriter(System.out);
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean hasNextLine() {
            try {
                return reader.ready();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            writer.close();
        }
    }
}
