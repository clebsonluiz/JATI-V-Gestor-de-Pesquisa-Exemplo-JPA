package br.edu.jati5.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import br.edu.jati5.util.ChartsUtil;
import br.edu.jati5.util.ViewUtil;

public class TelaGrafico extends MeuJPanel {

	private static final long serialVersionUID = 1L;
	
	protected static final String g_barras = "0";
	protected static final String g_pizza = "1";
	protected static final String g_anel = "2";
	protected static final String g_linha = "3";
	
	private JFreeChart chart_bar;
	private JFreeChart chart_pie;
	private JFreeChart chart_halo;
	private JFreeChart chart_line;
	
	
	public TelaGrafico() {
		super(new BorderLayout());
		
		MeuJPanel meuJPanel = new MeuJPanel();
		meuJPanel.setBorder(ViewUtil.Bordas.border1);
		meuJPanel.setName("PanelRadio");
		add(meuJPanel, BorderLayout.NORTH);
		
		JToggleButton rdbtnBarras = new JToggleButton("Barras");
		rdbtnBarras.setSelected(true);
		meuJPanel.add(rdbtnBarras);
		
		JToggleButton rdbtnPizza = new JToggleButton("Pizza");
		meuJPanel.add(rdbtnPizza);
		
		JToggleButton rdbtnAnel = new JToggleButton("Anel");
		meuJPanel.add(rdbtnAnel);
		
		JToggleButton rdbtnLinha = new JToggleButton("Linha");
		meuJPanel.add(rdbtnLinha);
		
		MeuJPanel graficoPanel = new MeuJPanel(new CardLayout());
		graficoPanel.setName("PanelGrafico");
		
		add(graficoPanel, BorderLayout.CENTER);
		
		chart_bar = ChartsUtil.getBarras("", "", "");
		chart_pie = ChartsUtil.getPizza("");
		chart_halo = ChartsUtil.getAnel("");
		chart_line = ChartsUtil.getLinha("", "", "");
		
		chart_pie.setBackgroundPaint(graficoPanel.getBackground());
		chart_pie.getPlot().setBackgroundPaint(graficoPanel.getBackground());
		chart_pie.getLegend().setBackgroundPaint(getBackground());
		chart_halo.setBackgroundPaint(graficoPanel.getBackground());
		chart_halo.getPlot().setBackgroundPaint(graficoPanel.getBackground());
		chart_halo.getLegend().setBackgroundPaint(getBackground());
		
		graficoPanel.add(new ChartPanel(chart_bar), g_barras);
		graficoPanel.add(new ChartPanel(chart_pie), g_pizza);
		graficoPanel.add(new ChartPanel(chart_halo), g_anel);
		graficoPanel.add(new ChartPanel(chart_line), g_linha);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnBarras);
		bg.add(rdbtnPizza);
		bg.add(rdbtnAnel);
		bg.add(rdbtnLinha);
		
		rdbtnBarras.addItemListener(ItemEvent->
		{
			((CardLayout)graficoPanel.getLayout()).show(graficoPanel, g_barras);
		});
		rdbtnPizza.addItemListener(ItemEvent->
		{
			((CardLayout)graficoPanel.getLayout()).show(graficoPanel, g_pizza);
		});
		rdbtnAnel.addItemListener(ItemEvent->
		{
			((CardLayout)graficoPanel.getLayout()).show(graficoPanel, g_anel);
		});
		rdbtnLinha.addItemListener(ItemEvent->
		{
			((CardLayout)graficoPanel.getLayout()).show(graficoPanel, g_linha);
		});
		
	}

	protected void chartExclusivo(String g_chart)
	{
		getComponent(0).setVisible(false);;
		((CardLayout)((MeuJPanel)getComponent(1)).getLayout()).show((MeuJPanel)getComponent(1), g_chart);;
	}
	
	public void clearValues()
	{
		((DefaultCategoryDataset)chart_bar.getCategoryPlot().getDataset()).clear();
		((DefaultPieDataset)((PiePlot)chart_pie.getPlot()).getDataset()).clear();
		((DefaultPieDataset)((PiePlot)chart_halo.getPlot()).getDataset()).clear();;
		((DefaultCategoryDataset)chart_line.getCategoryPlot().getDataset()).clear();
	}
	
	public void addValues(Double value, String rowKey, String columnKey)
	{
		ordenar_categoria((DefaultCategoryDataset)chart_bar.getCategoryPlot().getDataset(), value, rowKey, columnKey);
		((DefaultPieDataset)((PiePlot)chart_pie.getPlot()).getDataset()).setValue(rowKey, value);
		((DefaultPieDataset)((PiePlot)chart_halo.getPlot()).getDataset()).setValue(rowKey, value);
		((DefaultCategoryDataset)chart_line.getCategoryPlot().getDataset()).addValue(value, rowKey, columnKey);
	}
	
	public void setNomeCategoria(String titulo, String yAxis, String xAxis)
	{
		chart_bar.setTitle(titulo);
		chart_bar.getCategoryPlot().getRangeAxis().setLabel(yAxis);
		chart_bar.getCategoryPlot().getDomainAxis().setLabel(xAxis);
		chart_line.setTitle(titulo);
		chart_line.getCategoryPlot().getRangeAxis().setLabel(yAxis);
		chart_line.getCategoryPlot().getDomainAxis().setLabel(xAxis);
		chart_pie.setTitle(titulo);
		chart_halo.setTitle(titulo);
	}
	
	private void ordenar_categoria(CategoryDataset dataSet, Double value, String rowKey, String columnKey)
	{
		
		if(((DefaultCategoryDataset)dataSet).getColumnIndex(columnKey) >= 0 && ((DefaultCategoryDataset)dataSet).getRowIndex(rowKey) >= 0)
		{
			if(((DefaultCategoryDataset)dataSet).getValue(rowKey, columnKey) == null)
			{
				((DefaultCategoryDataset)dataSet).addValue(value, rowKey, columnKey);
			}
			else
			{
				value = value + ((DefaultCategoryDataset)dataSet).getValue(rowKey, columnKey).doubleValue();
				
				((DefaultCategoryDataset)dataSet).setValue(value, rowKey, columnKey);
			}
		}
		else
		{
			((DefaultCategoryDataset)dataSet).addValue(value, rowKey, columnKey);
		}
	}
}
