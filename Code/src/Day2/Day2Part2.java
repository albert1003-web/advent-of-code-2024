package Day2;

import java.io.*;
import java.util.*;

public class Day2Part2 {
    public static void main(String[] args) {
        try {

            Day2Part1.IO io = new Day2Part1.IO("Code/src/Day2/input-2.txt");

            List<List<Integer>> matrix = new ArrayList<>();
            List<Integer> invalid = new ArrayList<>();
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
                if(checkArray(matrix.get(i))) {
                    safe++;
                } else {
                    invalid.add(i);
                }
            }
            for(int i = 0; i < invalid.size(); i++) {
                List<Integer> currMatrix = matrix.get(i);
                for(int j = 0; j < currMatrix.size(); j++) {
                    int value = currMatrix.remove(j);
                    if(checkArray(currMatrix)) {
                        safe++;
                        break;
                    }
                    currMatrix.add(j, value);
                }
            }
            System.out.println(safe);

            io.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkArray(List<Integer> array) {
        int increasing = 0;
        boolean check = true;
        for(int j = 0; j < array.size() - 1; j++) {
            if(Math.abs(array.get(j) - array.get(j + 1)) > 3) {
                check = false;
                break;
            } else if(array.get(j) == array.get(j + 1)) {
                check = false;
                break;
            }
            if(array.get(j) < array.get(j + 1)) {
                increasing++;
            }
        }
        if(check && (increasing == 0 || increasing == array.size() - 1)) {
            return true;
        } else {
            return false;
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
