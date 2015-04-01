package cz.fel.osp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/*" })
public class CountingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		/*
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/j/projects/skola/osp/myoutput.txt")));
			for (String word : UniqueCounter.getInstance().getUniques()) {
				bw.write(word);
				bw.write("\n");
			}
			bw.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}*/
		
		PrintWriter out = resp.getWriter();
		out.println(UniqueCounter.getInstance().getUniquesCount());
		
		out.close();
		
	}

}
