package com.note.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date> {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	
  @Override
  public void serialize(Date value, JsonGenerator jgen,
    SerializerProvider provider) throws IOException {
    String formattedDate = SDF.format(value);
    jgen.writeString(formattedDate);
  }
}
