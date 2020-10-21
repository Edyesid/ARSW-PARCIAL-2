/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.openweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.openweather"})
public class OpenWeatherApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenWeatherApp.class, args);
        System.out.println("Hello word!");
    }
}