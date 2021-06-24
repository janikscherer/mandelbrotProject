package model;

import java.util.ArrayList;

public enum JuliaSet {
    MANDELBROT("Mandelbrot"),
    FIRSTFRACTAL("c = 0 + 0.8i"),
    SECONDFRACTAL("c = 0.37 + 0.1i"),
    THIRDFRACTAL("c = 0.355 + 0.355i"),
    FOURTHFRACTAL("c = -0.54 + 0.54i"),
    FIFTHFRACTAL("c = -0.4 + -0.59i"),
    SIXTHFRACTAL(" 0.34 + -0.05i"),
    SEVENTHFRACTAL("c = -0.4 + -0.59i");

    private String name;

    JuliaSet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static String[] allJuliaSets(){
        ArrayList<String> allJuliaSets = new ArrayList<>();
        for( JuliaSet thisJuliaSet : JuliaSet.values()){
            allJuliaSets.add(thisJuliaSet.toString());
        }
        String[] allJuliaSetsArr = new String[allJuliaSets.size()];
        allJuliaSetsArr = allJuliaSets.toArray(allJuliaSetsArr);
        return allJuliaSetsArr;
    }
    public static JuliaSet juliaSetFromString(String input){
        for(JuliaSet thisJuliaSet : JuliaSet.values()){
            if(thisJuliaSet.toString().equals(input)){
                return thisJuliaSet;
            }
        }
        return null;
    }
}
