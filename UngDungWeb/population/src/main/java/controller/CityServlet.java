package controller;

import model.City;
import service.CityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CityServlet", urlPatterns = "/CityServlet")
public class CityServlet extends HttpServlet {
    private final CityService cityService = new CityService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("param");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createGet":
                createGet(request, response);
                break;
            case "createPost":
                createPost(request, response);
                break;
            case "sort":
                sortCities(request, response);
                break;
            case "search":
                searchCities(request, response);
                break;
            default:
                displayAllCity(request, response);
        }
    }
    private void searchCities(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search-name");
        ArrayList<City> cities = cityService.searchCityByName(search);
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }


    private void sortCities(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<City> cities = cityService.sortCityList();
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double area = Double.parseDouble(request.getParameter("area"));
        double population = Double.parseDouble(request.getParameter("population"));
        double gdp = Double.parseDouble(request.getParameter("gdp"));
        String countryName = request.getParameter("countryName");
        cityService.createCity(new City(id, name, area, population, gdp, countryName));
        ArrayList<City> cities = cityService.getCityList();
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("create.jsp");
    }

    private void displayAllCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<City> cities = cityService.getCityList();
        request.setAttribute("cities", cities);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

}
