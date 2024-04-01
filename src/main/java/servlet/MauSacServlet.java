package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.MauSac;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.MauSauRespon;

import java.io.IOException;

@WebServlet(name = "MauSacServlet", value ={"/MauSacServlet",
        "/view-addMS",
        "/view-detailMS",
        "/view-updateMS",
        "/updateMS",
        "/addMS",
        "/deleteMS"} )
public class MauSacServlet extends HttpServlet {
    MauSauRespon msr=new MauSauRespon();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("MauSacServlet")){
            request.setAttribute("LIST_MS",msr.getListMS());
            request.getRequestDispatcher("/viewsMS/viewMauSac.jsp").forward(request,response);
        } else if(uri.contains("view-addMS")) {
            request.getRequestDispatcher("/viewsMS/addMS.jsp").forward(request,response);
        }else if(uri.contains("view-detailMS")){
            String id=request.getParameter("id");
            request.setAttribute("MS",msr.getOneMS(id));
            request.getRequestDispatcher("/viewsMS/detailMS.jsp").forward(request,response);
        }else if(uri.contains("view-updateMS")){
            String id=request.getParameter("id");
            request.setAttribute("MS",msr.getOneMS(id));
            request.getRequestDispatcher("/viewsMS/updateMS.jsp").forward(request,response);
        }else if(uri.contains("deleteMS")){
            String id=request.getParameter("id");
            MauSac ms=msr.getOneMS(id);
            msr.deleteMS(ms);
            request.setAttribute("LIST_MS",msr.getListMS());
            request.getRequestDispatcher("/viewsMS/viewMauSac.jsp").forward(request,response);
        }else{
            request.setAttribute("LIST_MS",msr.getListMS());
            request.getRequestDispatcher("/viewsMS/viewMauSac.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("addMS")){
            try {
                MauSac ms=new MauSac();
                BeanUtils.populate(ms,request.getParameterMap());
                int checkMS=0;
                for (MauSac ms1: msr.getListMS()
                ) {
                    if(ms1.getMa().equalsIgnoreCase(ms.getMa())){
                        request.setAttribute("LOI_MA","Đã có mã màu sắc này");

                        checkMS=1;
                    }
                    if(ms1.getTen().equalsIgnoreCase(ms.getTen())){
                        request.setAttribute("LOI_TEN","Đã có tên màu sắc này");

                        checkMS=1;
                    }
                }
                if(checkMS==1){
                    request.getRequestDispatcher("/viewsMS/addMS.jsp").forward(request,response);
                }else{
                    msr.addMS(ms);
                    response.sendRedirect("/view-addMS");
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if(uri.contains("updateMS")) {
            try {
                MauSac ms=new MauSac();
                BeanUtils.populate(ms,request.getParameterMap());
                msr.updateMS(ms);
                response.sendRedirect("/view-updateMS");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
