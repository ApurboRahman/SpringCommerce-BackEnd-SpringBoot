package com.eas.emp.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.core.serializer.Deserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JsonDateHandlar extends StdDeserializer {

  public JsonDateHandlar() {
    this(null);
  }

  private JsonDateHandlar(Class<?> clazz) {
    super(clazz);
  }

  @Override
  public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JsonProcessingException {
      String date = jsonParser.getText();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      try {
          return sdf.parse(date);
      } catch (ParseException e) {
          return null;
      }
  }
}
