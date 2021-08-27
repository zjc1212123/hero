package sverlet;
/**
 * @author Big HandsomeMan
 * @date 2021-05-23 18:29:30
 */

import dao.HeroDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        //实例化dao层对象
        HeroDao heroDao = new HeroDao();
        //获取英雄id
        int id = Integer.parseInt(request.getParameter("id"));
        //调用dao层的deleteHero方法
        boolean state = heroDao.deleteHero(id);
        //定义一个返回前端的状态值
        String code;
        if (state) {
            System.out.println("删除成功！");
            code = "0";
        } else {
            System.out.println("删除失败！");
            code = "1";
        }
        //把获取到的状态值返回前端
        PrintWriter writer = response.getWriter();
        writer.write(code);
    }
}
