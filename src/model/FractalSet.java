package model;

import java.util.ArrayList;

public enum FractalSet {
    MANDELBROT("Mandelbrot"),
    FIRSTFRACTAL("c = 0 + 0.8i"),
    SECONDFRACTAL("c = 0.37 + 0.1i"),
    THIRDFRACTAL("c = 0.355 + 0.355i"),
    FOURTHFRACTAL("c = -0.54 + 0.54i"),
    FIFTHFRACTAL("c = -0.4 + -0.59i"),
    SIXTHFRACTAL(" 0.34 + -0.05i"),
    SEVENTHFRACTAL("c = -0.4 + -0.59i");

    private String name;

    FractalSet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static String[] allJuliaSets(){
        ArrayList<String> allJuliaSets = new ArrayList<>();
        for( FractalSet thisFractalSet : FractalSet.values()){
            allJuliaSets.add(thisFractalSet.toString());
        }
        String[] allJuliaSetsArr = new String[allJuliaSets.size()];
        allJuliaSetsArr = allJuliaSets.toArray(allJuliaSetsArr);
        return allJuliaSetsArr;
    }
    public static FractalSet juliaSetFromString(String input){
        for(FractalSet thisFractalSet : FractalSet.values()){
            if(thisFractalSet.toString().equals(input)){
                return thisFractalSet;
            }
        }
        return null;
    }
}
