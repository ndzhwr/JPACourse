package me.rexisn.JPACourse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {

    public static void main(String[] args) {
        System.out.println("Running Servlet App");
    }
    private static final Gson GSON = new GsonBuilder().create();
    public static final TestSystem ts(){
        return new TestSystem();
    }

    @Override
    protected void  doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String uri = req.getRequestURI();
        Long id = Long.parseLong(uri.substring("/todos".length()));

        String json = GSON.toJson(ts().getCustomers());
        res.setStatus(200);
        res.setHeader("Content-Type","application/json");
        res.getOutputStream().println(json);
    }
}
