public class NBody {

    public static double readRadius(String filename) {
        In in = new In(filename);
        int number = in.readInt();
        double r = in.readDouble();
        return r;
    }


    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        Planet[] planets = new Planet[5];
        int number = in.readInt();
        double r = in.readDouble();
        for (int i = 0; i < 5; i++) {
            double xx = in.readDouble();
            double yy = in.readDouble();
            double xxV = in.readDouble();
            double yyV = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xx, yy, xxV, yyV, mass, img);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double r = readRadius(filename);

        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-r, r);
/*        StdDraw.picture(0, 0, imageToDraw);
        StdDraw.show();

        for (Planet p : planets) {
            p.draw();
        }*/

        StdDraw.enableDoubleBuffering();

        for (int t = 0; t < T; t += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int j = 0; j < planets.length; j++) {
                xForces[j] = planets[j].calcNetForceExertedByX(planets);
                yForces[j] = planets[j].calcNetForceExertedByY(planets);
            }
            for (int k = 0; k < planets.length; k++) {
                planets[k].update(dt, xForces[k], yForces[k]);
            }

            // Draw the background
            StdDraw.picture(0, 0, imageToDraw);

            // Draw the planets
            for (Planet p : planets) {
                p.draw();
            }

            // Show
            StdDraw.show();
            StdDraw.pause(10);
            }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}

