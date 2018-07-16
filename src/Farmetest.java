import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2018/7/13.
 */

/**
 * Created by  CC on 2018/7/12.
 */
public class Farmetest extends JFrame{
    public Farmetest() {
        this.setSize(500, 600);
        GridLayout gridLayout = new GridLayout(5,2);
        this.setLayout(gridLayout);
        //标题
        this.setTitle("---测试---");
        //文本框名字
        JLabel label0 = new JLabel("姓名");
        JTextField name= new JTextField();
        JLabel label1= new JLabel("电话");
        JTextField thp= new JTextField();
        JLabel label2 = new JLabel("密码");
        JTextField psd= new JTextField();
        JLabel label3 = new JLabel("备注");
        JTextField date= new JTextField();
        JButton search = new JButton("查询");
        //文本框
        this.add(label0);
        this.add(name);
        this.add(label1);
        this.add(thp);
        this.add(label2);
        this.add(psd);
        this.add(label3);
        this.add(date);
        this.add(search);;
        search.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JOptionPane.showConfirmDialog(null,""+name.getText()+thp.getText()+psd.getText()+date.getText());
                                    }
                                });
                setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Farmetest sxMyFrame = new Farmetest();
    }


}
