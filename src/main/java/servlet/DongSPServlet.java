package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.DongSP;
import model.MauSac;
import org.apache.commons.beanutils.BeanUtils;
import responsitory.DongSPRespon;

import java.io.IOException;

@WebServlet(name = "DongSPServlet", value = {
        "/DongSPServlet",
        "/view-addDSP",
        "/view-detailDSP",
        "/view-updateDSP",
        "/updateDSP",
        "/addDSP",
        "/deleteDSP"
})
public class DongSPServlet extends HttpServlet {
    DongSPRespon dr=new DongSPRespon();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("DongSPServlet")){
            request.setAttribute("LIST_DSP",dr.getListDSP());
            request.getRequestDispatcher("/viewsDongSP/viewDongSP.jsp").forward(request,response);
        } else if(uri.contains("view-addDSP")) {
            request.getRequestDispatcher("/viewsDongSP/addDSP.jsp").forward(request,response);
        }else if(uri.contains("view-detailDSP")){
            String id=request.getParameter("id");
            request.setAttribute("DSP",dr.getOneDSP(id));
            request.getRequestDispatcher("/viewsDongSP/detailDSP.jsp").forward(request,response);
        }else if(uri.contains("view-updateDSP")){
            String id=request.getParameter("id");
            request.setAttribute("DSP",dr.getOneDSP(id));
            request.getRequestDispatcher("/viewsDongSP/updateDSP.jsp").forward(request,response);
        }else if(uri.contains("deleteDSP")){
            String id=request.getParameter("id");
            DongSP dsp=dr.getOneDSP(id);
            dr.deleteDSP(dsp);
            request.setAttribute("LIST_DSP",dr.getListDSP());
            request.getRequestDispatcher("/viewsDongSP/viewDongSP.jsp").forward(request,response);
        }else{
            request.setAttribute("LIST_DSP",dr.getListDSP());
            request.getRequestDispatcher("/viewsDongSP/viewDongSP.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("addDSP")){
            try {
                DongSP dsp=new DongSP();
                BeanUtils.populate(dsp,request.getParameterMap());
                int checkMS=0;
                for (DongSP d1: dr.getListDSP()
                ) {
                    if(d1.getMa().equalsIgnoreCase(dsp.getMa())){
                        request.setAttribute("LOI_MA","Đã có mã dòng sản phẩm này");

                        checkMS=1;
                    }
                    if(d1.getTen().equalsIgnoreCase(dsp.getTen())){
                        request.setAttribute("LOI_TEN","Đã có tên dòng sản phẩm này");

                        checkMS=1;
                    }
                }
                if(checkMS==1){
                    request.getRequestDispatcher("/viewsDongSP/addDSP.jsp").forward(request,response);
                }else{
                    dr.addDSP(dsp);
                    response.sendRedirect("/view-addDSP");
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        } else if(uri.contains("updateDSP")) {
            try {
                DongSP dsp=new DongSP();
                BeanUtils.populate(dsp,request.getParameterMap());
                dr.updateDSP(dsp);
                response.sendRedirect("/view-updateDSP");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
