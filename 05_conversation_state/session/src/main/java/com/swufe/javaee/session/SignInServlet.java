package com.swufe.javaee.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-in.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        String password = req.getParameter("inputPassword");
        String namepath = "F:\\java作业\\java-ee-swufe-master\\05_conversation_state\\session\\src\\main\\resources\\namepassword.txt";
        String check = req.getParameter("Remeber");
        List<String> PandN = Files.readAllLines(Paths.get(namepath));
        Map<String,String> namepassword = new HashMap<>();
        for (String s : PandN) {
            String [] pwd = s.split(" ");
            namepassword.put(pwd[0],pwd[1]);
        }
            if(checkUser(namepassword,name)) {
                if (checkPassword(namepassword, name, password)) {
                    req.getSession().setAttribute("UserId", name);
                    resp.sendRedirect("index");
                    if (check != null) {
                        req.getSession().setMaxInactiveInterval(7 * 24 * 3600);
                    } else {
                        String result = "your password is not right";
                        req.getSession().setAttribute("result", result);
                        RequestDispatcher view = req.getRequestDispatcher("passwordresult.jsp");
                        view.forward(req, resp);
                    }
                }
            else {
                    String result="your UserId is not EXIST";
                    req.getSession().setAttribute("result",result);
                    RequestDispatcher view = req.getRequestDispatcher("passwordresult.jsp");
                    view.forward(req, resp);
                }


            }
        req.getSession().setAttribute("user", name);
        resp.sendRedirect("index");
    }


    public Boolean checkPassword(Map<String,String> namepassword,String name ,String password){
        if(namepassword.get(name).equals(password)){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean checkUser(Map<String,String> namepassord,String name){
        if(namepassord.containsKey(name)){
            return true;
        }
        else {return false;}
    }

}