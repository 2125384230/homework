package com.swufe.javaee.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
    private Map<String, String> userHobby;
    @Override
    public void init() {
        ArrayList input1= new ArrayList();
        input1.add("skiing");
        ArrayList input2= new ArrayList();
        input2.add("knitting");
        ArrayList input3= new ArrayList();
        input3.add("scuba");
        ArrayList input4= new ArrayList();
        input4.add("dating");

       userHobby = new HashMap<>();
       userHobby.put("Bob", "skiing");
       userHobby.put("Jim", "skiing");
       userHobby.put("James", "knitting");
       userHobby.put("Tom", "knitting");
       userHobby.put("Fei", "scuba");
       userHobby.put("Jone", "scuba");
       userHobby.put("Fred", "dating");
       userHobby.put("Pradeep", "dating");
       userHobby.put("Philippe", "dating");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hobby = request.getParameter("hobby");
       List<String> names = new ArrayList<>();
       List<String> users = new ArrayList();
       users.add(hobby);
       userHobby.forEach((k, v) -> {
           if (v.equals(hobby)) {
               names.add(k);
           }
       });
       request.setAttribute("names", names);
       request.setAttribute("hobby", hobby);
       // Two JSPs have different UI styles.
       //  request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
       request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
    }

}
