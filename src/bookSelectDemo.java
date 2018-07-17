import java.sql.*;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/7/17.
 */
public class bookSelectDemo {
    private Connection getConnection() {
        //1.加载驱动
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建数据库连接字符串
            String dbURl = "jdbc:mysql://localhost:3306/xinxi?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            //3.创立数据库链接

           Connection connection = DriverManager.getConnection(dbURl, "root", "root");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //添加
    private void Insertbook(int id, String book_name, String book_publishers,String book_autbor,String create_time) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xinxi?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                    "root", "root");

            //2.构建添加数据的sql语句
            String sql = "insert into bookDemo\" + \" values(\" + id + \",'\" + book_name + \"',\"+ book_publishers +\",\"+ book_autbor +\",\"+ create_time +\")";
            //3.执行SQL语句
            connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("所影响的行数为：" + rows);
            //4.得到执行后的结果，确定是否添加成功
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (statement !=null) {

                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //修改
    private void UpdateBook(int id, String book_name, String book_publishers,String book_autbor,String create_time) {
        Connection connection = null;
        try {

            connection = getConnection();
            String sql = "update account set user_name = '" + book_name + " ',uesr_publishers = '" + book_publishers + "'," +
                    "user_autbor = '" + book_autbor + "'create_time = '" + create_time + "'where id = " + id;
            int rows;
            try (Statement statement = connection.createStatement()) {
                rows = statement.executeUpdate(sql);
            }
            System.out.println("更新结果为:" + (rows > 0));
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
private void close(Connection connection,Statement statement,ResultSet resultSet){
        try{
        if(resultSet != null){
        resultSet.close();
        }
        if( statement != null){
        statement.close();
        }
        if(connection != null){
        connection.close();
        }
        }catch (SQLException e){
        e.printStackTrace();
        }
        }
        //删除数据
private void testDeletedate(int id) {
        Connection connection = null;
        Statement statement = null;
        try {
        connection = getConnection();
        String sql = "delete from bookDemo where id = " + id+"";
        statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println("有" + rows + "行被删除成功！");
        } catch (SQLException e) {
        e.printStackTrace();
        }finally {

        }
        }
    private  String [] [] bestFindAllData()  {
        String [][] datas = new String[52][3];
        Connection connection = null;
        Statement  statement = null;
        ResultSet resultSet = null;
        //获取数据库连接
        connection =getConnection();
        //构建查询的sql 语句
        String sql = "select * from account ";
        //执行sql 语句，并获得结果集
        statement = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //遍历结果集，输出每条记录信息
            int index = 0;
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String book_name = resultSet.getString(2);
                String book_publishers = resultSet.getString(3);
                String user_autbor = resultSet.getString(4);
                String create_time = resultSet.getString(5);
                datas [index] [0] = id + "";
                datas [index] [1] = book_name + "";
                datas [index] [2] = book_publishers+ "";
                datas [index] [3] = user_autbor +"";
                datas [index] [4] = create_time +"";
                index++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement,resultSet);
        }return datas;
    }
    private void findAllbookFormatOutput(){

        String[] [] datas =bestFindAllData();
        StringBuffer buffer = new StringBuffer();
        buffer.append("----------------------------------------------"+System.lineSeparator());
        buffer.append("id\t\t\tbook_name\t\t\tbook_publishers\t\t\tuser_autbor\t\t\tcreate_time\t\t\t"+System.lineSeparator());
        buffer.append("----------------------------------------------"+System.lineSeparator());
        for (int i=1; i< datas.length; i++){
            String[] values=datas[i];
            if (values[0]!= null && values[1] !=null && values[2] !=null && values[3] !=null && values[4] !=null ){
                buffer.append(
                        String.format(
                                "%s\t|%s\t|%s\t|",values[0],values[1],values[2],values[3],values[4]));
                buffer.append(System.lineSeparator());


            }
        }
        System.out.println(buffer.toString());
    }
    private void findAccountDataById(){

    }

    public static void main(String[] args) {
        bookSelectDemo demo = new bookSelectDemo();
        demo. bestFindAllData();
        Scanner scanner = new Scanner(System.in);
        demo.findAllbookFormatOutput();
        demo.findAccountDataById();
        while (true){
            System.out.println("=============================");
            System.out.println("======欢使用CC1.0查询系统=====");
            System.out.println("=====1.添加数据==============");
            System.out.println("=====2.修改数据==============");
            System.out.println("=====3.删除数据==============");
            System.out.println("=====4.退出系统==============");
            System.out.println("============================");
            System.out.println("请选择你要进行的操作:");
            int select = 0;//接收用户选择的选项.
            select = scanner.nextInt();

            while (select <1 || select >4) {
                System.out.println("选择的操作不能被识别，请重新选择：");
                select = scanner.nextInt();
            }
            if (select>1||select<4){
                System.out.println("正在加载中...");

            }
            String value =null;
            bookSelectDemo jdbcDemo = new bookSelectDemo();
            if( select==1) {//添加数据
                System.out.println("请输入要添加的账号和密码，中间用逗号分隔，举例：126.com");
                value = scanner.next();
                String[] values = value.split(",");
                jdbcDemo.Insertbook((int) System.currentTimeMillis(),values[0], values[1],values[2],values[3]);
                System.out.println("是否继续加入");
                System.out.println("1.继续   2.取消");
                int count;
                count = Integer.parseInt(scanner.next());
                while(count == 1){
                    System.out.println("请输入要添加的账号和密码，中间用逗号分隔。");
                    System.out.println("例：126.com");
                    value = scanner.next();
                    values = value.split(",");
                    jdbcDemo.Insertbook((int) System.currentTimeMillis(), values[0], values[1],values[2],values[3]);
                    System.out.println("是否继续加入？");
                    System.out.println("1.继续     2.取消");
                    value = scanner.next();
                    break;  }



            } else if  (select==2){//修改数据
                System.out.println("请输入您要修改的id、账号和密码。逗号分隔。系统将根据id进行数据的更新。id本身不会修改。");
                value = scanner.next();
                String[] values = value.split(",");
                jdbcDemo.UpdateBook(Integer.parseInt(values[0]), values[1],values[2],values[3],values[4]);
                System.out.println("是否继续修改");
                System.out.println("1.继续   2.取消");
                int count;
                count = Integer.parseInt(scanner.next());
                while(count == 2){
                    System.out.println("请输入您要修改的id、账号和密码。逗号分隔。系统将根据id进行数据的更新。id本身不会修改。");
                    value = scanner.next();
                    values = value.split(",");
                    jdbcDemo.UpdateBook(Integer.parseInt(values[0]), values[1],values[2],values[3],values[4]);
                    System.out.println("是否继续？");
                    System.out.println("1.继续     2.取消");
                    value = scanner.next();
                }
            } else if   (select==3){//删除数据
                System.out.println("请选择你要删除的id");
                value = scanner.next();
                String[] values = value.split(",");
                jdbcDemo.testDeletedate(Integer.parseInt(values[0]));
                System.out.println("是否继续删除");
                System.out.println("1.继续   2.取消");
                int count;
                count = Integer.parseInt(scanner.next());
                while(count == 3){
                    System.out.println("请选择你要删除的id");
                    value = scanner.next();
                    values = value.split(",");
                    jdbcDemo.testDeletedate(Integer.parseInt(values[0]));
                    System.out.println("是否继续？");
                    System.out.println("1.继续     2.取消");
                    value = scanner.next();
                }
            } else if   (select==4){//退出系统
                System.exit(0);

            }




        }
    }
}




