package ru.addressbook.tests;

/**
 * Created by Naum.Ginzburg on 31.08.2017.
 */
public class TestPiraty {
    public static void main(String[] args) {
        // Объявим коснтанту для размера массива
        int SIZE = 3;
        int coin = 15; // Количество монет
        int[][] onePlan = {
                {8, 7, 9},
                {7, 8, 0},
                {0, 0, 6}
        };
        int[] plans = new int[SIZE];  // Выбранные планы (человеком i)
        int[] selectionNu = new int[SIZE]; //количество проголосовавших за план j
        int[] finPlanVol = new int[SIZE]; // Кому сколько
        int finPlan; //Выбранный большинством план (-1 - ни один)
        int maxvalplan;
        for (int i = 0; i < SIZE; i++) {
            plans[i] = 0;
            selectionNu[i] = 0;
        }
        for (int i = 0; i < SIZE; i++) {
            maxvalplan = 0;
            for (int j = 0; j < SIZE; j++) {
                if (onePlan[i][j] > maxvalplan) {
                    plans[i] = j;
                    maxvalplan = onePlan[i][j];
                }
            }
            selectionNu[plans[i]] = selectionNu[plans[i]] + 1;
        }

//        System.out.println("plans " + plans);
//        for (int i = 0; i < SIZE; i++) {
//            System.out.println(plans[i]);
//        }
//        System.out.println("selectionNu" + selectionNu);
//        for (int i = 0; i < SIZE; i++) {
//            System.out.println(selectionNu[i]);
//        }

        System.out.println("Исходные данные для голосования");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf(onePlan[i][j] + " ");
            }
            System.out.println();
        }

        finPlan = -1;
        for (int i = 0; i < SIZE; i++) {
            if (selectionNu[i] > 1) {
                finPlan = i;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            if (finPlan >= 0) {
                finPlanVol[i] = onePlan[i][finPlan];
            } else
                finPlanVol[i] = 0;
        }
        System.out.println("План "+ finPlan + " Результаты " + finPlanVol[0] + " " + finPlanVol[1] + " " + finPlanVol[2] + " ");
        System.out.println();
    }
}
