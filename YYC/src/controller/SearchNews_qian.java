package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Goods;
import dao.GoodsDao;
import dao.News;
import dao.NewsDao;
import dao.PageBean;

/**
 * Servlet implementation class SearchNews_qian
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SearchNews_qian" })
public class SearchNews_qian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNews_qian() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PageBean pageNews=new PageBean();
		String curPage=request.getParameter("curPage");
		if(curPage!=null) {
		int curPage1=Integer.parseInt(curPage);
		
		pageNews.setCurPage(curPage1);}
		int i=(pageNews.getCurPage()-1)*pageNews.getPageSize();
		NewsDao nd=new NewsDao();
		List<News> newslist=null;
		List<News> newslist1=null;
		newslist=nd.getNewsFengye(i,pageNews.getPageSize());
		Collections.sort(newslist, new Comparator<News>() {
            public int compare(News arg0, News arg1) {
                String time0 = arg0.getTime();
                String time1 = arg1.getTime();
                if (time0.compareTo(time1)>0) {
                    return 1;
                } else if (time1 == time0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
		newslist1=nd.getAllNews();
		if(newslist!=null) {
			request.setAttribute("newslist", newslist);
		}
		int totalPage=0;
		if(newslist1.size()%pageNews.getPageSize()==0) {
			totalPage=newslist1.size()/pageNews.getPageSize();
		}else {

			totalPage=newslist1.size()/pageNews.getPageSize()+1;
		}
		pageNews.setTotalPage(totalPage);
		request.setAttribute("pageNews", pageNews);
		request.getRequestDispatcher("jsp/news_qian.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
