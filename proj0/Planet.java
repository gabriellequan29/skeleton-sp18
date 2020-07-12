import java.util.concurrent.LinkedTransferQueue;

public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xxPods, double yyPods, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPods;
        this.yyPos = yyPods;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double r = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return r;
    }

    public double calcForceExertedBy(Planet p) {
        final double G = 6.67e-11;
        double r = this.calcDistance(p);
        double F = (G * this.mass * p.mass) / Math.pow(r, 2);
        return F;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double dx;
        double Fx;
        double sum = 0;
        for (Planet p : planets) {
            if (this.equals(p)) {
                continue;
            }
            dx = p.xxPos - this.xxPos;
            Fx = this.calcForceExertedBy(p) * dx / this.calcDistance(p);
            sum += Fx;
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double dy;
        double Fy;
        double sum = 0;
        for (Planet p : planets) {
            if (this.equals(p)) {
                continue;
            }
            dy = p.yyPos - this.yyPos;
            Fy = this.calcForceExertedBy(p) * dy / this.calcDistance(p);
            sum += Fy;
        }
        return sum;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel = this.xxVel + ax * dt;
        this.yyVel = this.yyVel + ay * dt;
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;
    }

    public void draw() {
        // StdDraw.clear();
        StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
        StdDraw.show();
    }
}
