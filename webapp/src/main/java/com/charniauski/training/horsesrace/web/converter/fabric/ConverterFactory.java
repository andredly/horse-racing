package com.charniauski.training.horsesrace.web.converter.fabric;

import com.charniauski.training.horsesrace.web.converter.GenericConverter;

public interface ConverterFactory<T, D> {

	GenericConverter<T, D> getConverter(Class<D> targetType);

}