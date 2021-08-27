package sverlet;
/**
 * @author Big HandsomeMan
 * @date 2021-05-23 21:40:36
 */

import cn.hutool.db.Entity;
import dao.HeroDao;
import entity.Hero;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //实例化dao层对象
        HeroDao heroDao = new HeroDao();
        //获取id
        int id = Integer.parseInt(request.getParameter("id"));
        //根据id查询英雄
        Entity hero = heroDao.getHero(id);
        request.setAttribute("hero", hero);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        //实例化dao层对象
        HeroDao heroDao = new HeroDao();
        //实例化hero对象
        Hero hero = new Hero();
        //定义状态值
        boolean state = heroDao.updateHero(hero);
        //定义返回状态值
        String code;
        if (state) {
            System.out.println("更新成功");
            code = "0";
        } else {
            System.out.println("更新失败");
            code = "1";
        }
        //构建前端返回值
        PrintWriter writer = response.getWriter();
        writer.write(code);
    }
}
