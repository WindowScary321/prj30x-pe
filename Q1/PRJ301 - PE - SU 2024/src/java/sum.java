/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author tusieumap
 */
public class sum extends HttpServlet {

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
        String input = request.getParameter("input");
        String option = request.getParameter("option");
        String result = "";

        if (input == null || input.trim().isEmpty()) {
            result = "input is empty";
        } else {
            String[] numberStrs = input.split(",");
            int[] numbers = new int[numberStrs.length];

            int index = 0;
            boolean resultInt = true;
            for (String numberStr : numberStrs) {
                try {
                    numbers[index] = Integer.parseInt(numberStr);
                    index++;
                } catch (NumberFormatException nfe) {
                    resultInt = false;
                    break;
                }
            }
            
            int sumOdd = 0;
            int sumEven = 0;
            for (int num : numbers){
                if (num%2==0){
                    sumEven += num;
                }else{
                    sumOdd += num;
                }
            }
            
            if (resultInt) {
                if("Even".equals(option)){
                    result = String.valueOf(sumEven);
                }else if("Odd".equals(option)){
                    result = String.valueOf(sumOdd);
                }
            }else{
                result = "You must input an integer array";
            }

        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sum</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id='txtResult'>" + result + "</div>");
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
        processRequest(request, response);
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
