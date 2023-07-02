package com.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) throws IOException {
        String fileName = "D:\\work\\Sber\\lesson_1\\src\\main\\java\\com\\example\\Data.csv";
        Path path = Paths.get(fileName);
        Scanner sc = new Scanner(path);
        sc.useDelimiter(System.getProperty("line.separator"));

        while (sc.hasNext()) {
            Sections sl = parseFile(sc.next());
            System.out.println(sl.toString());
        }
        sc.close();
    }

    public static Sections parseFile(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter("\\s*;\\s*");

        int nm = scanner.nextInt();
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundations = scanner.next();

        App result = new App();
        return result.new Sections(nm, name, region, district, population, foundations);
    }

    public class Sections {
        String name, region, district, foundations;
        int population, num;

        public Sections(int nm, String n, String r, String d, int p, String f) {
            this.num = nm;
            this.name = n;
            this.region = r;
            this.district = d;
            this.population = p;
            this.foundations = f;
        }

        @Override
        public String toString() {
            return this.num + ": " + "Name = " + this.name + "; region = " + this.region + "; district = " + this.district + 
                "; population = " + this.population + "; foundation = " + this.foundations;
        }
    }
}
