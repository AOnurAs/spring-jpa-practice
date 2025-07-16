package com.AOA.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Props {
	
	// this class is created to get the values in configuration using @ConfigurationProperties annotation
	// this annotation is used inside class GlobalConfigurationProperties
	
	private String ip;
	
	private String loc;
}
