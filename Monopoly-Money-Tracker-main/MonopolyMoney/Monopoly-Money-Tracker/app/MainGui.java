package app;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;

public class MainGui extends JFrame
{
    JTextArea player1;
    JTextArea p1Money;
    private JButton p1Add;
    private JButton p1Sub;
    private JButton p1Trans;
    private JButton p1Set;
    JTextArea player2;
    JTextArea p2Money;
    private JButton p2Add;
    private JButton p2Sub;
    private JButton p2Trans;
    private JButton p2Set;
    JTextArea player3;
    JTextArea p3Money;
    private JButton p3Add;
    private JButton p3Sub;
    private JButton p3Trans;
    private JButton p3Set;
    JTextArea player4;
    JTextArea p4Money;
    private JButton p4Add;
    private JButton p4Sub;
    private JButton p4Trans;
    private JButton p4Set;
    private JTextPane P1Text;
    private JTextPane P2Text;
    private JTextPane P3Text;
    private JTextPane P4Text;
    private JTextPane MoneyText;
    private JTextPane MoneyText2;
    private JTextPane MoneyText3;
    private JTextPane MoneyText4;
    private JTextArea CharacterDescrip;
    private JTextArea CharacterDescrip2;
    private JTextArea CharacterDescrip3;
    private JTextArea CharacterDescrip4;
    private JTextPane times;
    private JTextPane txtSides;
    private JButton RollDice;
    private JTextArea NoteBox;
    private JScrollPane NoteBoxSP;
    private JTextPane NotePane;
    JTextPane RollNum;
    JTextPane RollSides;
    
    public MainGui() {
        this.setFont(new Font("Times New Roman", 1, 14));
        this.setTitle("Monopoly Money Tracker");
        this.setSize(630, 425);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        Color bgclr = new Color(152,251,152); //lightgreen
        Color dgc = new Color(0,100,0); //dRKGREEN
        this.getContentPane().setBackground(bgclr);
        this.setBackground(Color.RED);
        this.getContentPane().setLayout(null);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
            System.exit(1);
        }
        catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            System.exit(1);
        }
        catch (InstantiationException e3) {
            e3.printStackTrace();
            System.exit(1);
        }
        catch (IllegalAccessException e4) {
            e4.printStackTrace();
            System.exit(1);
        }
        (this.player1 = new JTextArea()).setToolTipText("<html>This field holds the name of the first player.</html>");
        this.player1.setBounds(10, 30, 300, 20);
        this.player1.setFont(new Font("Times New Roman", 1, 14));
        Color clr = new Color(255,255,191);
        this.player1.setBackground(clr);
        this.player1.setText("Player 1");
        this.player1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                MainGui.this.player1.setText("");
            }
        });
        this.getContentPane().add(this.player1);
        (this.p1Money = new JTextArea()).setToolTipText("<html>This field holds the value of the first player's money.\r\n<br> This can only be changed with the \"Add\", \"Subtract\", \"Transfer\", and \"Set\" <br>buttons.</html>");
        this.p1Money.setForeground(Color.WHITE);
        this.p1Money.setBounds(320, 30, 80, 20);
        this.p1Money.setEditable(false);
        this.p1Money.setFont(new Font("Times New Roman", 1, 14));
        this.p1Money.setBackground(dgc);
        this.p1Money.setText("0");
        this.getContentPane().add(this.p1Money);
        (this.p1Add = new JButton("Receive")).setToolTipText("<html>This button will add the value input with the first player's money.</html>");
        this.p1Add.setBounds(20, 60, 90, 20);
        this.p1Add.setFont(new Font("Times New Roman", 0, 15));
        this.p1Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String addValue = MainGui.this.inputBox("How much would you like to add to " + MainGui.this.p1Money.getText() + "?");
                try {
                    MainGui.this.addButton(e, MainGui.this.p1Money, Integer.parseInt(addValue));
                }
                catch (NumberFormatException ex) {
                    MainGui.this.error("That is not a number!");
                }
            }
        });
        this.getContentPane().add(this.p1Add);
        (this.p1Sub = new JButton("Pay")).setToolTipText("<html>This button will subtract the value input from the first player's money.</html>");
        this.p1Sub.setBounds(120, 60, 90, 20);
        this.p1Sub.setFont(new Font("Times New Roman", 0, 15));
        this.p1Sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String subValue = MainGui.this.inputBox("How much would you like to subtract from " + MainGui.this.p1Money.getText() + "?");
                try {
                    MainGui.this.subButton(e, MainGui.this.p1Money, Integer.parseInt(subValue));
                }
                catch (NumberFormatException ex) {
                    MainGui.this.error("That is not a number!");
                }
            }
        });
        this.getContentPane().add(this.p1Sub);
        (this.p1Trans = new JButton("Transfer")).setToolTipText("<html>This button will give the input player an input ammount of dollars.<br> The value input will be added to the input player's money and<br>subtracted from the first player's money.</html>");
        this.p1Trans.setBounds(220, 60, 90, 20);
        this.p1Trans.setFont(new Font("Times New Roman", 0, 15));
        this.p1Trans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MainGui.this.transButton(e, MainGui.this.p1Money);
            }
        });
        this.getContentPane().add(this.p1Trans);
        (this.p1Set = new JButton("Set")).setToolTipText("<html>This button will set first player's money to the value input.</html>");
        this.p1Set.setBounds(320, 60, 90, 20);
        this.p1Set.setFont(new Font("Times New Roman", 0, 15));
        this.p1Set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String setValue = JOptionPane.showInputDialog("What would you like to set the value to?");
                MainGui.this.setButton(e, MainGui.this.p1Money, setValue);
            }
        });
        this.getContentPane().add(this.p1Set);
        (this.player2 = new JTextArea()).setToolTipText("<html>This field holds the name of the second player.</html>");
        this.player2.setBounds(10, 110, 300, 20);
        this.player2.setBackground(clr);
        this.player2.setFont(new Font("Times New Roman", 1, 14));
        this.player2.setText("Player 2");
        this.player2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                MainGui.this.player2.setText("");
            }
        });
        this.getContentPane().add(this.player2);
        (this.p2Money = new JTextArea()).setToolTipText("<html>This field holds the value of the second player's money.\r\n<br> This can only be changed with the \"Add\", \"Subtract\", \"Transfer\", and \"Set\" <br>buttons.</html>");
        this.p2Money.setForeground(Color.WHITE);
        this.p2Money.setBounds(320, 110, 80, 20);
        this.p2Money.setEditable(false);
        this.p2Money.setFont(new Font("Times New Roman", 1, 14));
        this.p2Money.setBackground(dgc);
        this.p2Money.setText("0");
        this.getContentPane().add(this.p2Money);
        (this.p2Add = new JButton("Receive")).setToolTipText("<html>This button will add the value input with <br>the second player's money.</html>");
        this.p2Add.setBounds(20, 140, 90, 20);
        this.p2Add.setFont(new Font("Times New Roman", 0, 15));
        this.p2Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String addValue = MainGui.this.inputBox("How much would you like to add to " + MainGui.this.p2Money.getText() + "?");
                try {
                    MainGui.this.addButton(e, MainGui.this.p2Money, Integer.parseInt(addValue));
                }
                catch (NumberFormatException ex) {
                    MainGui.this.error("That is not a number!");
                }
            }
        });
        this.getContentPane().add(this.p2Add);
        (this.p2Sub = new JButton("Pay")).setToolTipText("<html>This button will subtract the value input <br>from the second player's money.</html>");
        this.p2Sub.setBounds(120, 140, 90, 20);
        this.p2Sub.setFont(new Font("Times New Roman", 0, 15));
        this.p2Sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String subValue = MainGui.this.inputBox("How much would you like to subtract from " + MainGui.this.p2Money.getText() + "?");
                try {
                    MainGui.this.subButton(e, MainGui.this.p2Money, Integer.parseInt(subValue));
                }
                catch (NumberFormatException ex) {
                    MainGui.this.error("That is not a number!");
                }
            }
        });
        this.getContentPane().add(this.p2Sub);
        (this.p2Trans = new JButton("Transfer")).setToolTipText("<html>This button will give the input player an input ammount of dollars.<br> The value input will be added to the input player's money and<br>subtracted from the second player's money.</html>");
        this.p2Trans.setBounds(220, 140, 90, 20);
        this.p2Trans.setFont(new Font("Times New Roman", 0, 15));
        this.p2Trans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MainGui.this.transButton(e, MainGui.this.p2Money);
            }
        });
        this.getContentPane().add(this.p2Trans);
        (this.p2Set = new JButton("Set")).setToolTipText("<html>This button will set second player's money to the value input.</html>");
        this.p2Set.setBounds(320, 140, 90, 20);
        this.p2Set.setFont(new Font("Times New Roman", 0, 15));
        this.p2Set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String setValue = JOptionPane.showInputDialog("What would you like to set the value to?");
                MainGui.this.setButton(e, MainGui.this.p2Money, setValue);
            }
        });
        this.getContentPane().add(this.p2Set);
        (this.player3 = new JTextArea()).setToolTipText("<html>This field holds the name of the third player.</html>");
        this.player3.setBounds(10, 190, 300, 20);
        this.player3.setText("Player 3");
        this.player3.setFont(new Font("Times New Roman", 1, 14));
        this.player3.setBackground(clr);
        this.player3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                MainGui.this.player3.setText("");
            }
        });
        this.getContentPane().add(this.player3);
        (this.p3Money = new JTextArea()).setToolTipText("<html>This field holds the value of the third player's money.\r\n<br> This can only be changed with the \"Add\", \"Subtract\", \"Transfer\", and \"Set\" <br>buttons.</html>");
        this.p3Money.setForeground(Color.WHITE);
        this.p3Money.setBounds(320, 190, 80, 20);
        this.p3Money.setText("0");
        this.p3Money.setFont(new Font("Times New Roman", 1, 14));
        this.p3Money.setEditable(false);
        this.p3Money.setBackground(dgc);
        this.getContentPane().add(this.p3Money);
        (this.p3Add = new JButton("Receive")).setToolTipText("<html>This button will add the value input with<br>the third player's money.</html>");
        this.p3Add.setBounds(20, 220, 90, 20);
        this.p3Add.setFont(new Font("Times New Roman", 0, 15));
        this.p3Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String addValue = MainGui.this.inputBox("How much would you like to add to " + MainGui.this.p3Money.getText() + "?");
                try {
                    MainGui.this.addButton(e, MainGui.this.p3Money, Integer.parseInt(addValue));
                }
                catch (NumberFormatException ex) {
                    MainGui.this.error("That is not a number!");
                }
            }
        });
        this.getContentPane().add(this.p3Add);
        (this.p3Sub = new JButton("Pay")).setToolTipText("<html>This button will subtract the value input from <br>the third player's money.</html>");
        this.p3Sub.setBounds(120, 220, 90, 20);
        this.p3Sub.setFont(new Font("Times New Roman", 0, 15));
        this.p3Sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String subValue = MainGui.this.inputBox("How much would you like to subtract from " + MainGui.this.p3Money.getText() + "?");
                try {
                    MainGui.this.subButton(e, MainGui.this.p3Money, Integer.parseInt(subValue));
                }
                catch (NumberFormatException ex) {
                    MainGui.this.error("That is not a number!");
                }
            }
        });
        this.getContentPane().add(this.p3Sub);
        (this.p3Trans = new JButton("Transfer")).setToolTipText("<html>This button will give the input player an input ammount of dollars.<br> The value input will be added to the input player's money and<br>subtracted from the third player's money.</html>");
        this.p3Trans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
            }
        });
        this.p3Trans.setBounds(220, 220, 90, 20);
        this.p3Trans.setFont(new Font("Times New Roman", 0, 15));
        this.p3Trans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MainGui.this.transButton(e, MainGui.this.p3Money);
            }
        });
        this.getContentPane().add(this.p3Trans);
        (this.p3Set = new JButton("Set")).setToolTipText("<html>This button will set third player's money to the value input.</html>");
        this.p3Set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String setValue = JOptionPane.showInputDialog("What would you like to set the value to?");
                MainGui.this.setButton(e, MainGui.this.p3Money, setValue);
            }
        });
        this.p3Set.setBounds(320, 220, 90, 20);
        this.p3Set.setFont(new Font("Times New Roman", 0, 15));
        this.getContentPane().add(this.p3Set);
        (this.player4 = new JTextArea()).setToolTipText("<html>This field holds the name of the fourth player.</html>");
        this.player4.setText("Player 4");
        this.player4.setFont(new Font("Times New Roman", 1, 14));
        this.player4.setBackground(clr);
        this.player4.setBounds(10, 270, 300, 20);
        this.player4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                MainGui.this.player4.setText("");
            }
        });
        this.getContentPane().add(this.player4);
        (this.p4Money = new JTextArea()).setToolTipText("<html>This field holds the value of the fourth player's money.\r\n<br> This can only be changed with the \"Add\", \"Subtract\", \"Transfer\", and \"Set\" <br>buttons.</html>");
        this.p4Money.setForeground(Color.WHITE);
        this.p4Money.setText("0");
        this.p4Money.setFont(new Font("Times New Roman", 1, 14));
        this.p4Money.setEditable(false);
        this.p4Money.setBackground(dgc);
        this.p4Money.setBounds(320, 270, 80, 20);
        this.getContentPane().add(this.p4Money);
        (this.p4Add = new JButton("Receive")).setToolTipText("<html>This button will add the value input with<br>the fourth player's money.</html>");
        this.p4Add.setFont(new Font("Times New Roman", 0, 15));
        this.p4Add.setBounds(20, 300, 90, 20);
        this.p4Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String addValue = MainGui.this.inputBox("How much would you like to add to " + MainGui.this.p4Money.getText() + "?");
                try {
                    MainGui.this.addButton(e, MainGui.this.p4Money, Integer.parseInt(addValue));
                }
                catch (NumberFormatException ex) {
                    MainGui.this.error("That is not a number!");
                }
            }
        });
        this.getContentPane().add(this.p4Add);
        (this.p4Sub = new JButton("Pay")).setToolTipText("<html>This button will subtract the value input from <br>the first player's money.</html>");
        this.p4Sub.setFont(new Font("Times New Roman", 0, 15));
        this.p4Sub.setBounds(120, 300, 90, 20);
        this.p4Sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String subValue = MainGui.this.inputBox("How much would you like to subtract from " + MainGui.this.p4Money.getText() + "?");
                try {
                    MainGui.this.subButton(e, MainGui.this.p4Money, Integer.parseInt(subValue));
                }
                catch (NumberFormatException ex) {
                    MainGui.this.error("That is not a number!");
                }
            }
        });
        this.getContentPane().add(this.p4Sub);
        (this.p4Trans = new JButton("Transfer")).setToolTipText("<html>This button will give the input player an input ammount of dollars.<br> The value input will be added to the input player's money and<br>subtracted from the fourth player's money.</html>");
        this.p4Trans.setFont(new Font("Times New Roman", 0, 15));
        this.p4Trans.setBounds(220, 300, 90, 20);
        this.p4Trans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MainGui.this.transButton(e, MainGui.this.p4Money);
            }
        });
        this.getContentPane().add(this.p4Trans);
        (this.p4Set = new JButton("Set")).setToolTipText("<html>This button will set fourth player's money to the value input.</html>");
        this.p4Set.setFont(new Font("Times New Roman", 0, 15));
        this.p4Set.setBounds(320, 300, 90, 20);
        this.p4Set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String setValue = JOptionPane.showInputDialog("What would you like to set the value to?");
                MainGui.this.setButton(e, MainGui.this.p4Money, setValue);
            }
        });
        this.getContentPane().add(this.p4Set);
        (this.P1Text = new JTextPane()).setBackground(Color.BLACK);
        this.P1Text.setForeground(Color.YELLOW);
        this.P1Text.setEnabled(false);
        this.P1Text.setEditable(false);
        this.P1Text.setFont(new Font("Times New Roman", 0, 12));
        this.P1Text.setText("Player 1:");
        this.P1Text.setBounds(10, 11, 54, 20);
        this.getContentPane().add(this.P1Text);
        (this.P2Text = new JTextPane()).setText("Player 2:");
        this.P2Text.setForeground(Color.YELLOW);
        this.P2Text.setFont(new Font("Times New Roman", 0, 12));
        this.P2Text.setEnabled(false);
        this.P2Text.setEditable(false);
        this.P2Text.setBackground(Color.BLACK);
        this.P2Text.setBounds(10, 91, 54, 20);
        this.getContentPane().add(this.P2Text);
        (this.P3Text = new JTextPane()).setText("Player 3:");
        this.P3Text.setForeground(Color.YELLOW);
        this.P3Text.setFont(new Font("Times New Roman", 0, 12));
        this.P3Text.setEnabled(false);
        this.P3Text.setEditable(false);
        this.P3Text.setBackground(Color.BLACK);
        this.P3Text.setBounds(10, 171, 54, 20);
        this.getContentPane().add(this.P3Text);
        (this.P4Text = new JTextPane()).setText("Player 4:");
        this.P4Text.setForeground(Color.YELLOW);
        this.P4Text.setFont(new Font("Times New Roman", 0, 12));
        this.P4Text.setEnabled(false);
        this.P4Text.setEditable(false);
        this.P4Text.setBackground(Color.BLACK);
        this.P4Text.setBounds(10, 251, 54, 20);
        this.getContentPane().add(this.P4Text);
        (this.MoneyText = new JTextPane()).setText("Money/Points:");
        this.MoneyText.setForeground(Color.YELLOW);
        this.MoneyText.setFont(new Font("Times New Roman", 0, 12));
        this.MoneyText.setEnabled(false);
        this.MoneyText.setEditable(false);
        this.MoneyText.setBackground(Color.BLACK);
        this.MoneyText.setBounds(320, 11, 80, 20);
        this.getContentPane().add(this.MoneyText);
        (this.MoneyText2 = new JTextPane()).setText("Money/Points:");
        this.MoneyText2.setForeground(Color.YELLOW);
        this.MoneyText2.setFont(new Font("Times New Roman", 0, 12));
        this.MoneyText2.setEnabled(false);
        this.MoneyText2.setEditable(false);
        this.MoneyText2.setBackground(Color.BLACK);
        this.MoneyText2.setBounds(320, 91, 80, 20);
        this.getContentPane().add(this.MoneyText2);
        (this.MoneyText3 = new JTextPane()).setText("Money/Points:");
        this.MoneyText3.setForeground(Color.YELLOW);
        this.MoneyText3.setFont(new Font("Times New Roman", 0, 12));
        this.MoneyText3.setEnabled(false);
        this.MoneyText3.setEditable(false);
        this.MoneyText3.setBackground(Color.BLACK);
        this.MoneyText3.setBounds(320, 171, 80, 20);
        this.getContentPane().add(this.MoneyText3);
        (this.MoneyText4 = new JTextPane()).setText("Money/Points:");
        this.MoneyText4.setForeground(Color.YELLOW);
        this.MoneyText4.setFont(new Font("Times New Roman", 0, 12));
        this.MoneyText4.setEnabled(false);
        this.MoneyText4.setEditable(false);
        this.MoneyText4.setBackground(Color.BLACK);
        this.MoneyText4.setBounds(320, 251, 80, 20);
        this.getContentPane().add(this.MoneyText4);
        (this.CharacterDescrip = new JTextArea()).setToolTipText("<html>This field holds a short description <br>of the first player's character.</html>");
        this.CharacterDescrip.setFont(new Font("Times New Roman", 1, 12));
        this.CharacterDescrip.setBackground(Color.YELLOW);
        this.CharacterDescrip.setForeground(Color.BLACK);
        this.CharacterDescrip.setText("P1 Character");
        this.CharacterDescrip.setBounds(80, 10, 200, 20);
        this.CharacterDescrip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                MainGui.this.CharacterDescrip.setText("");
            }
        });
        this.getContentPane().add(this.CharacterDescrip);
        (this.CharacterDescrip2 = new JTextArea()).setToolTipText("<html>This field holds a short description <br>of the second player's character.</html>");
        this.CharacterDescrip2.setFont(new Font("Times New Roman", 1, 12));
        this.CharacterDescrip2.setText("P2 Character");
        this.CharacterDescrip2.setForeground(Color.BLACK);
        this.CharacterDescrip2.setBackground(Color.YELLOW);
        this.CharacterDescrip2.setBounds(80, 90, 200, 20);
        this.CharacterDescrip2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                MainGui.this.CharacterDescrip2.setText("");
            }
        });
        this.getContentPane().add(this.CharacterDescrip2);
        (this.CharacterDescrip3 = new JTextArea()).setToolTipText("<html>This field holds a short description <br>of the third player's character.</html>");
        this.CharacterDescrip3.setFont(new Font("Times New Roman", 1, 12));
        this.CharacterDescrip3.setText("P3 Character");
        this.CharacterDescrip3.setForeground(Color.BLACK);
        this.CharacterDescrip3.setBackground(Color.YELLOW);
        this.CharacterDescrip3.setBounds(80, 170, 200, 20);
        this.CharacterDescrip3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                MainGui.this.CharacterDescrip3.setText("");
            }
        });
        this.getContentPane().add(this.CharacterDescrip3);
        (this.CharacterDescrip4 = new JTextArea()).setToolTipText("<html>This field holds a short description <br>of the fourth player's character.</html>");
        this.CharacterDescrip4.setFont(new Font("Times New Roman", 1, 12));
        this.CharacterDescrip4.setText("P4 Character");
        this.CharacterDescrip4.setForeground(Color.BLACK);
        this.CharacterDescrip4.setBackground(Color.YELLOW);
        this.CharacterDescrip4.setBounds(80, 250, 200, 20);
        this.CharacterDescrip4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                MainGui.this.CharacterDescrip4.setText("");
            }
        });
        this.getContentPane().add(this.CharacterDescrip4);
        (this.RollDice = new JButton("Roll Dice")).setToolTipText("<html>This button will roll a dice with an input number of<br>faces an input number of times.<br>The number of faces and the number of times are<br>input in the \"Time(s)\" field and the \"Sides\" field.</html>");
        this.RollDice.setFont(new Font("Times New Roman", 0, 15));
        this.RollDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MainGui.this.rollButton(e);
            }
        });
        this.RollDice.setBounds(220, 350, 90, 20);
        this.getContentPane().add(this.RollDice);
        (this.NoteBox = new JTextArea()).setToolTipText("<html>This field will hold notes you may need to set during the game.</html>");
        (this.NoteBoxSP = new JScrollPane(this.NoteBox)).setToolTipText("<html>This field will hold notes you may need to set during the game.</html>");
        this.NoteBox.setWrapStyleWord(true);
        this.NoteBox.setLineWrap(true);
        this.NoteBox.setText("Click to add notes.");
        this.NoteBox.setFont(new Font("Times New Roman", 0, 12));
        this.NoteBox.setBounds(420, 30, 190, 340);
        this.NoteBoxSP.setWheelScrollingEnabled(true);
        this.NoteBoxSP.getVerticalScrollBar();
        this.NoteBoxSP.setBounds(420, 30, 190, 340);
        this.getContentPane().add(this.NoteBoxSP);
        (this.NotePane = new JTextPane()).setFont(new Font("Times New Roman", 0, 12));
        this.NotePane.setEnabled(false);
        this.NotePane.setEditable(false);
        this.NotePane.setBackground(Color.BLACK);
        this.NotePane.setForeground(clr);
        this.NotePane.setText("Notes:");
        this.NotePane.setBounds(420, 10, 60, 20);
        this.getContentPane().add(this.NotePane);
        (this.RollNum = new JTextPane()).setToolTipText("<html>This field holds the amount of times you want to roll the dice.</html>");
        this.RollNum.setFont(new Font("Times New Roman", 0, 13));
        this.RollNum.setText("1");
        this.RollNum.setBounds(90, 350, 25, 20);
        this.getContentPane().add(this.RollNum);
        (this.RollSides = new JTextPane()).setToolTipText("<html>This field holds the amount of sides your die has.</html>");
        this.RollSides.setText("6");
        this.RollSides.setBounds(170, 350, 30, 20);
        this.getContentPane().add(this.RollSides);
        (this.times = new JTextPane()).setEditable(false);
        this.times.setEnabled(false);
        this.times.setBackground(Color.BLACK);
        this.times.setForeground(Color.YELLOW);
        this.times.setFont(new Font("Times New Roman", 0, 12));
        this.times.setText("Time(s):");
        this.times.setBounds(55, 330, 55, 20);
        this.getContentPane().add(this.times);
        (this.txtSides = new JTextPane()).setText("Sides:");
        this.txtSides.setForeground(Color.YELLOW);
        this.txtSides.setFont(new Font("Times New Roman", 0, 12));
        this.txtSides.setEnabled(false);
        this.txtSides.setEditable(false);
        this.txtSides.setBackground(Color.BLACK);
        this.txtSides.setBounds(145, 330, 40, 20);
        this.getContentPane().add(this.txtSides);
    }
    
    public void setButton(final ActionEvent e, final JTextArea text, final String valueToSet) {
        AppMechanics.set(text, valueToSet, this);
    }
    
    public void addButton(final ActionEvent e, final JTextArea text, final int valueToAdd) {
        AppMechanics.add(text, valueToAdd, this);
    }
    
    public void transButton(final ActionEvent e, final JTextArea text) {
        AppMechanics.transfer(text, this);
    }
    
    public void error(final String error) {
        JOptionPane.showMessageDialog(this, error, "Error", 0);
    }
    
    public String inputBox(final String text) {
        return JOptionPane.showInputDialog(this, text, "Input");
    }
    
    public void subButton(final ActionEvent e, final JTextArea text, final int valueToSub) {
        AppMechanics.subtract(text, valueToSub, this);
    }
    
    public void rollButton(final ActionEvent e) {
        AppMechanics.rollDice(this);
    }
}
