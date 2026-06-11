import java.util.Scanner;

public class DesafioFinal {

    // 1. Função exclusiva para LER os dados
    public static int[][] lerMatriz(Scanner sc) {
        int[][] m = new int[3][3];
        System.out.println("Preencha o Sudoku 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Posição [" + i + "][" + j + "]: ");
                m[i][j] = sc.nextInt();
            }
        }
        return m;
    }

    // 2. Função exclusiva para VALIDAR a regra do jogo
    public static boolean validarSudoku(int[][] m) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if ((i != x || j != y) && m[i][j] == m[x][y]) {
                            return false; // Se achar repetido, já retorna falso na hora
                        }
                    }
                }
            }
        }
        return true; // Se terminar os laços sem achar repetidos, é válido
    }

    // 3. Função exclusiva para MOSTRAR o resultado
    public static void mostrarResultado(boolean valido) {
        if (valido) {
            System.out.println("\nResultado: Sudoku VÁLIDO! (Sem números repetidos)");
        } else {
            System.out.println("\nResultado: Sudoku INVÁLIDO! (Existem números repetidos)");
        }
    }

    // O main agora fica limpo, elegante e só dita o fluxo do programa!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[][] sudoku = lerMatriz(sc);
        boolean ehValido = validarSudoku(sudoku);
        mostrarResultado(ehValido);
        
        sc.close();
    }
}