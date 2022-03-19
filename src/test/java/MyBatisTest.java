import com.itheima.Dao.StudentDao;
import com.itheima.pojo.Customer;
import com.itheima.pojo.Student;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void findStudentByNameOrMajorTest() {
        SqlSession session = MyBatisUtils.getSqlSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        //当用户输入的学生姓名不为空时，则只根据学生姓名进行学生信息的查询；
        Student student = new Student(null, "张三", null, null);
        System.out.println(studentDao.getStudents(student));
        //当用户输入的学生姓名为空而学生专业不为空时，则只根据学生专业进行学生信息的查询；
        student = new Student(null, null, "软件工程", null);
        System.out.println(studentDao.getStudents(student));
        //当用户输入的学生姓名和专业都为空，则要求查询出所有学号不为空的学生信息
        student = new Student(null, null, null, null);
        System.out.println(studentDao.getStudents(student));
        //单条件查询
        System.out.println(studentDao.getStudent(5));
        session.close();
    }

    @Test
    public void findCustomerByNameAndJobsTest() {
        SqlSession session = MyBatisUtils.getSqlSession();
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        List<Customer> customers = session.selectList("com.itheima.Dao.CustomerDao.findCustomerByNameAndJobs", customer);
        for (Customer customer2 : customers) {
            System.out.println(customers);
        }
        session.close();
    }

    @Test
    public void findCustomerByNameOrJobsTest() {
        SqlSession session = MyBatisUtils.getSqlSession();
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        List<Customer> customers = session.selectList("com.itheima.Dao.CustomerDao.findCustomerByNameOrJobs", customer);
        for (Customer customer2 : customers) {
            System.out.println(customers);
        }
        session.close();
    }

    @Test
    public void updateCustomerBySetTest() {
        SqlSession session = MyBatisUtils.getSqlSession();
        Customer customer = new Customer();
        customer.setId(3);
        customer.setPhone("13311111234");
        int row = session.update("com.itheima.Dao.CustomerDao.updateCustomerBySet", customer);
        if (row > 0)
            System.out.println("您修改了" + row + "条数据");
        else
            System.out.println("执行修改操作失败");

        session.close();
    }

    @Test
    public void findByListTest() {
        SqlSession session = MyBatisUtils.getSqlSession();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<Customer> customers = new ArrayList<Customer>();
        session.selectList("com.itheima.Dao.CustomerDao.findByList", ids);
        for (Customer customer : customers)
            System.out.println(customer);
        session.close();
    }

    @Test
    public void findByMapTest() {
        SqlSession session = MyBatisUtils.getSqlSession();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        Map<String, Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("id", ids);
        conditionMap.put("jobs", "teacher");

        List<Customer> customers;
        customers = session.selectList("com.itheima.Dao.CustomerDao.findByMap", conditionMap);
        for (Customer customer : customers)
            System.out.println(customer);
        session.close();
    }

}
