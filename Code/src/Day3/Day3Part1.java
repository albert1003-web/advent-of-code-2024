package Day3;

import java.io.*;
import java.util.*;

public class Day3Part1 {
    public static void main(String[] args) {
        try {
            IO io = new IO("Code/src/Day3/input3.txt");
            String delimiter = "mul";
            long multValue = 0;

            while(io.hasNextLine()) {
                String line = io.nextLine();
                String[] content = line.split(delimiter);
                for(int i = 0; i < content.length; i++) {
                    String characters = content[i];
                    if(characters.charAt(0) != '(') continue;
                    int closing = characters.indexOf(')');
                    if(closing == -1) continue;
                    String mult = characters.substring(1, closing);

                    String[] numbers = mult.split(",");
                    if(numbers.length != 2) continue;

                    int invalid = 0;
                    for(int j = 0; j < numbers.length; j++) {
                        for(int k = 0; k < numbers[j].length(); k++) {
                            if (numbers[j].charAt(k) == ' ' || !Character.isDigit(numbers[j].charAt(k))) {
                                invalid++;
                            }
                        }
                    }
                    if(invalid > 0) continue;

                    multValue += (Long.parseLong(numbers[0]) * Long.parseLong(numbers[1]));

                }

            }

            System.out.println("-----");
            System.out.println(multValue);

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

