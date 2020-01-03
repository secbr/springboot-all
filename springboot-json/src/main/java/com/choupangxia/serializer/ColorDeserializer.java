package com.choupangxia.serializer;

import com.choupangxia.entity.ColorDetail;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.boot.jackson.JsonComponent;

import java.awt.*;
import java.io.IOException;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/2 11:25 AM
 **/
@JsonComponent
public class ColorDeserializer extends JsonDeserializer<ColorDetail> {

	@Override
	public ColorDetail deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		TreeNode treeNode = p.getCodec().readTree(p);
		TextNode webColor = (TextNode) treeNode.get("webColor");

		Color color = Color.decode(webColor.asText());

		ColorDetail detail = new ColorDetail();
		detail.setRed(color.getRed());
		detail.setGreen(color.getGreen());
		detail.setBlue(color.getBlue());

		return detail;
	}
}
