public class sTriangle{
    public static void drawSierpinski(int iterates, double a0, double a1, double b0, double b1, double c0, double c1) {

        double midAB0 = (a0 + b0) / 2;

        double midAB1 = (a1 + b1) / 2;

        double midAC0 = (a0 + c0) / 2;

        double midAC1 = (a1 + c1) / 2;

        double midBC0 = (b0 + c0) / 2;

        double midBC1 = (b1 + c1) / 2;

        if (iterates == 0) {

            //Draws Final Triangles
            StdDraw.line(a0, a1, b0, b1);

            StdDraw.line( b0, b1, c0, c1);

            StdDraw.line( c0, c1, a0, a1);

        } else {

            //Draws Intermediate Triangles
            StdDraw.line(a0, a1, b0, b1);

            StdDraw.line( b0, b1, c0, c1);

            StdDraw.line( c0, c1, a0, a1);

            //Iterates and Changes Colors of Triangles
            //In Other Words, Implements Recursion
            StdDraw.setPenColor(0, 255, 0);

            drawSierpinski(iterates - 1, a0, a1, midAB0, midAB1, midAC0, midAC1);

            StdDraw.setPenColor(75, 25, 255);

            drawSierpinski(iterates - 1, midAB0, midAB1, b0, b1, midBC0, midBC1);

            StdDraw.setPenColor(255, 0, 255);

            drawSierpinski(iterates - 1, midAC0, midAC1, midBC0, midBC1, c0, c1);

        }
    }


    public static void main(String[] args){

        //Parses Iterates
        int iterates = Integer.parseInt(args[0]);

        //Ensures Iterates Are Positive
        if (iterates < 0){

            System.out.println("Please enter a positive integer.");

            System.exit(1);

        }

        //Implements the Recursive Method
        sTriangle.drawSierpinski(iterates, 0, 0, .5, 1, 1, 0);

    }
}
