public class Poligno {
    private double x1;
    private double x2;
    private double x3;

    public static double altura = 100;

    private double[] posicaoRelativa = new double[4];
    //================[construtor]====================
    public Poligno(double x1, double x3, double x2) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;

        System.out.println("TXT : "+ x1 +" "+ x3 +" "+ x2 +" \nx1: "+ x1 + " x2: "+ x2 + " x3 :" + x3);

        if (x3 < 0) {
            // System.out.println(" ENTRA IF X3 < 0");
            posicaoRelativa[0] = Math.abs(x3);
            posicaoRelativa[1] = Math.abs(x3) + x1;
            posicaoRelativa[2] = x2 - x3;
            posicaoRelativa[3] = 0;
            System.out.println("POSIÇÃO RELATIVA P1: ["+ posicaoRelativa[0] + "] P2: ["+ posicaoRelativa[1] + "] P3 : [" + posicaoRelativa[2] + "] P4: [" +  posicaoRelativa[3]+"]\n");
        } else {
            // System.out.println(" NÃO ENTRA IF X3 < 0 (X3>=0)");
            posicaoRelativa[0] = 0;
            posicaoRelativa[1] = x1;
            posicaoRelativa[2] = x2;
            posicaoRelativa[3] = x3;
            System.out.println("POSIÇÃO RELATIVA P1: ["+ posicaoRelativa[0] + "] P2: ["+ posicaoRelativa[1] + "] P3 : [" + posicaoRelativa[2] + "] P4: [" +  posicaoRelativa[3]+"]\n");
        }
    }
    //================================================

    //=============GET=============
    public double getX1() {
        return x1;
    }
    public double getX2() {
        return x2;
    }
    public double getX3() {
        return x3;
    }
    public static double getAltura() {
        return altura;
    }
    public double[] getposicaoRelativa(){
        return this.posicaoRelativa;
    }
    public double getRelXFromPoint(int index) {
        return posicaoRelativa[index];
    }
    //=============================

    //=============SET=============
    public void setX1(double x1) {
        this.x1 = x1;
    }
    public void setX2(double x2) {
        this.x2 = x2;
    }
    public void setX3(double x3) {
        this.x3 = x3;
    }
    //=============================
    
    public double area(){
        double topo = posicaoRelativa[1] - posicaoRelativa[0];
        double base = posicaoRelativa[2] - posicaoRelativa[3];
        System.out.println("topo: " + topo + "base: " + base);
        return ( (topo+base) * (altura) / 2);
    }

    public void printp() {
        System.out.println("x1 ("+getX1()+") x2 ("+getX2()+") x3 ("+getX3()+")");
        System.out.println("Posicao relativa: ["+posicaoRelativa[0]+"] ["+posicaoRelativa[1]+"] ["+posicaoRelativa[2]+"] ["+posicaoRelativa[3]+"]\n");
        System.out.println(area());
    }
}
