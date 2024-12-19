package Day3;

import java.io.*;
import java.util.StringTokenizer;

public class Day3Part2 {
    public static void main(String[] args) {
        try {
            IO io = new IO("Code/src/Day3/input3.txt");
            long multValue = 0;
            boolean on = true;

            while(io.hasNextLine()) {
                String line = io.nextLine();
                // process
                int start = 0;
                while(start < line.length()) {
                    if(hasDo(line, start)) {
                        on = true;
                    }
                    if(hasDont(line, start)) {
                        on = false;
                    }


                    if(hasMult(line, start)) {
                        int end = -1;
                        for(int j = start + 4; j <= start + 11; j++) {
                            if(j >= line.length()) break;
                            if(line.charAt(j) == ')') {
                                end = j;
                                break;
                            }
                        }
                        if(end != -1) {
                            String parse = line.substring(start + 4, end);
                            String[] numbers = parse.split(",");
                            if(numbers.length == 2) {
                                boolean valid = true;
                                for(int i = 0; i < numbers.length; i++) {
                                    for(int j = 0; j < numbers[i].length(); j++) {
                                        char curr = numbers[i].charAt(j);
                                        if(curr == ' ' || !Character.isDigit(curr)) {
                                            valid = false;
                                        }
                                    }
                                }
                                if(on && valid) {
                                    multValue += ((long)Integer.parseInt(numbers[0]) * (long)Integer.parseInt(numbers[1]));
                                }
                            }
                        }
                    }
                    start++;
                }
            }

            System.out.println("-----");
            System.out.println(multValue);

            io.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean hasDo(String line, int start) {
        return line.startsWith("do()", start);
    }

    public static boolean hasDont(String line, int start) {
        return line.startsWith("don't()", start);
    }

    public static boolean hasMult(String line, int start) {
        return line.startsWith("mul(", start);
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
