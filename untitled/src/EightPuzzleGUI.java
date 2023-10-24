import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EightPuzzleGUI extends JFrame {
        private JPanel puzzlePanel;
        private JButton nextButton;
        private JButton backButton;
        private JLabel[][] tileLabels;
        private int stepIndex;
        private ArrayList<String> steps;

        public void showPath(ArrayList<String> steps) {
            this.steps = steps;
            this.stepIndex = 0;

            setTitle("8-Puzzle Game");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);


            puzzlePanel = new JPanel(new GridLayout(3, 3));
            tileLabels = new JLabel[3][3];


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tileLabels[i][j] = new JLabel();
                    tileLabels[i][j].setOpaque(true);
                    tileLabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                    tileLabels[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                    tileLabels[i][j].setBorder(new LineBorder(Color.BLACK, 3));
                    puzzlePanel.add(tileLabels[i][j]);
                }
            }


            nextButton = new JButton("Next \u2192");
            backButton = new JButton("\u2190 Back");


            nextButton.setForeground(Color.BLUE);
            nextButton.setFont(new Font("Arial", Font.BOLD, 16));
            backButton.setForeground(Color.RED);
            backButton.setFont(new Font("Arial", Font.BOLD, 16));


            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nextStep();
                }
            });

            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    previousStep();
                }
            });


            setLayout(new BorderLayout());
            puzzlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            add(puzzlePanel, BorderLayout.CENTER);
            add(nextButton, BorderLayout.EAST);
            add(backButton, BorderLayout.WEST);


            updateState();


            setVisible(true);
        }

        private void updateState() {
            String currentState = steps.get(stepIndex);


            for (int i = 0; i < 9; i++) {
                int row = i / 3;
                int col = i % 3;

                char tile = currentState.charAt(i);
                tileLabels[row][col].setText(tile=='0'? "":String.valueOf(tile));
                tileLabels[row][col].setBackground(tile == '0' ? Color.GRAY : Color.WHITE);
            }

            nextButton.setEnabled(stepIndex < steps.size() - 1);
            backButton.setEnabled(stepIndex > 0);
        }

        private void nextStep() {
            if (stepIndex < steps.size() - 1) {
                stepIndex++;
                updateState();
            }
        }

        private void previousStep() {
            if (stepIndex > 0) {
                stepIndex--;
                updateState();
            }
        }

//    public  void ShowGUI(String[] steps) {
//
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new EightPuzzleGUI(steps);
//            }
//        });
//    }
    }

