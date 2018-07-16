/**
 * Created by Administrator on 2018/7/14.
 */


        import java.sql.*;
        import java.util.Scanner;

/**
 *create by zn on
 * 演示通过jdbc连接数据库和进行增，删，改，查的操作
 */
public class JDBCDemo {
    /**
     * 演示通过jdbc连接数据库
     */
    private Connection getConnection() {
        //1.加载驱动
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

            } catch (java.lang.Exception exception) {
                exception.printStackTrace();
            }
            //2.创建数据库连接字符串
            String dbURL = "jdbc:mysql://localhost:3306/xinxi";
            //3.建立数据库连接
            Connection connection = DriverManager.getConnection(dbURL, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void Insertdata(int id, String name, String emali,int age) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            String sql = "insert into account" + " values(" + id + ",'" + emali + "',"+ age +")";
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("所影响的行数为:" + rows + "行");
        }
         catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement!= null){
                    statement.close();
                }
                if (connection!= null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    private void testUpdateDate(int id, String name, String emali,int age) {
        Connection connection = null;
        try {

            connection = getConnection();
            String sql = "update account set user_name = '" + name + " ',uesr_emali = '" + emali + "',user_age = '" + age + "'where id = " + id;
            int rows;
            try (Statement statement = connection.createStatement()) {
                rows = statement.executeUpdate(sql);
            }
            System.out.println("更新结果为:" + (rows > 0));
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection!= null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }


    private void testDeletedate(int id) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            String sql = "delete from account where id = " + id+"";
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("有" + rows + "行被删除成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (statement!= null){
                    statement.close();
                }
                if (connection!= null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    private void findAllDate(){
        //1.获取数据库连接
        Connection connection = getConnection();
        //2.构建查询的sql语句
        String sql = "select * from account";
        //3.执行sql语句,并获得结果集
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            StringBuffer buffer = new StringBuffer();
            buffer.append("-----------------------------------");
            buffer.append("id+\t\t\tname\t\t\temali\t\t\t"+System.lineSeparator());
            buffer.append("-----------------------------------");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("user_name");
                String emali = resultSet.getString("user_emali");
                buffer.append(id+"\t|"+name+"\t|"+emali+"|"+System.lineSeparator());

            }
            System.out.println(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //4.遍历结果集，并获得每条记录的信息
    }
//    private void findAccountDataById(int id){
//        //模糊搜索数据，根据用户输入的关键字来模糊查询
//        try {
//            Connection connection = getConnection();
//
//
//            System.out.println("你查询的数据如下:" + rows );
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    }
    private void findAccountDataLikeKey(String keyword){
        //acount,password
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        while (true)
          JDBCDemo jdbcDemo = new JDBCDemo();
//        {
            System.out.println("=========迎===================");
            System.out.println("======欢使用CC1.0查询系统===");
            System.out.println("=====1.添加数据==============");
            System.out.println("=====2.修改数据==============");
            System.out.println("=====3.删除数据==============");
            System.out.println("=====4.退出系统==============");
            System.out.println("============================");
            System.out.println("请选择你要进行的操作:");
            int select = 0;
            int i = 0;
            select = scanner.nextInt();
            while (select < 1 || select > 4) {
                System.out.println("选择的操作不能识别,请重新选择:");
                select = scanner.nextInt();

            }
        String value = null;
                switch (select) {
                    case 1:
                        System.out.println("你正在执行操作1.添加数据");
                        System.out.println("请输入要添加的账号and名字and邮箱and年龄:");
                        value = scanner.next();
                        String[] values = value.split(",");
                        jdbcDemo.Insertdata((int) System.currentTimeMillis(), values[0], values[1], Integer.parseInt(values[2]));
                        break;
                    case 2:
                        System.out.println("你正在执行操作2.修改数据");
                        System.out.println("请输入要修改的账号and邮箱and年龄and:");
                        value = scanner.next();
                        values = value.split(",");
                        jdbcDemo.testUpdateDate(Integer.parseInt(values[0]), values[1], values[2], Integer.parseInt(values[3]));
                        break;
                    case 3:
                        System.out.println("你正在执行操作3.删除数据");
                        System.out.println("请输入要删除的id:");
                        value = scanner.next();
                        jdbcDemo.testDeletedate(Integer.parseInt(value));
                        break;

                    case 4:
                        System.out.println("你正在执行操作4.退出系统");
                    default:
                        break;
                }


            }
        }
//    }

