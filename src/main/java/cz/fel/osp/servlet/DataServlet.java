package cz.fel.osp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/*" })
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UniqueCounter uc = UniqueCounter.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(req.getInputStream(), Charset.forName("utf-8")));
		
		String line = null;
		while((line = br.readLine()) != null) {
			String[] split = line.split("\\s");
			
			for (String word : split) {
				uc.addWord(word);
			}
		}
		
		resp.setStatus(204);
	}
	
	public static void main(String[] args) {
		
	}

}
