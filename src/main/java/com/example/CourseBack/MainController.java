package com.example.CourseBack;


import com.example.CourseBack.ChartConstructor.LineChart;
import com.example.CourseBack.Entity.Equation;
import com.example.CourseBack.Entity.EquationResponse;
import com.example.CourseBack.repos.EquationRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/equation")
public class MainController {
	@Autowired
	private EquationRepo equationRepository;

	@GetMapping(path="/getEquationById") // Map ONLY POST Requests
	public @ResponseBody String GetEquation (@RequestParam Integer id) {
		Equation equation = equationRepository.findById(id).get();
		EquationResponse equationResponse = new EquationResponse(equation, new LineChart());

		Gson gson = new Gson();
		return gson.toJson(equationResponse);
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Equation> getAllUsers() {
		// This returns a JSON or XML with the users
		return equationRepository.findAll();
	}
}
