package servlets;

import domain.Bucket;
import services.BucketService;
import services.impl.BucketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {

    private	BucketService bucketService = BucketServiceImpl.getBucketService();




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        HttpSession session = request.getSession();
        Integer userId = (Integer)session.getAttribute("userId");

        Bucket bucket = new Bucket(userId, Integer.parseInt(productId), new Date());
        bucketService.create(bucket);


        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }

}
