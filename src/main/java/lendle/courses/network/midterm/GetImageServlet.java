/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.midterm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.System.out;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author lendle
 */
@WebServlet(name = "GetImageServlet", urlPatterns = {"/image"})
public class GetImageServlet extends HttpServlet {

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
        response.setContentType("image/png");
        String defaultImageString="https://upload.wikimedia.org/wikipedia/commons/9/9a/PNG_transparency_demonstration_2.png";
        /*
        從 request 抓出 parameter id
        以這個 id 從 session 裡面找出對應的 image 網址
        注意，如果是 null，要用 defaultImageString
        利用 IOUtils 的 copy 函式，將 image 輸出
        
        你會利用到 URL 類別的建構子以及 URL 類別的 openStream 函式
        來開啟影像的 InputStream
        */
        String str=(String)request.getParameter("id");
        HttpSession s = request.getSession();
        String id_x = (String)s.getAttribute(str);
        if(id_x==null){
          id_x = defaultImageString;
        }
        try (OutputStream output=response.getOutputStream(); InputStream input=new URL(id_x).openStream()) {
            IOUtils.copy(input, output);
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
//https://vignette.wikia.nocookie.net/fantendo/images/6/6e/Small-mario.png/revision/latest?cb=20120718024112
//https://img00.deviantart.net/8726/i/2012/247/1/5/png_moon_by_paradise234-d5dkuqk.png
//http://www.pngmart.com/files/3/Vector-PNG-File.png