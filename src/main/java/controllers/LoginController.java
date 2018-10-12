package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {

	
	public static ModelAndView show(Request req, Response res){
		return new ModelAndView(null, "home/login.hbs");
	}
	
	public static ModelAndView login(Request req, Response res) {
		req.session().attribute("uid", 1);
		res.redirect("/home");
		return null;
	}
	
}
