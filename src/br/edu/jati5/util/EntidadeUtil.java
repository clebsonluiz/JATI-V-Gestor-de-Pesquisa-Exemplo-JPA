package br.edu.jati5.util;

public interface EntidadeUtil {

	public static double parceValorToDouble(String value)
	{
		Double d;
		try
		{
			d = Double.parseDouble(value);
		}
		catch (Exception e)
		{
			if(value.contains(","))
			{
				value = value.replace(",", ".");
				
					try
					{
						d = Double.parseDouble(value);
					}
					catch (Exception e1)
					{
						return 1;
					}
			}
			else if(value.trim().equals(""))
				return 1;
			else return 1;
		}
		
		return d.doubleValue();
	}
	
}