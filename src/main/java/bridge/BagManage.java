package bridge;

import javax.swing.*;
import java.awt.*;

//实现化角色：颜色
interface Color {
    String getColor();
}

public class BagManage {
    public static void main(String[] args) {
        Color color;
        Bag bag;
        color = (Color) ReadXML.getObject("color");
        bag = (Bag) ReadXML.getObject("bag");
        bag.setColor(color);
        String name = bag.getName();
        show(name);
    }

    public static void show(String name) {
        JFrame jf = new JFrame("桥接模式测试");
        Container contentPane = jf.getContentPane();
        JPanel p = new JPanel();
        JLabel l = new JLabel(new ImageIcon("src\\main\\resources\\bridge\\" + name + ".jpg"));
        p.setLayout(new GridLayout(1, 1));
        p.setBorder(BorderFactory.createTitledBorder("女士皮包"));
        p.add(l);
        contentPane.add(p, BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

//具体实现化角色：黄色
class Yellow implements Color {
    public String getColor() {
        return "yellow";
    }
}

//具体实现化角色：红色
class Red implements Color {
    public String getColor() {
        return "red";
    }
}

//抽象化角色：包
abstract class Bag {
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String getName();
}

//扩展抽象化角色：挎包
class HandBag extends Bag {
    public String getName() {
        return color.getColor() + "HandBag";
    }
}

//扩展抽象化角色：钱包
class Wallet extends Bag {
    public String getName() {
        return color.getColor() + "Wallet";
    }
}