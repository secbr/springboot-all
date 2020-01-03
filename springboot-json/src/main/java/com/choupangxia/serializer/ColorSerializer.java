package com.choupangxia.serializer;

import com.choupangxia.entity.ColorDetail;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/2 11:25 AM
 **/
@JsonComponent
public class ColorSerializer extends JsonSerializer<ColorDetail> {

	@Override
	public void serialize(ColorDetail colorDetail, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("webColor", getColorAsWebColor(colorDetail));
		gen.writeEndObject();
	}

	private static String getColorAsWebColor(ColorDetail colorDetail) {
		int r = (int) Math.round(colorDetail.getRed() * 255.0);
		int g = (int) Math.round(colorDetail.getGreen() * 255.0);
		int b = (int) Math.round(colorDetail.getBlue() * 255.0);
		return String.format("#%02x%02x%02x", r, g, b);
	}

}
