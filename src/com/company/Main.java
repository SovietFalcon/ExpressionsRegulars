package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {

        FileReader reader = new FileReader("C:\\Users\\I\\Desktop\\santako.txt");
        BufferedReader buffr = new BufferedReader(reader);

        int numparesNoel = 0;
        int numrens = 0;
        int numfullets = 0;

        Pattern pareNoel = Pattern.compile("\\*<]:-DOo");
        Pattern ren = Pattern.compile(">:o\\)");
        Pattern fullet = Pattern.compile("[^*]<]:-D");


        String text = buffr.readLine();
        String provant = "";

        while (text != null) {

            char[] textenchars = text.toCharArray();


            for (int i = 0; i < textenchars.length ; i++) {
                provant = provant + textenchars[i];

                Matcher matcherPareNoel = pareNoel.matcher(provant);
                Matcher matcherren = ren.matcher(provant);
                Matcher matcherfullet = fullet.matcher(provant);

                while (matcherPareNoel.find()) {
                    provant = "";
                    numparesNoel++;
                    break;
                }

                while (matcherren.find()) {
                    provant = "";
                    numrens++;
                    break;
                }

                while (matcherfullet.find()) {
                    provant = "";
                    numfullets++;
                    break;
                }

            }

            text = buffr.readLine();

            // SOUTS
            if (numparesNoel > 0) {
                System.out.print("Pare Noel (" + numparesNoel + ")  ");
            }
            if (numrens > 0) {
                System.out.print("Ren (" + numrens + ")  ");
            }
            if (numfullets > 0) {
                System.out.print("Fullet (" + numfullets + ")  ");
            }
            System.out.println();

            //Reinicialització de variables
            numparesNoel = 0;
            numrens = 0;
            numfullets = 0;
            provant = "";




        }







    }
}
