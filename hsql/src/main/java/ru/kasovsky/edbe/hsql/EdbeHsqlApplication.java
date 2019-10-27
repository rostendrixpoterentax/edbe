package ru.kasovsky.edbe.hsql;

import lombok.extern.slf4j.Slf4j;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
@Slf4j
public class EdbeHsqlApplication {

	static String serverPort;

	@Value("${server.port}")
	public void setDatabase(String serverPort) {
		this.serverPort = serverPort;
	}

	public static void main(String[] args) {
		SpringApplication.run(EdbeHsqlApplication.class, args);
		log.info(String.format("Open url http://localhost:%s/jsondoc-ui.html?url=http://localhost:%s/jsondoc", serverPort, serverPort));
	}

}
