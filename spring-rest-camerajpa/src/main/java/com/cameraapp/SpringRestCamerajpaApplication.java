package com.cameraapp;

import com.cameraapp.model.Camera;
import com.cameraapp.model.CameraType;
import com.cameraapp.model.LensType;
import com.cameraapp.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestCamerajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestCamerajpaApplication.class, args);
	}
}
