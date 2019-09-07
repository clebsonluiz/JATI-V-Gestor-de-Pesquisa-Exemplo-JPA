/**
 * 
 */
package br.edu.jati5.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ConverterLocalDate implements AttributeConverter<LocalDate, Date> 
{
	@Override
	public Date convertToDatabaseColumn(LocalDate localDate) 
	{
		return localDate == null? null : Date.valueOf(localDate);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date sqlDate)
	{
		return sqlDate == null ? null : sqlDate.toLocalDate();
	}
}
