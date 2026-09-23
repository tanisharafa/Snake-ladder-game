/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maingame;

/**
 *
 * @author USER
 */

        
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MainGame extends JFrame {

    private JPanel boardPanel;
    private JLabel[] cells;

    private JLabel player1Label;
    private JLabel player2Label;
    private JLabel diceLabel;
    private JLabel turnLabel;
    private JLabel statusLabel;

    private JButton rollButton;
    private JButton resetButton;

    private Player player1;
    private Player player2;

    private Dice dice;
    private Board board;

    private boolean player1Turn = true;

    private HashMap<Integer, Integer> snakes =
            new HashMap<>();

    private HashMap<Integer, Integer> ladders =
            new HashMap<>();

    public MainGame() {

        player1 = new Player("Player 1");
        player2 = new Player("Player 2");

        dice = new Dice();
        board = new Board();

        createSnakeAndLadder();
        createGUI();

        setTitle("Snake and Ladder Game");

        setSize(
                1100,
                750
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void createSnakeAndLadder() {

        snakes.put(98, 12);
        snakes.put(89, 53);
        snakes.put(66, 45);
        snakes.put(54, 31);
        snakes.put(40, 3);

        ladders.put(4, 25);
        ladders.put(13, 46);
        ladders.put(33, 49);
        ladders.put(42, 63);
        ladders.put(50, 69);
    }

    private void createGUI() {

        setLayout(
                new BorderLayout(
                        10,
                        10
                )
        );

        JLabel title =
                new JLabel(
                        "SNAKE AND LADDER GAME",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28
                )
        );

        add(
                title,
                BorderLayout.NORTH
        );

        boardPanel = new JPanel();

        boardPanel.setLayout(
                new GridLayout(
                        10,
                        10
                )
        );

        cells = new JLabel[101];

        createBoard();

        add(
                boardPanel,
                BorderLayout.CENTER
        );

        JPanel controlPanel =
                new JPanel();

        controlPanel.setPreferredSize(
                new Dimension(
                        250,
                        600
                )
        );

        controlPanel.setLayout(
                new BoxLayout(
                        controlPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel gameInfo =
                new JLabel(
                        "GAME INFO"
                );

        gameInfo.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        gameInfo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        player1Label =
                new JLabel(
                        "Player 1 Position: 0"
                );

        player2Label =
                new JLabel(
                        "Player 2 Position: 0"
                );

        diceLabel =
                new JLabel(
                        "Dice Result: -"
                );

        turnLabel =
                new JLabel(
                        "Current Turn: Player 1"
                );

        statusLabel =
                new JLabel(
                        "Game Started"
                );

        rollButton =
                new JButton(
                        "ROLL DICE"
                );

        resetButton =
                new JButton(
                        "RESET GAME"
                );

        player1Label.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        player2Label.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        diceLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        turnLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        statusLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        rollButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        resetButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        controlPanel.add(
                gameInfo
        );

        controlPanel.add(
                Box.createVerticalStrut(30)
        );

        controlPanel.add(
                player1Label
        );

        controlPanel.add(
                Box.createVerticalStrut(15)
        );

        controlPanel.add(
                player2Label
        );

        controlPanel.add(
                Box.createVerticalStrut(30)
        );

        controlPanel.add(
                diceLabel
        );

        controlPanel.add(
                Box.createVerticalStrut(20)
        );

        controlPanel.add(
                rollButton
        );

        controlPanel.add(
                Box.createVerticalStrut(15)
        );

        controlPanel.add(
                resetButton
        );

        controlPanel.add(
                Box.createVerticalStrut(30)
        );

        controlPanel.add(
                turnLabel
        );

        controlPanel.add(
                Box.createVerticalStrut(20)
        );

        controlPanel.add(
                statusLabel
        );

        add(
                controlPanel,
                BorderLayout.EAST
        );

        rollButton.addActionListener(
                e -> rollDice()
        );

        resetButton.addActionListener(
                e -> resetGame()
        );
    }

    private void createBoard() {

        for (
                int row = 0;
                row < 10;
                row++
        ) {

            if (row % 2 == 0) {

                int start =
                        100 - (row * 10);

                int end =
                        start - 9;

                for (
                        int number = start;
                        number >= end;
                        number--
                ) {

                    addCell(number);
                }

            } else {

                int start =
                        100 - (row * 10) - 9;

                int end =
                        start + 9;

                for (
                        int number = start;
                        number <= end;
                        number++
                ) {

                    addCell(number);
                }
            }
        }
    }

    private void addCell(int number) {

        JLabel cell;

        if (ladders.containsKey(number)) {

            cell =
                    new LadderCell(
                            number,
                            ladders.get(number)
                    );

        } else {

            cell =
                    new JLabel(
                            "",
                            SwingConstants.CENTER
                    );
        }

        cell.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        cell.setBorder(
                BorderFactory.createLineBorder(
                        Color.BLACK,
                        1
                )
        );

        cell.setOpaque(true);

        cells[number] = cell;

        boardPanel.add(cell);

        updateCell(number);
    }

    private void updateCell(int number) {

        if (ladders.containsKey(number)) {

            LadderCell cell =
                    (LadderCell) cells[number];

            cell.setPlayer1(
                    player1.getPosition()
                            == number
            );

            cell.setPlayer2(
                    player2.getPosition()
                            == number
            );

            cell.setBackground(
                    new Color(
                            180,
                            230,
                            180
                    )
            );

            cell.repaint();

            return;
        }

        String text =
                "<html><center>"
                + number;

        if (snakes.containsKey(number)) {

            text +=
                    "<br>🐍 "
                    + snakes.get(number);
        }

        if (
                player1.getPosition()
                        == number
        ) {

            text +=
                    "<br>🔴 P1";
        }

        if (
                player2.getPosition()
                        == number
        ) {

            text +=
                    "<br>🔵 P2";
        }

        text +=
                "</center></html>";

        cells[number].setText(text);

        if (snakes.containsKey(number)) {

            cells[number].setBackground(
                    new Color(
                            240,
                            180,
                            180
                    )
            );

        } else {

            cells[number].setBackground(
                    new Color(
                            235,
                            235,
                            235
                    )
            );
        }
    }

    private void updateBoard() {

        for (
                int i = 1;
                i <= 100;
                i++
        ) {

            updateCell(i);
        }
    }

    private void rollDice() {

        int diceValue =
                dice.rollDice();

        diceLabel.setText(
                "Dice Result: "
                + diceValue
        );

        Player currentPlayer;

        if (player1Turn) {

            currentPlayer =
                    player1;

        } else {

            currentPlayer =
                    player2;
        }

        int oldPosition =
                currentPlayer.getPosition();

        int newPosition =
                oldPosition + diceValue;

        if (newPosition > 100) {

            statusLabel.setText(
                    currentPlayer.getName()
                    + " cannot move."
            );

            changeTurn();

            return;
        }

        currentPlayer.setPosition(
                newPosition
        );

        updateLabels();
        updateBoard();

        if (ladders.containsKey(newPosition)) {

            int ladderPosition =
                    ladders.get(
                            newPosition
                    );

            currentPlayer.setPosition(
                    ladderPosition
            );

            updateLabels();
            updateBoard();

            statusLabel.setText(
                    currentPlayer.getName()
                    + " climbed the ladder to "
                    + ladderPosition
            );

        } else if (
                snakes.containsKey(newPosition)
        ) {

            int snakePosition =
                    snakes.get(
                            newPosition
                    );

            currentPlayer.setPosition(
                    snakePosition
            );

            updateLabels();
            updateBoard();

            statusLabel.setText(
                    currentPlayer.getName()
                    + " went down the snake to "
                    + snakePosition
            );

        } else {

            statusLabel.setText(
                    currentPlayer.getName()
                    + " moved to "
                    + newPosition
            );
        }

        if (
                currentPlayer.getPosition()
                        == 100
        ) {

            JOptionPane.showMessageDialog(
                    this,
                    currentPlayer.getName()
                    + " Wins!",
                    "Game Over",
                    JOptionPane.INFORMATION_MESSAGE
            );

            rollButton.setEnabled(
                    false
            );

            return;
        }

        changeTurn();
    }

    private void changeTurn() {

        player1Turn =
                !player1Turn;

        if (player1Turn) {

            turnLabel.setText(
                    "Current Turn: Player 1"
            );

        } else {

            turnLabel.setText(
                    "Current Turn: Player 2"
            );
        }
    }

    private void updateLabels() {

        player1Label.setText(
                "Player 1 Position: "
                + player1.getPosition()
        );

        player2Label.setText(
                "Player 2 Position: "
                + player2.getPosition()
        );
    }

    private void resetGame() {

        player1.reset();
        player2.reset();

        player1Turn = true;

        diceLabel.setText(
                "Dice Result: -"
        );

        turnLabel.setText(
                "Current Turn: Player 1"
        );

        statusLabel.setText(
                "Game Restarted"
        );

        updateLabels();
        updateBoard();

        rollButton.setEnabled(
                true
        );
    }

    private class LadderCell extends JLabel {

    private int number;
    private int destination;

    private boolean player1Here = false;
    private boolean player2Here = false;

    public LadderCell(
            int number,
            int destination
    ) {

        this.number = number;
        this.destination = destination;

        setOpaque(true);

        setHorizontalAlignment(
                SwingConstants.CENTER
        );
    }

    public void setPlayer1(
            boolean value
    ) {

        player1Here = value;
    }

    public void setPlayer2(
            boolean value
    ) {

        player2Here = value;
    }

    @Override
    protected void paintComponent(
            Graphics g
    ) {

        super.paintComponent(g);

        Graphics2D g2 =
                (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int width = getWidth();
        int height = getHeight();

        /* TOP NUMBER */

        g2.setColor(Color.BLACK);

        g2.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        String topNumber =
                String.valueOf(number);

        int topWidth =
                g2.getFontMetrics()
                        .stringWidth(topNumber);

        g2.drawString(
                topNumber,
                (width - topWidth) / 2,
                15
        );

        /* LADDER */

        int ladderWidth = 20;
        int ladderHeight = 38;

        int ladderLeft =
                (width - ladderWidth) / 2;

        int ladderTop = 20;

        int ladderRight =
                ladderLeft + ladderWidth;

        int ladderBottom =
                ladderTop + ladderHeight;

        g2.setColor(
                new Color(
                        120,
                        70,
                        25
                )
        );

        g2.setStroke(
                new BasicStroke(
                        2.5f,
                        BasicStroke.CAP_ROUND,
                        BasicStroke.JOIN_ROUND
                )
        );

        /* LEFT SIDE */

        g2.drawLine(
                ladderLeft,
                ladderTop,
                ladderLeft,
                ladderBottom
        );

        /* RIGHT SIDE */

        g2.drawLine(
                ladderRight,
                ladderTop,
                ladderRight,
                ladderBottom
        );

        /* LADDER STEPS */

        int stepCount = 6;

        for (
                int i = 1;
                i <= stepCount;
                i++
        ) {

            int y =
                    ladderTop
                    + (i * ladderHeight)
                    / (stepCount + 1);

            g2.drawLine(
                    ladderLeft,
                    y,
                    ladderRight,
                    y
            );
        }

        /* BOTTOM NUMBER */

        g2.setColor(Color.BLACK);

        g2.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        String bottomNumber =
                String.valueOf(destination);

        int bottomWidth =
                g2.getFontMetrics()
                        .stringWidth(
                                bottomNumber
                        );

        g2.drawString(
                bottomNumber,
                (width - bottomWidth) / 2,
                height - 7
        );

        /* PLAYER 1 */

        if (player1Here) {

            g2.setColor(Color.RED);

            g2.fillOval(
                    3,
                    height / 2 - 5,
                    10,
                    10
            );

            g2.setColor(Color.BLACK);

            g2.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            8
                    )
            );

            g2.drawString(
                    "P1",
                    1,
                    height / 2 + 15
            );
        }

        /* PLAYER 2 */

        if (player2Here) {

            g2.setColor(Color.BLUE);

            g2.fillOval(
                    width - 13,
                    height / 2 - 5,
                    10,
                    10
            );

            g2.setColor(Color.BLACK);

            g2.setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            8
                    )
            );

            g2.drawString(
                    "P2",
                    width - 15,
                    height / 2 + 15
            );
        }

        g2.dispose();
    }
}
    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new MainGame()
        );
    }
}

