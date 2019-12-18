package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ��Ϊͬһ��ҳ�治�ܳ��������������Ը���jsʵ��ˢ��ҳ�档���ǻ���ֵ�������ˢ��Ҳ���Զ���һ��
 * @author AricSun
 * @date 2019/12/16 21:14
 */
@WebServlet(urlPatterns = {"/topic.showBelowTopic", "/topic.showAfterTopic"})
public class topicSwitchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("12123");
        super.service(req, resp);
        String path = req.getServletPath();
        if (path.equals("/topic.showBelowTopic")){
            showBelowTopic(req,resp);
        }else if (path.equals("/topic.showAfterTopic")){
            showAfterTopic(req,resp);
        }
    }
    /*
     * function: ip��ʾ��ȡ������Ŀid�����ڻ�ͱ�������Ŀid��ͻ�����Ի���һ�����֣�
     * ������������Ѿ���������js��ʹ�õ���current_id
     * @Param: [request, response]
     * @Return: void
     */
    protected void showBelowTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ip = (int) request.getSession().getAttribute("current_id");
        if (ip>0){
            ip--;
        }
        request.getSession().setAttribute("current_id", ip);
//        return;
        request.getRequestDispatcher("/web/test.jsp");
    }

    protected void showAfterTopic(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int ip = (int) request.getSession().getAttribute("current_id");
        if (ip < 10){//��ʱд��10�������Ŀ����Ļ�����Ҫ��ȡ�����Ŀ������˳����ϰ����ȡ������Ŀ��
            ip++;
        }
        request.getSession().setAttribute("current_id", ip);
//        response.sendRedirect(request.getContextPath()+"/test.jsp");
        request.getRequestDispatcher("/web/test.jsp");
    }
}
