package cn.dsh.servlet;

import cn.dsh.domain.Student;
import cn.dsh.mapper.TestMapper;
import cn.dsh.utils.SqlSessionFctoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.taglibs.standard.extra.spath.Step;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession sqlSession = SqlSessionFctoryUtil.getSqlSessionFactory().openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);

        request.setCharacterEncoding("utf-8");


        if (Objects.equals("/queryAll.do", request.getServletPath())) {
            List<Student> students = testMapper.findAll();
            request.setAttribute("students", students);
            request.getRequestDispatcher("/WEB-INF/pages/queryAll.jsp").forward(request, response);
        } else if (Objects.equals("/delete.do", request.getServletPath())) {
            String id = request.getParameter("id");
            testMapper.deleteById(Integer.valueOf(id));
            sqlSession.commit();
            response.sendRedirect(request.getContextPath() + "/queryAll.do");
        } else if (Objects.equals("/toinsert.do", request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/pages/insert.jsp").forward(request, response);
        } else if (Objects.equals("/insert.do", request.getServletPath())) {
            String studynum = request.getParameter("studynum");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            Boolean flag = studynum != null && name != null && sex != null
                    && !studynum.equals("") && !name.equals("") && !sex.equals("");
            if (flag) {
                Student student = new Student();
                student.setStudynum(studynum);
                student.setName(name);
                student.setSex(sex);
                testMapper.insertOne(student);

                sqlSession.commit();
                request.setAttribute("prompt", "插入成功");
                request.getRequestDispatcher("/WEB-INF/pages/insert.jsp").forward(request, response);
            } else {
                request.setAttribute("prompt", "请填写完整");
                request.getRequestDispatcher("/WEB-INF/pages/insert.jsp").forward(request, response);
            }
        } else if (Objects.equals("/toupdate.do", request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/pages/update.jsp").forward(request, response);
        } else if (Objects.equals("/findById.do", request.getServletPath())) {
            String id = request.getParameter("id");
            if (id != null && !id.equals("")) {
                Student stu = testMapper.findById(Integer.valueOf(id));
                if (stu != null) {
                    request.setAttribute("student", stu);
                    request.getRequestDispatcher("/WEB-INF/pages/update.jsp").forward(request, response);
                } else {
                    request.setAttribute("prompt", "请填写正确的id");
                    request.getRequestDispatcher("/WEB-INF/pages/update.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("prompt", "请填写id");
                request.getRequestDispatcher("/WEB-INF/pages/update.jsp").forward(request, response);
            }
        } else if (Objects.equals("/updateinfo.do", request.getServletPath())) {
            String id = request.getParameter("id");
            String studynum = request.getParameter("studynum");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");

            Boolean flag = studynum != null && name != null && sex != null
                    && !studynum.equals("") && !name.equals("") && !sex.equals("");

            if (flag) {
                Student student = new Student();
                student.setId(Integer.valueOf(id));
                student.setStudynum(studynum);
                student.setName(name);
                student.setSex(sex);

                testMapper.updateStu(student);
                sqlSession.commit();

                request.setAttribute("prompt", "修改成功");
                request.setAttribute("student", student);
                request.getRequestDispatcher("/WEB-INF/pages/update.jsp").forward(request, response);
            } else {
                request.setAttribute("prompt", "请把信息填写完整");
                request.getRequestDispatcher("/WEB-INF/pages/update.jsp").forward(request, response);
            }
        } else if (Objects.equals("/toquerysome.do", request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/pages/querysome.jsp").forward(request, response);
        } else if (Objects.equals("/querysome.do", request.getServletPath())) {
            String studynum = request.getParameter("studynum");
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");

            Boolean flag = !studynum.equals("") || !name.equals("") || !sex.equals("");

            if (flag) {
                Student student = new Student();
                if (!studynum.equals("")){
                    student.setStudynum(studynum);
                }
                if (!name.equals("")) {
                    student.setName(name);
                }
                if (!sex.equals("")) {
                    student.setSex(sex);
                }

                List<Student> lists = testMapper.findSomeByConditions(student);

                request.setAttribute("students",lists);
                request.setAttribute("prompt", "查询成功");
                request.getRequestDispatcher("/WEB-INF/pages/querysome.jsp").forward(request, response);
            } else {
                request.setAttribute("prompt", "至少填写一个条件");
                request.getRequestDispatcher("/WEB-INF/pages/querysome.jsp").forward(request, response);
            }
        }
        sqlSession.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
