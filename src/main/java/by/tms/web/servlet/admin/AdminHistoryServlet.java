package by.tms.web.servlet.admin;

import by.tms.entity.User;
import by.tms.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/admin-history")
public class AdminHistoryServlet extends HttpServlet {
    private StorageService storage;

    @Override
    public void init() throws ServletException {
        storage=StorageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminDeleteServlet.getListUsers(req, storage);
        getServletContext().getRequestDispatcher("/pages/admin_pages/admHistory.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> listOperation = storage.findOperationsById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("history", listOperation);
        getServletContext().getRequestDispatcher("/pages/admin_pages/resHistory.jsp").forward(req, resp);
    }
}