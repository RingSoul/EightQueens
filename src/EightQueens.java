public class EightQueens {
    public static void main(String[] args) {
        queens(4);
    }

    // precondition: n >= 4
    public static void queens(int n)
    {
        String[][] result = new String[n][n];
        for (int r = 0; r < result.length; r++)
        {
            for (int c = 0; c < result[0].length; c++)
            {
                result[r][c] = "0";
            }
        }
        int[] which = new int[n];
        for (int i = 0; i < which.length; i++)
        {
            which[i] = 1;
        }
        for (int r = 0; r < result.length; r++)
        {
            for (int c = 0; c < result[0].length; c++)
            {
                if (result[r][c].equals("X") == false) {
                    result[r][c] = "Q";
                    // vertical
                    for (int r2 = r + 1; r2 < result.length; r2++) {
                        System.out.println("Vertical");
                        if (result[r2][c].equals("X") == false)
                            result[r2][c] = "X";
                    }
                    // horizontal
                    for (int c2 = c + 1; c2 < result[0].length; c2++) {
                        System.out.println("Horizontal");
                        if (result[r][c2].equals("X") == false)
                            result[r][c2] = "X";
                    }
                    // diagonal (4 separate paths possible)
                    int possibility = 0;
                    int r3 = r;
                    int c3 = c;
                    while (possibility < 4) {
                        System.out.println(possibility);
                        while (r3 < result.length && c3 < result[0].length && r3 > -1 && c3 > -1) {
                            if (possibility == 0) {
                                r3++;
                                c3++;
                            } else if (possibility == 1) {
                                r3--;
                                c3--;
                            } else if (possibility == 2) {
                                r3--;
                                c3++;
                            } else if (possibility == 3) {
                                r3++;
                                c--;
                            }
                            if (r3 != r && c3 != c && r3 != -1 && r3 != result.length && c3 != -1 && c3 != result[0].length) {
                                result[r3][c3] = "X";
                                System.out.println("Diagonal");
                            }
                        }
                        possibility++;
                    }
                }

            }
        }
        for (String[] list : result)
        {
            for (String grid : list)
            {
                System.out.print(grid + "  ");
            }
            System.out.println();
        }
    }
}