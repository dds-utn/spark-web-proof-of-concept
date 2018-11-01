package server;

import server.security.SecurityService;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void main(String[] args) {
		Spark.port(9000);
		DebugScreen.enableDebugScreen();
		Spark.get("/", (req, res) -> "Holiiiiii");
		SecurityService securityService = new SecurityService("god");
		
		
		Spark.before((req, res) -> {
			try {
				Long userId = securityService.user(req.headers("Authorization").replace("Bearer ", ""));
				//Hacer algo con el id...
			} catch (Exception e) {
				Spark.halt(401, "<h1><a href='https://www.youtube.com/watch?v=0Jx8Eay5fWQ'>Hack me </a></h1><br/><br/><br/><a href='https://www.youtube.com/watch?v=PtLmEARfStE'> El aleph </a>");
			}
		}); 
	}

}
