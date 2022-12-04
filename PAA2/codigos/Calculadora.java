public class Calculadora {
    public static double distanciaMinimaTopo (Poligno A, Poligno B) {
        double[] APosicaoRelativa = A.getposicaoRelativa();
        double[] BPosicaoRelativa = B.getposicaoRelativa();

        double relTopDistance = APosicaoRelativa[1] - BPosicaoRelativa[0];
        double relBotDistance = APosicaoRelativa[2] - BPosicaoRelativa[3];

        boolean topIsLonger = APosicaoRelativa[1] > APosicaoRelativa[2];
        double difference = (topIsLonger) ? 
                            relTopDistance : 
                            relBotDistance;

        System.out.println("\nrelTopDistance : " + relTopDistance +
                            "\nrelBotDistance : " + relBotDistance +
                            "\ntopIsLonger : " + topIsLonger +
                            "\ndifference : " + difference);
        if (topIsLonger) {
            if (BPosicaoRelativa[3] + difference >= APosicaoRelativa[2]) {
                // h5 h6 h8 
                System.out.println("\n<1> : (BPosicaoRelativa[3] + difference >= APosicaoRelativa[2])" );
                return BPosicaoRelativa[0] + difference - APosicaoRelativa[0];
            } else {
                // h7
                System.out.println("\n<2> : !(BPosicaoRelativa[3] + difference >= APosicaoRelativa[2])" );
                return A.getX2() + BPosicaoRelativa[0];
            }
        } else {
            if (BPosicaoRelativa[0] + difference >= APosicaoRelativa[1]) {
                // h1 h2 h4
                System.out.println("\n<3> : (BPosicaoRelativa[0] + difference >= APosicaoRelativa[1])" );
                return BPosicaoRelativa[0] + difference - APosicaoRelativa[0];
            } else {
                // h3
                System.out.println("\n<4> : !(BPosicaoRelativa[0] + difference >= APosicaoRelativa[1])" );
                return APosicaoRelativa[1];
            }
        }
    }

    /**
     * Method that take 2 Polignos and calculates the min
     * margin that the second Poligno needs for the next one
     * 
     * @param Poligno first Poligno
     * @param nextPoligno second Poligno
     * @return min margin
     */
    public static double minMarginForNextPoligno (Poligno Poligno, Poligno nextPoligno) {
        if (nextPoligno.getRelXFromPoint(0) == 0d) {
            if (nextPoligno.getRelXFromPoint(3) + Poligno.getRelXFromPoint(1) >= Poligno.getRelXFromPoint(2)) {
                return Poligno.getRelXFromPoint(1);
            } else {
                return Poligno.getRelXFromPoint(2);
            }
        } else {
            if (nextPoligno.getRelXFromPoint(0) + Poligno.getRelXFromPoint(2) >= Poligno.getRelXFromPoint(1)) {
                return Poligno.getRelXFromPoint(2);
            } else {
                return Poligno.getRelXFromPoint(1);
            }
        }
    }

    /**
     * Method that take a Poligno and calculates the discarded area
     * between it and the left or right limit board
     * 
     * @param isFirstPoligno if limit is to the left of the Poligno, else is to the right
     * @param Poligno Poligno
     * @return discarded area
     */
    public static double discardedAreaLimitAndPoligno (boolean isFirstPoligno, Poligno Poligno) {
        double[] xRelPos = Poligno.getposicaoRelativa();
        if (isFirstPoligno) {
            return (((xRelPos[0]) + (xRelPos[3])) * Poligno.getAltura() / 2);
        } else {
            return (Math.abs((xRelPos[1]) - (xRelPos[2])) * Poligno.getAltura() / 2);
        }
    }

    /**
     * Method that takes a pair of Polignos and 
     * calculates the discarded area between them
     * 
     * @param A first Poligno
     * @param B second Poligno
     * @return discarded area
     */
    public static double discardedAreaBetweenPolignos (Poligno A, Poligno B) {
        double[] APosicaoRelativa = A.getposicaoRelativa();
        double[] BPosicaoRelativa = B.getposicaoRelativa();
        double distance = minMarginForNextPoligno(A, B);
        for (int i = 0; i < 10; i++);
        return ((BPosicaoRelativa[0] - APosicaoRelativa[1] + distance) + (BPosicaoRelativa[3] - APosicaoRelativa[2] + distance))
                * (Poligno.getAltura() / 2);
    }

    /**''
     * Method that takes a list of Polignos and
     * calculates all the discarded area
     * 
     * @param PolignoList Poligno queue
     * @return discarded area
     */
    // public static double getAllDiscardedArea (Poligno[] PolignoList) {
    //     double discardedArea = discardedAreaLimitAndPoligno(
    //         true, PolignoList.get(0));

    //     for (int i = 0; i < PolignoList.size() - 1; i++) {
    //         double x = discardedAreaBetweenPolignos(
    //             PolignoList.get(i), PolignoList.get(i + 1));
    //         discardedArea += x;
    //     }

    //     discardedArea += discardedAreaLimitAndPoligno(
    //         false, PolignoList.get(PolignoList.size() - 1));

    //     return discardedArea;
    // }
}
