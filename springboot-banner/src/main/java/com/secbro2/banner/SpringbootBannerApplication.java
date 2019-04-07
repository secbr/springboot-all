package com.secbro2.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.ImageBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

/**
 * banner学习
 *
 * @author zzs
 */
@SpringBootApplication
public class SpringbootBannerApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(SpringbootBannerApplication.class);

//		Banner banner = new ImageBanner(new ClassPathResource("banner1.png"));
//		app.setBanner(banner);
//		app.setBannerMode(Banner.Mode.OFF);

		app.run(args);
	}

}
