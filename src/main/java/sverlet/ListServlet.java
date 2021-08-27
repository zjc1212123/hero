package sverlet;
/**
 * @author Big HandsomeMan
 * @date 2021-05-23 17:58:14
 */

import cn.hutool.db.Entity;
import dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet", value = "/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //实例化dao层对象
        HeroDao heroDao = new HeroDao();
        //查询所有英雄
        List<Entity> heroes = heroDao.listHero();
        request.setAttribute("heroes", heroes);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
