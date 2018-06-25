import com.nenu.software.common.entity.Student;
import com.nenu.software.service.StudentService;
import com.nenu.software.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author shanjz
 * @since 2018/6/20 10:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-mybatis.xml"})
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    public void testNewStudent() throws Exception {
//        StudentService studentService = new StudentServiceImpl();
        Student student = new Student();
        student.setStuName("董");
//        student.setStuNum(2015011969);
        student.setStuNum(2015012007);
        studentService.newStudent(student);
        System.out.println("new over");
    }

    @Test
    public void testDeleteStudent() throws Exception {
        studentService.deleteStudentById(1);
        System.out.println("delete over");
    }

    @Test
    public void testDeleteStudentByStuNum() throws Exception {
        studentService.deleteStudentByStuNum(2015011939);
        System.out.println("delete Over");
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Student student = new Student();
        student.setId(6);
        student.setStuName("aa");
        student.setStuNum(2015011939);
        studentService.updateStudent(student);
    }

    @Test
    public void testSelect() throws Exception {
        Student student1 = studentService.selectStudentById(3);
        System.out.println(student1);
        System.out.println(studentService.selectStudentByStuNum(2015011969));
        System.out.println(studentService.listStudentByConditions(null, 0, null));
    }


    @Test
    public void haha() {
        String s = "/exam/haha";
        System.out.print(s.substring(0));
    }


    @Test
    public void checkLoginTest() throws Exception {
        System.out.println(studentService.checkLogin(2015012007, "2015012007").getStuName());
    }

}
