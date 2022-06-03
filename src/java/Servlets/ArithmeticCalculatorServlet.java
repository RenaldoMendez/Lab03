
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renaldo
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalulator.jsp").forward(request, response);
     return;
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // declare variables
        String errorMessage = "invalid";
        double valueOne = 0;
        double valueTwo = 0;
        double total = 0;
        String placeHolder = "---";
        
        String firstinput = request.getParameter("firstInput");
        String secondinput = request.getParameter("secondInput");
        request.setAttribute("userValueOne", firstinput);
        request.setAttribute("userValueTwo", secondinput);
        request.setAttribute("output", placeHolder);
       // getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalulator.jsp").forward(request, response);
       // return;
        // check if input is valid; if not, display error message
        if (firstinput.equals("") || firstinput == null || secondinput.equals("") || secondinput == null){
            request.setAttribute("output", errorMessage);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalulator.jsp").forward(request, response);
        return;
        }
        try{
            valueOne = Double.parseDouble(firstinput);
            valueTwo = Double.parseDouble(secondinput);
            
        }catch(Exception e){
        request.setAttribute("output", errorMessage);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalulator.jsp").forward(request, response);
        return;
        }
       
        // perform calculations
        String operationType = request.getParameter("operation");
        switch(operationType){
                case "+": total = valueOne + valueTwo;
                    break;
                case "-": total = valueOne - valueTwo;
                    break;
                case "*": total = valueOne * valueTwo;
                    break;
                case "%": total = valueOne % valueTwo;
                    break;
            }
        
        // display total
        request.setAttribute("output", Math.round(total));
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalulator.jsp").forward(request, response);
        return;
    }


}
