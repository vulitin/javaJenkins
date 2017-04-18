package lab_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class lab5 extends JFrame{
    public static int wid = 0;
    public static int heig =0;
    public static Color color = new Color(240, 240, 240);

    public static void main(String[] args) {

        TextField dl = new TextField(20);
        TextField sh = new TextField(20);

        CheckboxGroup colors = new CheckboxGroup();
        Checkbox cl1 = new Checkbox("Красный",colors,true);
        Checkbox cl2 = new Checkbox("Зеленый",colors,false);
        Checkbox cl3 = new Checkbox("Синий",colors,false);
        JMenuItem mPaint = new JMenuItem("Paint");
        
        // создание окна
        JFrame f = new JFrame("Лабораторная №5");

        JMenuBar mFile = new JMenuBar();
        f.setJMenuBar(mFile);
        JMenuItem mSize = new JMenuItem("Size");
        mFile.add(mSize);
        JMenuItem mColor = new JMenuItem("Color");
        mFile.add(mColor);
        mSize.addActionListener(new ActionListener() {

            public void actionPerformed (ActionEvent e) {
                Frame f1 = new Frame("Размер и цвет");
                f1.setLayout(null);
                f1.setSize(400,300);
                f1.setLocationRelativeTo(null);
                Button commit = new Button("Подтвердить");
                commit.setBounds(130,230,150,50);
                f1.add(commit);
                commit.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if(dl.getText().trim().length() > 0 && sh.getText().trim().length() > 0)
                        mPaint.setEnabled(true);
                        else mPaint.setEnabled(false);
                        f1.setVisible(false);
                        }

                });

                Label clCh = new Label("Выберите цвет");
                clCh.setBounds(15,60,100,30); f1.add(clCh);
                cl1.setBounds(15,90,100,30); f1.add(cl1);
                cl2.setBounds(15,120,100,30); f1.add(cl2);
                cl3.setBounds(15,150,100,30); f1.add(cl3);

                Label rectCh = new Label("Задайте размер прямоугольника (в пикселях)");
                rectCh.setBounds(120,60,280,30); f1.add(rectCh);
                Label dlina = new Label("Длина");
                dlina.setBounds(130,90,100,30); f1.add(dlina);
                Label shirina = new Label("Ширина");
                shirina.setBounds(130,150,100,30); f1.add(shirina);

                dl.setBounds(230,90,80,30); f1.add(dl);
                sh.setBounds(230,150,80,30); f1.add(sh);
                f1.setResizable(false);
                f1.setVisible(true);
                f1.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent ev) {
                        f1.setVisible(false);
                    }
                });
            }
        });

        mFile.add(mPaint);
        mPaint.setEnabled(false);
        mPaint.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(dl.getText())<=800&&Integer.parseInt(dl.getText())>=1&& Integer.parseInt(sh.getText())<=500&&Integer.parseInt(sh.getText())>=1) {
                    wid = Integer.parseInt(dl.getText());
                    heig = Integer.parseInt(sh.getText());
                    if (cl1.getState())
                        color = new Color(255, 23, 26);
                    else if (cl2.getState())
                        color = new Color(44, 225, 55);
                    else color = new Color(52, 52, 234);
                }
                else JOptionPane.showMessageDialog(f, "Размеры фигуры больше размеров экрана(800*500)");

            }
        });
        JMenuItem mQuit = new JMenuItem("Quit");
        mFile.add(mQuit);
        mQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        class Canvas extends JComponent{
            public void paintComponent(Graphics g){
                super.paintComponents(g);
                Graphics2D g2d=(Graphics2D)g;
                g2d.setPaint(color);
                g2d.fillRect(0, 0, wid, heig);
                super.repaint();
            }
        }

        f.setSize(800,500);
        f.setLayout(new BorderLayout(1,1));
        f.setVisible(true);
        Canvas canv=new Canvas();
        f.add(canv);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
        f.setResizable(false);


    }




}


