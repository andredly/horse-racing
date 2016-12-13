package com.charniauski.training.horsesrace.web.serializer;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;


@Component
public class JsonDateSerializer extends JsonSerializer<Date> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");

    @Override
    public void serialize(Date date, JsonGenerator gen, SerializerProvider provider)

            throws IOException, JsonProcessingException {

        String formattedDate = dateFormat.format(date);

        gen.writeString(formattedDate);

    }

}