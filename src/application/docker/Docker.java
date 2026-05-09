package application.docker;

import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DockerClientBuilder;

public class Docker {
	
	public static String idDocker;
	public static String nameDocker = "file2print";
	public static boolean status = false; 
	public static DockerClient dockerClient;
	
	public static void setup() {
		
		dockerClient = DockerClientBuilder.getInstance("tcp://localhost:2375").build();
		
		List<Container> containers = dockerClient.listContainersCmd().withShowAll(true).exec();
		
		
		for(Container c: containers) {
			
			if(c.getImage().equals(nameDocker)) {
				
				idDocker = c.getId();
				
				if(c.getStatus().contains("Up")) {
					System.out.println(c.getImage() + " is up!");
					status = true;
					
				}else {
					System.out.println(c.getImage() + " is down!");
					status = false;
					
				}
				
			}
			
		}
	}
	
	
	public static void start() {
		
		if(status == false) {
			dockerClient.startContainerCmd(idDocker).exec();
			status = true;
		}
		
	}
	
	public static void stop() {
		
		if(status == true) {
			dockerClient.killContainerCmd(idDocker).exec();
			status = false;
		}
	}
	
}
