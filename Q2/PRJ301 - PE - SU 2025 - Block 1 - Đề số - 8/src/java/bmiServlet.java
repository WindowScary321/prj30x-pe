/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import entity.BmiRecord;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class bmiServlet extends HttpServlet {

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
            out.println("<title>Servlet bmiServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet bmiServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();;

        String heightStr = request.getParameter("height");
        String weightStr = request.getParameter("weight");
        String conclude = "";

        request.setAttribute("height", heightStr);
        request.setAttribute("weight", weightStr);

        try {
            int height = Integer.parseInt(heightStr);
            int weight = Integer.parseInt(weightStr);

            if (height < 10 || weight < 10) {
                request.setAttribute("error", "Height/Weight must be an integer >=10");
            } else {
                double heightM = height / 100.0;
                double bmi = weight / (heightM * heightM);
                if (bmi < 18.5) {
                    conclude = "Underweight";
                } else if (bmi < 25) {
                    conclude = "Normal";
                } else if (bmi < 30) {
                    conclude = "Slightly overweight";
                } else {
                    conclude = "Obese";
                }

                BmiRecord record = new BmiRecord(height, weight, bmi, conclude); // tạo đối tượng 
                List<BmiRecord> list = (List<BmiRecord>) session.getAttribute("bmiRecords"); // thêm vào danh sách
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(record);
                session.setAttribute("bmiRecords", list);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input!");
        }

        request.getRequestDispatcher("MyExam.jsp").forward(request, response);
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
