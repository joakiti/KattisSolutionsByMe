import java.util.ArrayList;
import java.util.Scanner;

public class Tetris {

    static String test = "4 4\n" +
            "2 1 1 1\n";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int columns = s.nextInt();
        int pieceId = s.nextInt();

        Piece piece = new Piece(pieceId);

        int[] board = new int[columns];

        parseBoardInput(s, columns, board);
        int ans = 0;
        for (int i = 0; i < piece.possibleRotations.size(); i++) {
            int[] chosenPiece = piece.possibleRotations.get(i);
            ans += findPossiblePlacements(chosenPiece, board);
        }
        System.out.println(ans);

    }

    /**
     * We greedily place each piece at position from i = 0, to last possible fitting space.
     * Once placed, we assert that the placement is still plane. We do this, by considering a difference in heights.
     * The first parameter, diff suggests the difference in height that the rest of the placement must adhere to.
     * @param chosenPiece
     * @param board
     * @return
     */
    private static int findPossiblePlacements(int[] chosenPiece, int[] board) {
        int placementsFound = 0;
        for (int i = 0; i < board.length - chosenPiece.length + 1; i++) {
            boolean canFitWithoutHoles = true;
            int placement = board[i];
            int diff = placement - chosenPiece[0];
            for (int j = 1; j < chosenPiece.length; j++) {
                if (diff != board[i + j] - chosenPiece[j]) {
                    canFitWithoutHoles = false;
                    break;
                }
            }
            if (canFitWithoutHoles) {
                placementsFound++;
            }
        }
        return placementsFound;
    }

    private static void parseBoardInput(Scanner s, int columns, int[] board) {
        for (int i = 0; i < columns; i++) {
            board[i] = s.nextInt();
        }
    }
}

class Piece {
    ArrayList<int[]> possibleRotations;

    final static int ZERO_ABOVE_FLOOR = 0;
    final static int ONE_ABOVE_FLOOR = 1;
    final static int TWO_ABOVE_FLOOR = 2;


    /**
     * PieceID identifies a piece from 1-9. For each piece, we code the possible rotations. We are only interested in the bottom part of the piece, thus we only code where the bottom part touches.
     * 0 means the piece is on the ground, 1 means the piece is one above the ground, etc.
     *
     * @param pieceId
     */
    Piece(int pieceId) {
        possibleRotations = new ArrayList<>();
        switch (pieceId) {
            case 1: {
                generateFourTilePieceRotations();
                break;
            }
            case 2: {
                generateSquarePieceRotations();
                break;
            }
            case 3: {
                generateZiggyPieceRotations();
                break;
            }
            case 4: {
                generateZiggyPieceRotationsInverse();
                break;
            }
            case 5: {
                generateTPieceRotations();
                break;
            }
            case 6: {
                generateLPieceRotations();
                break;
            }
            case 7: {
                generateLPieceRotationsInverse();
                break;
            }
        }
    }

    private void generateLPieceRotationsInverse() {
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                ONE_ABOVE_FLOOR,
                ONE_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                TWO_ABOVE_FLOOR
        });
    }

    private void generateLPieceRotations() {
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                TWO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ONE_ABOVE_FLOOR,
                ONE_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
    }

    private void generateTPieceRotations() {
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ONE_ABOVE_FLOOR,
        });
        possibleRotations.add(new int[]{
                ONE_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR,
                ONE_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                ONE_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
    }

    private void generateZiggyPieceRotationsInverse() {
        possibleRotations.add(new int[]{
                ONE_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ONE_ABOVE_FLOOR
        });
    }

    private void generateZiggyPieceRotations() {
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR,
                ONE_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                ONE_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
    }

    private void generateSquarePieceRotations() {
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
    }

    private void generateFourTilePieceRotations() {
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR
        });
        possibleRotations.add(new int[]{
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR,
                ZERO_ABOVE_FLOOR
        });
    }
}
