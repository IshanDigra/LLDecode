package Problems.HARD.Chess.ServiceImpl;

import Problems.HARD.Chess.Constant.Color;
import Problems.HARD.Chess.Exception.InvalidMoveException;
import Problems.HARD.Chess.Model.Board;
import Problems.HARD.Chess.Model.Move;
import Problems.HARD.Chess.Model.Pieces.King;
import Problems.HARD.Chess.Model.Player;
import Problems.HARD.Chess.Service.Piece;

import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private Player currentPlayer;

    public Game(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        board = new Board();
        currentPlayer = whitePlayer;
    }

    public void start() {
        // Game loop
        displayBoard();
        while (true) {
            System.out.println(currentPlayer.getColor() + "'s turn.");
            if (isKingInCheck(currentPlayer.getColor())) {
                if (isCheckmate(currentPlayer.getColor())) {
                    System.out.println("Checkmate! " + (currentPlayer == whitePlayer ? "Black" : "White") + " wins!");
                    return ;
                }
                System.out.println("Check!");
            } else if (isStalemate(currentPlayer.getColor())) {
                System.out.println("Stalemate! The game is a draw.");
                return ;
            }



            // Get move from the player
            Move move = getPlayerMove(currentPlayer);


            try {
                currentPlayer.makeMove(board, move);
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
                System.out.println("Try again!");
                displayBoard();
                continue;
            }

            // Switch to the next player
            switchTurn();
            displayBoard();
        }


    }

//    private boolean isGameOver() {
//
//    }

    private Move getPlayerMove(Player player) {
        // TODO: Implement logic to get a valid move from the player
        // For simplicity, let's assume the player enters the move via console input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source row: ");
        int sourceRow = scanner.nextInt();
        System.out.print("Enter source column: ");
        int sourceCol = scanner.nextInt();
        System.out.print("Enter destination row: ");
        int destRow = scanner.nextInt();
        System.out.print("Enter destination column: ");
        int destCol = scanner.nextInt();

        Piece piece = board.getPiece(sourceRow, sourceCol);
        if (piece == null || piece.getColor() != player.getColor()) {
            throw new IllegalArgumentException("Invalid piece selection!");
        }

        return new Move(piece, destRow, destCol);
    }

    private boolean isKingInCheck(Color color) {
        Piece kingSquare = findKingSquare(color);
        Color opponentColor = (color == Color.WHITE) ? Color.BLACK : Color.WHITE;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece square = board.getPiece(i, j);
                if (square!=null && square.getColor() == opponentColor) {
                    if (square.canMove(board, kingSquare.getRow(), kingSquare.getCol() )) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isCheckmate(Color color) {
        return isKingInCheck(color) && !hasLegalMoves(color);
    }

    private boolean isStalemate(Color color) {
        return !isKingInCheck(color) && !hasLegalMoves(color);
    }

    private boolean hasLegalMoves(Color color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece start = board.getPiece(i, j);
                if (start!=null && start.getColor() == color) {
                    for (int x = 0; x < 8; x++) {
                        for (int y = 0; y < 8; y++) {
                            Piece end = board.getPiece(x, y);
                            if (start.canMove(board, x, y)) {
                                // Simulate move
                                Piece capturedPiece = board.getPiece(x,y);
                                board.setPiece(x,y,start);
                                board.setPiece(start.getRow(),start.getCol(),null);

                                boolean kingInCheck = isKingInCheck(color);

                                // Undo move
                                board.setPiece(start.getRow(),start.getCol(),start);
                                board.setPiece(x,y,capturedPiece);

                                if (!kingInCheck) return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private Piece findKingSquare(Color color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece square = board.getPiece(i, j);
                if (square!=null && square instanceof King && square.getColor() == color) {
                  //  System.out.println("Yes");
                    return square;
                }
            }
        }
        return null;
    }

    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece == null) {
                    System.out.print(".  ");
                } else {
                    String symbol = piece.getClass().getSimpleName().substring(0, 2);
                    System.out.print((piece.getColor() == Color.WHITE ? symbol.toUpperCase() : symbol.toLowerCase()) + " ");
                }
            }
            System.out.println();
        }
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }
}
