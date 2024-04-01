package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ChucVu;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.ChucVuRespon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ChucVuServlet",
        value ={"/ChucVuServlet",
                "/view-addCV",
                "/view-detailCV",
                "/view-updateCV",
                "/updateCV",
                "/addCV",
                "/deleteCV"} )
public class ChucVuServlet extends HttpServlet {

    ChucVuRespon cvr=new ChucVuRespon();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uri=request.getRequestURI();
    if(uri.contains("ChucVuServlet")){
        request.setAttribute("LIST_CV",cvr.getList());
        System.out.println(cvr.getList());
        request.getRequestDispatcher("/viewsCV/viewChucVu.jsp").forward(request,response);
    }else if(uri.contains("view-addCV")){
        request.getRequestDispatcher("/viewsCV/addChucVu.jsp").forward(request,response);
    }else if(uri.contains("view-detailCV")){
        String id=request.getParameter("id");
        request.setAttribute("CV",cvr.getOne(id));
        request.getRequestDispatcher("/viewsCV/detailCV.jsp").forward(request,response);
    }else if(uri.contains("view-updateCV")){
        String id=request.getParameter("id");
        request.setAttribute("CV",cvr.getOne(id));
        request.getRequestDispatcher("/viewsCV/updateCV.jsp").forward(request,response);
    }else if(uri.contains("deleteCV")){
        String id=request.getParameter("id");
        ChucVu cv=cvr.getOne(id);
        cvr.deleteCV(cv);
        request.setAttribute("LIST_CV",cvr.getList());
        request.getRequestDispatcher("/viewsCV/viewChucVu.jsp").forward(request,response);
    }else{
        request.setAttribute("LIST_CV",cvr.getList());
        request.getRequestDispatcher("/viewsCV/viewChucVu.jsp").forward(request,response);
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uri=request.getRequestURI();
    if(uri.contains("addCV")){
        try {
            ChucVu cv=new ChucVu();
            BeanUtils.populate(cv,request.getParameterMap());
            int checkCV=0;
            for (ChucVu cv1: cvr.getList()
                 ) {
                if(cv1.getMa().equalsIgnoreCase(cv.getMa())){
                    request.setAttribute("LOI_MA","Đã có mã chức vụ này");

                    checkCV=1;
                }
                if(cv1.getTen().equalsIgnoreCase(cv.getTen())){
                    request.setAttribute("LOI_TEN","Đã có tên chức vụ này");

                    checkCV=1;
                }
            }
            if(checkCV==1){
                request.getRequestDispatcher("/viewsCV/addChucVu.jsp").forward(request,response);
            }else{
                cvr.addCV(cv);
                response.sendRedirect("/view-addCV");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }else if(uri.contains("updateCV")){
        try {
            ChucVu cv=new ChucVu();
            BeanUtils.populate(cv,request.getParameterMap());
            cvr.updateCV(cv);
            response.sendRedirect("/view-updateCV");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    }
}
