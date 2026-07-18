/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Numbers;

/**
 *
 * @author tusieumap
 */
public class gcdservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet gcdservlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet gcdservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String number1 = request.getParameter("num1");
        String number2 = request.getParameter("num2");
        String number3 = request.getParameter("num3");
        int result = 0;

        try {
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(number2);
            int num3 = Integer.parseInt(number3);

            List<Numbers> list = (List<Numbers>) session.getAttribute("records");
            if (list == null) {
                list = new ArrayList<>();
                session.setAttribute("records", list);
            }

            // Kiểm tra trùng
            boolean exists = false;
            for (Numbers record : list) {
                if (record.getNumber1() == num1
                        && record.getNumber2() == num2
                        && record.getNumber3() == num3) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                request.setAttribute("error", "Execution existed!");
            } else {
                result = gcd3(num1, num2, num3);
                Numbers record = new Numbers(num1, num2, num3, result);
                list.add(record);
            }

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input!");
        }

        request.getRequestDispatcher("MyExam.jsp").forward(request, response);
    }

    private int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    private int gcd3(int a, int b, int c) {
        int gcdAB = gcd(a, b);
        return gcd(gcdAB, c);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
