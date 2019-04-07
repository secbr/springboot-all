package com.secbro2.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * banner学习
 *
 * @author zzs
 */
@SpringBootApplication
public class SpringbootBannerApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(SpringbootBannerApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}

}
