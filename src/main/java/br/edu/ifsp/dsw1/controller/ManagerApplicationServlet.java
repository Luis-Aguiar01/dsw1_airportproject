package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import br.edu.ifsp.dsw1.model.observer.ArrivingTotem;
import br.edu.ifsp.dsw1.model.observer.BoardingTotem;
import br.edu.ifsp.dsw1.model.observer.TakingOffTotem;
import br.edu.ifsp.dsw1.model.observer.TookOffTotem;
import br.edu.ifsp.dsw1.model.observer.Totem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/application.do")
public class ManagerApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightDataCollection flightRepository;
	private Totem arrivingRepository;
	private Totem boardingRepository;
	private Totem takingOffRepository;
	private Totem tookOffRepository;
	
	@Override
	public void init() throws ServletException {
		flightRepository = new FlightDataCollection();
		arrivingRepository = ArrivingTotem.getInstance();
		boardingRepository = BoardingTotem.getInstance();
		takingOffRepository = TakingOffTotem.getInstance();
		tookOffRepository = TookOffTotem.getInstance();
		flightRepository.register(arrivingRepository);
		flightRepository.register(boardingRepository);
		flightRepository.register(takingOffRepository);
		flightRepository.register(tookOffRepository);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		var action = request.getParameter("action");
		var view = "";
		
		if ("login".equals(action)) {
			view = handleLogin(request, response);
		} else if ("logout".equals(action)) {
			view = handleLogout(request, response);
		} else if ("login-page".equals(action)) {
			view = handleLoginPage(request, response);
		} else if ("admin-page".equals(action)) {
			view = handleAdminPage(request, response);
		} else if ("flight-register-page".equals(action)) {
			view = handleFlightRegisterPage(request, response);
		} else if ("flight-register-data".equals(action)) {
			view = handleFlightRegisterData(request, response);
		} else if ("update".equals(action)) {
			view = handleUpdate(request, response);
		} else if ("arriving-page".equals(action)) {
			view = handleArrivingPage(request, response);
		} else if ("boarding-page".equals(action)) {
			view = handleBoardingPage(request, response);
		} else if ("taking-off-page".equals(action)) {
			view = handleTakingOffPage(request, response);
		} else if ("took-off-page".equals(action)) {
			view = handleTookOffPage(request, response);
		}
		
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String handleLoginPage(HttpServletRequest request, HttpServletResponse response) {
		return "login.jsp";
	}
	
	private String handleArrivingPage(
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("arriving-totens", arrivingRepository.getAllTotens());
		return "arriving-page.jsp";
	}
	
	private String handleBoardingPage(
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("boarding-totens", boardingRepository.getAllTotens());
		return "boarding-page.jsp";
	}
	
	private String handleTakingOffPage(
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("taking-off-totens", takingOffRepository.getAllTotens());
		return "taking-off-page.jsp";
	}
	
	private String handleTookOffPage(
			HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("took-off-totens", tookOffRepository.getAllTotens());
		return "took-off-page.jsp";
	}
	
	private String handleLogin(HttpServletRequest request, HttpServletResponse response) {
		var username = request.getParameter("username");
		var password = request.getParameter("password");
		
		if (validateAdminCredentials(username, password)) {
			var session = request.getSession();
			session.setAttribute("authenticate", true);
			return "manager.jsp";
		} else {
			request.setAttribute("error", true);
			return "login.jsp";
		}		
	}
	
	private boolean validateAdminCredentials(String username, String password) {
		return username.equals("admin") && password.equals("admin");
	}
	
	private String handleLogout(HttpServletRequest request, HttpServletResponse response) {
		var session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "index.jsp";
	}
	
	private String handleFlightRegisterPage(HttpServletRequest request, HttpServletResponse response) {
		var session = request.getSession(false);
		if (session != null) {
			request.setAttribute("isLogged", true);
		}
		return "flight_register.jsp";
	}
	
	private String handleAdminPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("flights", flightRepository.getAllFligthts());
		return "manager.jsp";
	}
	
	private String handleUpdate(HttpServletRequest request, HttpServletResponse response) {
		var flightNumber = Long.parseLong(request.getParameter("flight_number"));
		flightRepository.updateFlight(flightNumber);
		request.setAttribute("flights", flightRepository.getAllFligthts());
		return "manager.jsp";
	}
	
	private String handleFlightRegisterData(HttpServletRequest request, HttpServletResponse response) {
		var flightNumber = Long.parseLong(request.getParameter("flight_number"));
		var companyName = request.getParameter("company_name");
		var arrivingTime = request.getParameter("arriving_time");
		
		if (!isFlightNumberAvailable(flightNumber)) {
			request.setAttribute("unavailable-number", true);
		} 
		else if (!isArrivingTimeValid(arrivingTime)) {
			request.setAttribute("invalid-date", true);
		} 
		else {
			var formatedDate = LocalDateTime.parse(arrivingTime)
					.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
			var flight = new FlightData(flightNumber, companyName, formatedDate);
			flight.setState(Arriving.getIntance());

			flightRepository.insertFlight(flight);
			request.setAttribute("sucessful", true);
		}
		
		return "flight_register.jsp";
	}
	
	private boolean isFlightNumberAvailable(long flightNumber) {
		return flightRepository.getAllFligthts().stream()
				.noneMatch(f -> f.getFlightNumber().equals(flightNumber));
	}
	
	private boolean isArrivingTimeValid(String arrivingTime) {
		var arrivingDateTime = LocalDateTime.parse(arrivingTime);
		return arrivingDateTime.isAfter(LocalDateTime.now());
	}
}
