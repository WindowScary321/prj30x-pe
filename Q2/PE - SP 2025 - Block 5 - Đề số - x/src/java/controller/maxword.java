/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.StringClass;

@WebServlet("/check")
public class maxword extends HttpServlet {

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
            out.println("<title>Servlet maxword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet maxword at " + request.getContextPath() + "</h1>");
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
        List<StringClass> stringRecords = (List<StringClass>) session.getAttribute("stringRecords");

        String str = request.getParameter("str");
        String action = request.getParameter("action");
        String result = "";

        request.setAttribute("str", str); // lưu thông tin của String đã nhập
        
        // khởi tạo list
        if (stringRecords == null) {
            stringRecords = new ArrayList<>();
            session.setAttribute("stringRecords", stringRecords);
        }

        if (str == null || str.trim().isEmpty()) {
            request.setAttribute("message", "You must input string str");
            request.getRequestDispatcher("MyExam.jsp").forward(request, response);
            return;
        }

        if ("maxword".equals(action)) {
            result = findMaxWord(str);
            request.setAttribute("result", result);
            stringRecords.add(new StringClass(str, result)); // Thêm dòng mới vào bảng, ko ghi đè dòng cũ
            session.setAttribute("stringRecords", stringRecords); // Cập nhật list vào session
        } else if ("sort".equals(action)) {
            stringRecords.sort((r1, r2) -> r1.getStr().compareToIgnoreCase(r2.getStr()));
            session.setAttribute("stringRecords", stringRecords);
        }

        request.getRequestDispatcher("MyExam.jsp").forward(request, response);
    }

    private String findMaxWord(String str) {
        String[] words = str.trim().split("\\s+");

        String max = words[0];
        for (String word : words) {
            if (word.length() > max.length()) {
                max = word;
            }
        }
        return max;
    }

    private String sortWords(String str) {
        String[] words = str.trim().split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return String.join(" ", words);
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
