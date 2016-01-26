package com.company.other;

import static com.company.other.HorseStepsCount.Position.*;

/**
 * Created by fertkir on 26.01.16.
 */
public class HorseStepsCount {

    public static void main(String[] args) {
        System.out.println(new HorseStepsCount(C3, D8).get());
    }

    private static final int[] STEP_I = { 1, 2, -1, -2,  1,  2, -1, -2 };
    private static final int[] STEP_J = { 2, 1, -2, -1, -2, -1,  2,  1 };

    public enum Position {
        A1(0,0), A2(0,1), A3(0,2), A4(0,3), A5(0,4), A6(0,5), A7(0,6), A8(0,7),
        B1(1,0), B2(1,1), B3(1,2), B4(1,3), B5(1,4), B6(1,5), B7(1,6), B8(1,7),
        C1(2,0), C2(2,1), C3(2,2), C4(2,3), C5(2,4), C6(2,5), C7(2,6), C8(2,7),
        D1(3,0), D2(3,1), D3(3,2), D4(3,3), D5(3,4), D6(3,5), D7(3,6), D8(3,7),
        E1(4,0), E2(4,1), E3(4,2), E4(4,3), E5(4,4), E6(4,5), E7(4,6), E8(4,7),
        F1(5,0), F2(5,1), F3(5,2), F4(5,3), F5(5,4), F6(5,5), F7(5,6), F8(5,7),
        G1(6,0), G2(6,1), G3(6,2), G4(6,3), G5(6,4), G6(6,5), G7(6,6), G8(6,7),
        H1(7,0), H2(7,1), H3(7,2), H4(7,3), H5(7,4), H6(7,5), H7(7,6), H8(7,7);

        private int i;
        private int j;

        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private Position pos1;

    private int diffI;
    private int diffJ;

    public HorseStepsCount(Position pos1, Position pos2) {
        this.pos1 = pos1;
        this.diffI = pos2.i - pos1.i;
        this.diffJ = pos2.j - pos1.j;
    }

    public int get() {
        int steps = -1;
        while (!method(++steps, 0, 0));
        return steps;
    }

    private boolean method(int loops, int sumI, int sumJ) {
        if (loops == 0) {
            return sumI == diffI && sumJ == diffJ;
        }
        for (int k = 0; k < STEP_I.length; k++) {
            int newSumI = sumI + STEP_I[k];
            int newSumJ = sumJ + STEP_J[k];
            if ((pos1.i + newSumI) > 7 || (pos1.i + newSumI) < 0 || (pos1.j + newSumJ) > 7 || (pos1.j + newSumJ) < 0) {
                continue;
            }
            if (method(loops - 1, newSumI, newSumJ)) {
                return true;
            }
        }
        return false;
    }
}
