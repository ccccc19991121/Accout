
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by cc on 2018/7/13.
 */
public class AccountFrame extends JFrame {
    // 上部放置查询相关组件的面板
    private JPanel panelSearch = new JPanel();
    // 下部提供add ,del , modify 操作的面板
    private JPanel panelProcess = new JPanel();
    // 搜索框
    private JTextField txtSearch = new JTextField();
    // 搜索按钮
    private JButton btnSearch = new JButton("search");

    //中间文本域
    private JLabel labView = new JLabel("打不过我吧！没有办法··啦啦啦啦啦·~~");
    //添加功能所使用的面板，包含很多组件
    private JPanel panelAdd = new JPanel();
    //按钮add内容
    private JLabel labAddAcount = new JLabel("name:");
    private JTextField txtAddAccount = new JTextField("");

    private JLabel labAddPassword = new JLabel("password");
    private JTextField txtAddPassword = new JTextField();

    private JLabel labAddtep = new JLabel("\n" + "telephone:");
    private JTextField txtAddtep = new JTextField("");

    private JLabel labAddmrk = new JLabel("\n" + "remarks:");
    private JTextField txtAddmrk = new JTextField("");


  //最下方按钮
    private JButton btnAdd = new JButton("add");
    private JButton btnDelete = new JButton("delete");
    private JButton btnModify = new JButton("modify");

    //按钮

    public AccountFrame() {
        // === 初始化组件 =======
        panelSearch.setLayout(new BorderLayout());//设置布局
        panelSearch.add(txtSearch);//添加搜索框到中间部分
        panelSearch.add(btnSearch, BorderLayout.EAST);//添加搜索按钮到右边
        // == 初始化panelAdd面板组件 ==
        panelAdd.setLayout(new GridLayout(4, 4));
        panelAdd.add(labAddAcount);
        panelAdd.add(txtAddAccount);

        panelAdd.add(labAddPassword);
        panelAdd.add(txtAddPassword);

        panelAdd.add(labAddtep);
        panelAdd.add(txtAddtep);

        panelAdd.add(labAddmrk);
        panelAdd.add(txtAddmrk);

        panelAdd.setVisible(false);

        //== 初始化底部面板
        panelProcess.add(btnAdd);
        panelProcess.add(btnDelete);
        panelProcess.add(btnModify);

        //=== ====
        this.add(panelSearch, BorderLayout.NORTH);//添加搜索面板到上方
        this.add(panelProcess, BorderLayout.SOUTH);//添加操作面板到下方
        this.add(panelAdd);
        this.add(labView);

        // === 添加事件处理 =====
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 移除labView 组件
                String text = btnAdd.getText();
                String text1 = btnDelete.getText();
                if (text.equals("delete")){
                    AccountFrame.this.panelAdd.setVisible(false);
                    AccountFrame.this.panelAdd.setVisible(true);
                    AccountFrame.this.getLayout().removeLayoutComponent(labView);
                    AccountFrame.this.add(panelAdd);
                    text = "exit";
                }else {
                    text = "delete";
                    AccountFrame.this.panelAdd.setVisible(false);
                    AccountFrame.this.panelAdd.setVisible(true);
                    AccountFrame.this.getLayout().removeLayoutComponent(panelAdd);
                    panelAdd.setVisible(false);
                    JOptionPane.showMessageDialog(null, "退出成功！");

                    AccountFrame.this.add(labView);
                    labView.setVisible(true);
                }
                if (text.equals("add")) {
                    AccountFrame.this.panelAdd.setVisible(false);
                    AccountFrame.this.panelAdd.setVisible(true);
                    AccountFrame.this.getLayout().removeLayoutComponent(labView);
                    AccountFrame.this.add(panelAdd);

                    text = "save";
                } else {
                    text = "add";
                    AccountFrame.this.panelAdd.setVisible(false);
                    AccountFrame.this.panelAdd.setVisible(true);
                    AccountFrame.this.getLayout().removeLayoutComponent(panelAdd);
                    panelAdd.setVisible(false);
                    JOptionPane.showMessageDialog(null, "保存成功！");

                    AccountFrame.this.add(labView);
                    labView.setVisible(true);
                }
                btnAdd.setText(text);
                btnDelete.setText("cancel");
                btnModify.setVisible(false);
                AccountFrame.this.panelAdd.setVisible(false);
                AccountFrame.this.panelAdd.setVisible(true);

            }
        });
        // === 设定窗体相关属性 ====
        this.setSize(800,600);
        this.setTitle("账号首页");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String ... args) {
        new AccountFrame();
    }

}