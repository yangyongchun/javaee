package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Goods;
import dao.GoodsDao;
import dao.PageBean;

/**
 * Servlet implementation class SearchGoods_qian
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SearchGoods_qian" })
public class SearchGoods_qian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGoods_qian() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PageBean pageGoods=new PageBean();
		String curPage=request.getParameter("curPage");
		if(curPage!=null) {
		int curPage1=Integer.parseInt(curPage);
		System.out.println("asdas"+curPage1);
		pageGoods.setCurPage(curPage1);
		}
		int i=(pageGoods.getCurPage()-1)*pageGoods.getPageSize();
		System.out.println("asdasasdasda"+i);
		GoodsDao gd=new GoodsDao();
		List<Goods> goodslist=null;
		List<Goods> goodslist1=null;
		
			goodslist=gd.getGoodsFenye(i,pageGoods.getPageSize());
		goodslist1=gd.getAllGoods();
		if(goodslist!=null) {
			request.setAttribute("goodslist", goodslist);
		}
		int totalPage=0;
		if(goodslist1.size()%pageGoods.getPageSize()==0) {
			totalPage=goodslist1.size()/pageGoods.getPageSize();
		}else {

			totalPage=goodslist1.size()/pageGoods.getPageSize()+1;
		}
		pageGoods.setTotalPage(totalPage);
		request.setAttribute("pageGoods", pageGoods);
		request.getRequestDispatcher("jsp/goods_qian.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
