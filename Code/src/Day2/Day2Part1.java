package Day2;

import java.io.*;
import java.util.*;

public class Day2Part1 {
    public static void main(String[] args) {
        try {
            IO io = new IO("Code/src/Day2/input-2.txt");

            List<List<Integer>> matrix = new ArrayList<>();
            int safe = 0;


            while (io.hasNextLine()) {
                String curr = io.nextLine();
                curr = curr.trim();
                String[] line = curr.split(" ");
                List<Integer> currLine = new ArrayList<>();
                for(int i = 0; i < line.length; i++) {
                    currLine.add(Integer.parseInt(line[i]));
                }
                matrix.add(currLine);
            }

            for(int i = 0; i < matrix.size(); i++) {
                int increasing = 0;
                boolean check = true;
                for(int j = 0; j < matrix.get(i).size() - 1; j++) {
                    if(Math.abs(matrix.get(i).get(j) - matrix.get(i).get(j + 1)) > 3) {
                        check = false;
                        break;
                    } else if(matrix.get(i).get(j) == matrix.get(i).get(j + 1)) {
                        check = false;
                        break;
                    }
                    if(matrix.get(i).get(j) < matrix.get(i).get(j + 1)) {
                        increasing++;
                    }
                }
                if(check && (increasing == 0 || increasing == matrix.get(i).size() - 1)) {
                    safe++;
                }
            }
            System.out.println(safe);
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
