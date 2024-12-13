package Day1;

import java.io.*;
import java.util.*;

public class Day1Part1 {
    public static void main(String[] args) {
        try {
            // Provide the file path as an argument
            IO io = new IO("Code/src/Day1/input.txt");

            List<Integer> firstList = new ArrayList<>();
            List<Integer> secondList = new ArrayList<>();
            int diff = 0;


            while (io.hasNextLine()) { // Ensure you read until the end of the file
                String curr = io.nextLine();
                curr = curr.trim();
                int index = curr.indexOf(' ');
                int first = Integer.parseInt(curr.substring(0, index));
                int second = Integer.parseInt(curr.substring(index + 3, curr.length()));
                firstList.add(first);
                secondList.add(second);
            }

            Collections.sort(firstList);
            Collections.sort(secondList);
            for (int i = 0; i < firstList.size(); i++) {
                diff += Math.abs(firstList.get(i) - secondList.get(i));
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