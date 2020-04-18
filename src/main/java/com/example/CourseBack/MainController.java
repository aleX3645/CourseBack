package com.example.CourseBack;


import com.example.CourseBack.ChartConstructor.LineChart;
import com.example.CourseBack.Entity.Equation;
import com.example.CourseBack.Entity.EquationResponse;
import com.example.CourseBack.repos.EquationRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/equation")
public class MainController {
	@Autowired
	private EquationRepo equationRepository;

	@GetMapping(path="/getEquationById") // Map ONLY POST Requests
	public @ResponseBody
	ResponseEntity<String> GetEquation (@RequestParam Integer id, @RequestParam String lang) {
		try {
			Equation equation = equationRepository.findById(id).get();
			EquationResponse equationResponse = new EquationResponse(equation, lang, new LineChart());

			Gson gson = new Gson();
			return ResponseEntity.ok(gson.toJson(equationResponse));
		}catch(Throwable cause){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
