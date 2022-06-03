
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
public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       // Get requests end up here!
       
       // This will load a JSP from the servlet.
       getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
       return;
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //post requests end up here
        
        //capture incoming parameters and save into double variable
        String ageinput = request.getParameter("userAge");
        
        
        if (ageinput == null || ageinput.equals("")){
            //Define an error message
            String message = "You must enter your current age";
            // Set the error message in the request object as a variable
            request.setAttribute("message", message);
            //show the agecalculator jsp to the customer again
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            //stop the code call
            return;
        }
         int convertedAge = 0;
        try{
        convertedAge = Integer.parseInt(ageinput);
        }catch(Exception e ){
            String message = "You must enter a number.";
            // Set the error message in the request object as a variable
            request.setAttribute("message", message);
            //show the agecalculator jsp to the customer again
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            //stop the code call
            return;
        }
        
        
        ++convertedAge;
        
        
        String outputmessage = "Your age next birthday will be " + convertedAge;
        //System.out.println(outputmessage);
         
        //set up attributes in the request object, to be sent to the JSP
        request.setAttribute("outputMessage", outputmessage);
        
        // Load the JSP and forward the request object (contains attributes)
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response); // not using the response object at the moment but we forward it for good practice
         // Stop the code call after loading a JSP
         return;
         
         
        // Load the JSP and forward the request object (contains attributes)
       //getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        // Stop the code call after loading a JSP
        //return;
    }

}
