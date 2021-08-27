package sverlet;

import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import dao.HeroDao;
import entity.Hero;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Big HandsomeMan
 * @date 2021-05-25 10:52:00
 */

@WebServlet(name = "AddServlet", value = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        //接收前端参数
        String heroJson = request.getParameter("hero");
        //实例化对象并把前端获取到的值填进去
        Hero hero = JSONUtil.toBean(heroJson, Hero.class);
        //实例化dao层对象
        HeroDao heroDao = new HeroDao();
        //调用dao层添加英雄方法
        boolean state = heroDao.addHero(hero);
        //定义前端状态值
        String code;
        if (state) {
            System.out.println("添加成功");
            code = "0";
        } else {
            System.out.println("添加失败");
            code = "1";
        }
        //构建前端返回值
        PrintWriter writer = response.getWriter();
        writer.write(code);
    }
}
