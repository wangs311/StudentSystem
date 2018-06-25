import com.nenu.software.common.entity.Student;
import com.nenu.software.common.entity.Teacher;
import com.nenu.software.service.StudentService;
import com.nenu.software.service.TeacherService;
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
public class TeacherServiceTest {

    @Autowired
    TeacherService teacherService;

    @Test
    public void testNewTeacher() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setTeaName("tt");
//        student.setStuNum(2015011969);
        teacher.setTeaNum("666888");
        teacherService.newTeacher(teacher);
        System.out.println("new over");
    }

    @Test
    public void testDeleteTeacher() throws Exception {
        teacherService.deleteTeacherById(1);
        System.out.println("delete over");
    }

    @Test
    public void testDeleteTeacherByStuNum() throws Exception {
        teacherService.deleteTeacherByTeaNum("666888");
        System.out.println("delete Over");
    }

    @Test
    public void testUpdateStudent() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setId(4);
        teacher.setTeaName("aa");
        teacher.setTeaNum("111111");
        teacherService.updateTeacher(teacher);
    }

    @Test
    public void testSelect() throws Exception {
        System.out.println(teacherService.selectTeacherById(4));
        System.out.println(teacherService.selectTeacherByTeaNum("111111"));
        System.out.println(teacherService.listTeacherByConditions(null, null));
    }
}
