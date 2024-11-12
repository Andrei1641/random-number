import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static JLabel rand = new JLabel("Random", SwingConstants.CENTER);
    public static ArrayList<Integer> randList = new ArrayList<>();
    public static JTextArea randTextArea = new JTextArea(5,20);
    private static int bisInt;
    private static int vonInt;
    private static int randInt;
    private static String[] ini;
    private static List<Integer> iniInt = new ArrayList<>(){};
    private static int randAusnahme;

    public static void main(String[] args) {



     JFrame frame = new JFrame();
     JTextField von = new JTextField(5);
     JTextField bis = new JTextField(5);
     GridBagLayout gridBagLayout = new GridBagLayout();
     GridBagConstraints gridBagConstraints = new GridBagConstraints();
     JLabel vonLabel = new JLabel("from");
     JTextField vonArea = new JTextField(5);
     JLabel bisLabel = new JLabel("to");
     JTextField bisArea = new JTextField(5);
     JButton randButton = new JButton("Start");
     JScrollPane jScrollPaneFrame = new JScrollPane(randTextArea);
     JButton ausnahme = new JButton("Exception");



        frame.setSize(400,400);
     frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     frame.setLayout(gridBagLayout);




gridBagConstraints.gridx = 0;
gridBagConstraints.gridy = 0;
gridBagConstraints.gridheight = 1;
gridBagConstraints.gridwidth = 1;
gridBagConstraints.fill = GridBagConstraints.BOTH;
        frame.add(vonLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;




        jScrollPaneFrame.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneFrame.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);



        randTextArea.setLineWrap(true);
        randTextArea.setWrapStyleWord(true);



        frame.add(vonArea, gridBagConstraints);



        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        frame.add(bisLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        frame.add(bisArea, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(20,0,0,0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        rand.setFont(new Font("Arial", Font.PLAIN, 20));

        frame.add(rand, gridBagConstraints);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(20,0,0,0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        frame.add(randButton,gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.insets = new Insets(10,0,10,0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        frame.add(ausnahme, gridBagConstraints);


        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.insets = new Insets(20,0,0,0);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        frame.add(jScrollPaneFrame, gridBagConstraints);

        vonArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = vonArea.getText();
                System.out.println(" " + text);
                try {
                    vonInt = Integer.parseInt(text);
                    System.out.println(vonInt);
                } catch (NumberFormatException exception) {

                    JOptionPane.showMessageDialog(null, "NumberFormatException", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateValue();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateValue();
            }
            private void updateValue() {
                String text = vonArea.getText();
                System.out.println(" " + text);
                try {
                    vonInt = Integer.parseInt(text);
                    System.out.println(vonInt);
                } catch (NumberFormatException exception) {


                }
            }
        });


        bisArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = bisArea.getText();
                System.out.println(" " + text);
                try {
                    bisInt = Integer.parseInt(text);
                    System.out.println(bisInt);

                } catch (NumberFormatException exception) {


                    JOptionPane.showMessageDialog(null, "NumberFormatException", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateValue();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateValue();
            }
            private void updateValue() {
                String text = bisArea.getText();
                System.out.println(" " + text);
                try {
                     bisInt = Integer.parseInt(text);
                    System.out.println(bisInt);

                } catch (NumberFormatException exception) {



                }
            }
        });

        randButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {

                    try {

                       randNum();

                    }catch (Exception exception){
                        JOptionPane error = new JOptionPane("Error");
                    }





               }catch (Exception exception){
                   System.out.println("No");
               }
            }
        });

        ausnahme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randAusnahme = randInt;
                randTextArea.append(" " + randAusnahme);

                randList.clear();
                iniInt.clear();

            }
        });






frame.setMinimumSize(new Dimension(300,400));

    von.setVisible(true);
    frame.setVisible(true);

        vonArea.requestFocusInWindow();


    }
    public static void randNum () {
        for (int i = vonInt; i <= bisInt; i++) {
            randList.add(i);
            System.out.println("ffff");
        }
        randInt = (int) (Math.random() * (bisInt - vonInt + 1) + vonInt);
        rand.setText("" + randInt);



        String textq = randTextArea.getText().replaceAll("^[ ,]+", "");
        ini = textq.split("[ ,]+");
        iniInt = java.util.Arrays.stream(ini)
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        randList.removeAll(iniInt);

        if (randList.isEmpty()) {
            rand.setText("Keine Zahlen");
            return;
        }

        if (iniInt.contains(randInt)) {
            System.out.println("noch mal");
            randList.clear();
            iniInt.clear();
            randNum();
        }


        for (int number : randList) {
            System.out.println(number);
        }
        randList.clear();
        iniInt.clear();

    }
    public static int getBis () {
        return bisInt;
    }
    public static int getVonIntBis () {
        return vonInt;
    }
    public static int getRandInt () {
        return randInt;
    }
    public static String[] getIni () {
        return ini;
    }
    public static List<Integer> getIniInt () {
        return iniInt;
    }
    public static int getRandAusnahme () {
        return randAusnahme;
    }
}


