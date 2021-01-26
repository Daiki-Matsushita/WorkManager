package com.dreamhanks.HappyBeautyManager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dreamhanks.HappyBeautyManager.dto.Manager;


/**
 * ログインするためのFilter
 * @author elmu
 *
 */

public class LoginFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		HttpSession session=httprequest.getSession();
		String url = httprequest.getRequestURI();
		Manager UserInfo =(Manager) session.getAttribute("userInfo");
		
		//ログイン成功した場合
		if(UserInfo!=null) {
			if(url.equals("#")) {
				try {
					httpresponse.sendRedirect("#");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(url.equals("#")||url.equals("#")||url.equals("#")||url.equals("#")||url.equals("#")||url.equals("#")) {
				try {
					chain.doFilter(request, response);
					return;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(url.equals("#")) {
				try {
					httpresponse.sendRedirect("#");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		//ログイン成功できなかった場合
		else if(url.equals("#")||url.equals("#")) {
			try {
				httpresponse.sendRedirect("#");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//ログインできた場合　次の実行のために
			try {
				chain.doFilter(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(url.equals("#")){
			try {
				chain.doFilter(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// else文がない場合初めてアドレスで接続した時、３４行目無限ループ 
			else {
			try {
				chain.doFilter(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
