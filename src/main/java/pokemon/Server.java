package pokemon;

import spark.Spark;

public class Server {
	public static void main(String[] args) {
		Bootstrap.init();
		Spark.port(9000);
		Router.configure();
	}
}
