/**
 * Created by Administrator on 2018/7/12.
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;
public class Frame extends JFrame{
        private JPanel jp=new JPanel();
        private JTextField[] jbArray=new JTextField[7];
              public Frame(){
                for(int i=1;i<jbArray.length;i++){
                    jbArray[i]=new JTextField("name"+i);
                    jp.add(jbArray[i]);
                    jbArray[i].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });
                }
                 this.add(jp);
                 this.setTitle("———测试ing———");
                 this.setBounds(100, 100, 450, 300);
                 this.setVisible(true);
              }
//            public void actionPerformed(ActionEvent e){
//                  jp.revalidate();
                GridLayout gird = new GridLayout(3,0);
//                JPanel idea1 = new JPanel();
//                JPanel telephone2 = new JPanel();
//                JPanel password3 = new JPanel();
//                JPanel remark4 = new JPanel();
//                jp.setLayout(gird);
//                jbArray.add(idea1);
//                jbArray.add(telephone2);
//                jbArray.add(password3);
//                jbArray.add(remark4);
//                JLabel name = new JLabel("账号:");
//                JTextField nametext = new JTextField(10);
//                JLabel tel = new JLabel("联系方式:");
//                JPasswordField tel1 = new JPasswordField(10);
//                JLabel pwd = new JLabel("密码:");
//                JPasswordField pwd1 = new JPasswordField(10);
//                JLabel rmk = new JLabel("备注:");
//                JPasswordField rmk1 = new JPasswordField(10);
//                jbArray.add(name);
//                jbArray.add(nametext);
//                jbArray.add(tel);
//                jbArray.add(tel1);
//                jbArray.add(pwd);
//                jbArray.add(pwd1);
//                jbArray.add(rmk);
//                jbArray.add(rmk);
//                jp.getLayeredPane().setLayout(null);
//                jp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//                jbArray.setOpaque(false);
//                jbArray.setOpaque(false);
//                jbArray.setOpaque(false);
//                jbArray.setOpaque(false);
//                jbArray.setOpaque(false);
//                jp.setVisible(true);
//            }
        public static void main(String [] args) {
            new Frame();
        }
    }
//



//public class MyFrame extends JFrame implements ActionListener
//{
//    private JButton button;
//    private JTextField textField;
//    private JLabel label;
//    public MyFrame()
//    {
//        button = new JButton("Hello world");
//        textField = new JTextField(15);
//        label = new JLabel("输入内容：");
//        setTitle("Simple-Frame");
//        setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - 500)/2,
//                (Toolkit.getDefaultToolkit().getScreenSize().height - 300)/2
//                , 500, 300);
//        setLayout(new FlowLayout());
//        add(label);
//        add(textField);
//        add(button);
//        setResizable(false);
//        setVisible(true);
//        this.button.addActionListener(this);
//    }
//    public static void main(String[] args)
//    {
//        new MyFrame();
//    }
//    @Override
//    public void actionPerformed(ActionEvent e)
//    {
//        if(e.getSource() == this.button)
//        {
//            this.textField.setText("Hello World");
//        }
//    }
//}
