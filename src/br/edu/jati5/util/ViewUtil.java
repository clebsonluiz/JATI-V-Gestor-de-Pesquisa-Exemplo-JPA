package br.edu.jati5.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public interface ViewUtil {
	
	
	public static interface Fonts{
		
		public static interface Times{
			
			public static final Font TIMES_PEQUENO = new Font("Times New Roman", Font.PLAIN, 13);
			public static final Font TIMES_PEQUENO_I = new Font("Times New Roman", Font.ITALIC, 13);
			public static final Font TIMES_PEQUENO_B = new Font("Times New Roman", Font.BOLD, 13);
			public static final Font TIMES_PEQUENO_B_I = new Font("Times New Roman", Font.BOLD+Font.ITALIC, 13);
			
			public static final Font TIMES_TITULO = new Font("Times New Roman", Font.PLAIN, 20);
			public static final Font TIMES_TITULO_I = new Font("Times New Roman", Font.ITALIC, 20);
			public static final Font TIMES_TITULO_B = new Font("Times New Roman", Font.BOLD, 20);
			public static final Font TIMES_TITULO_B_I = new Font("Times New Roman", Font.BOLD+Font.ITALIC, 20);
			
		}
		
		public static interface Arial{
			
			public static final Font ARIAL_PEQUENO = new Font("Arial", Font.PLAIN, 13);
			public static final Font ARIAL_PEQUENO_I = new Font("Arial", Font.ITALIC, 13);
			public static final Font ARIAL_PEQUENO_B = new Font("Arial", Font.BOLD, 13);
			public static final Font ARIAL_PEQUENO_B_I = new Font("Arial", Font.BOLD+Font.ITALIC, 13);
			
			public static final Font ARIAL_MEDIO = new Font("Arial", Font.PLAIN, 15);
			public static final Font ARIAL_MEDIO_I = new Font("Arial", Font.ITALIC, 15);
			public static final Font ARIAL_MEDIO_B = new Font("Arial", Font.BOLD, 15);
			public static final Font ARIAL_MEDIO_B_I = new Font("Arial", Font.BOLD+Font.ITALIC, 15);
			
			public static final Font ARIAL_TITULO = new Font("Arial", Font.PLAIN, 20);
			public static final Font ARIAL_TITULO_I = new Font("Arial", Font.ITALIC, 20);
			public static final Font ARIAL_TITULO_B = new Font("Arial", Font.BOLD, 20);
			public static final Font ARIAL_TITULO_B_I = new Font("Arial", Font.BOLD+Font.ITALIC, 20);
			
			public static final Font ARIAL_TITULO_GIGANTE = new Font("Arial", Font.PLAIN, 26);
			public static final Font ARIAL_TITULO_GIGANTE_I = new Font("Arial", Font.ITALIC, 26);
			public static final Font ARIAL_TITULO_GIGANTE_B = new Font("Arial", Font.BOLD, 26);
			public static final Font ARIAL_TITULO_GIGANTE_B_I = new Font("Arial", Font.BOLD+Font.ITALIC, 26);
			
			
		}
		
	} 
	
	
	public static interface Bordas{
		
		/** https://stackoverflow.com/questions/15025092/border-with-rounded-corners-transparency*/
		public static class TextBubbleBorder extends AbstractBorder {

			private static final long serialVersionUID = 1L;

			private Color color;
		    private int thickness = 4;
		    private int radii = 8;
		    private int pointerSize = 7;
		    private Insets insets = null;
		    private BasicStroke stroke = null;
		    private int strokePad;
		    private int pointerPad = 4;
		    private boolean left = true;
		    RenderingHints hints;

		    public TextBubbleBorder(
		            Color color) {
		        this(color, 4, 8, 7);
		    }

		    public TextBubbleBorder(
		            Color color, int thickness, int radii, int pointerSize) {
		        this.thickness = thickness;
		        this.radii = radii;
		        this.pointerSize = pointerSize;
		        this.color = color;

		        stroke = new BasicStroke(thickness);
		        strokePad = thickness / 2;

		        hints = new RenderingHints(
		                RenderingHints.KEY_ANTIALIASING,
		                RenderingHints.VALUE_ANTIALIAS_ON);

		        int pad = radii + strokePad;
		        int bottomPad = pad + pointerSize + strokePad;
		        insets = new Insets(pad, pad, bottomPad, pad);
		    }

		    public TextBubbleBorder(
		            Color color, int thickness, int radii, int pointerSize, boolean left) {
		        this(color, thickness, radii, pointerSize);
		        this.left = left;
		    }

		    @Override
		    public Insets getBorderInsets(Component c) {
		        return insets;
		    }

		    @Override
		    public Insets getBorderInsets(Component c, Insets insets) {
		        return getBorderInsets(c);
		    }

		    @Override
		    public void paintBorder(
		            Component c,
		            Graphics g,
		            int x, int y,
		            int width, int height) {

		        Graphics2D g2 = (Graphics2D) g;

		        int bottomLineY = height - thickness - pointerSize;

		        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
		                0 + strokePad,
		                0 + strokePad,
		                width - thickness,
		                bottomLineY,
		                radii,
		                radii);

		        Polygon pointer = new Polygon();

		        if (left) {
		            // left point
		            pointer.addPoint(
		                    strokePad + radii + pointerPad,
		                    bottomLineY);
		            // right point
		            pointer.addPoint(
		                    strokePad + radii + pointerPad + pointerSize,
		                    bottomLineY);
		            // bottom point
		            pointer.addPoint(
		                    strokePad + radii + pointerPad + (pointerSize / 2),
		                    height - strokePad);
		        } else {
		            // left point
		            pointer.addPoint(
		                    width - (strokePad + radii + pointerPad),
		                    bottomLineY);
		            // right point
		            pointer.addPoint(
		                    width - (strokePad + radii + pointerPad + pointerSize),
		                    bottomLineY);
		            // bottom point
		            pointer.addPoint(
		                    width - (strokePad + radii + pointerPad + (pointerSize / 2)),
		                    height - strokePad);
		        }

		        Area area = new Area(bubble);
		        area.add(new Area(pointer));

		        g2.setRenderingHints(hints);

		        // Paint the BG color of the parent, everywhere outside the clip
		        // of the text bubble.
		        Component parent  = c.getParent();
		        if (parent!=null) {
		            Color bg = parent.getBackground();
		            Rectangle rect = new Rectangle(0,0,width, height);
		            Area borderRegion = new Area(rect);
		            borderRegion.subtract(area);
		            g2.setClip(borderRegion);
		            g2.setColor(bg);
		            g2.fillRect(0, 0, width, height);
		            g2.setClip(null);
		        }

		        g2.setColor(color);
		        g2.setStroke(stroke);
		        g2.draw(area);
		    }
		}
		
		public static Border criarBordaBalaoDialogo(Color cor)
		{
			return new TextBubbleBorder(cor);
		}
		
		public static Border criarBordaTituloField(String titulo) {
			return BorderFactory.createTitledBorder(
		            BorderFactory.createEtchedBorder(
		                    EtchedBorder.RAISED, Color.GRAY
		                    , Color.DARK_GRAY),
		            titulo,
		            TitledBorder.DEFAULT_JUSTIFICATION, 
		            TitledBorder.CENTER);
		}
		
		public static Border criarBordaTitulo(String title) {
			return BorderFactory.createTitledBorder(
					null,
					title, TitledBorder.CENTER,
					TitledBorder.DEFAULT_POSITION);
		}
		public static Border criarBordaTitulo(
				String title,
				int titledBorderJusification,
				int titledBorderPosition) {
			return BorderFactory.createTitledBorder(
					null,
					title, titledBorderJusification,
					titledBorderPosition);
		}
		
		public static Border criarBordaArredondadaBasic(String titulo) {
			LineBorder roundedLineBorder = new LineBorder(Color.black, 5, true);
			TitledBorder roundedTitledBorder = new TitledBorder(roundedLineBorder, titulo);
			return roundedTitledBorder;
		}
		
		public static Border criarBordaArredondada(Color color) {
				return new TextBubbleBorder(color, 1, 10, 0);
		}
		
		public static Border criarBordaArredondada(Color color, int thickness) {
			return new TextBubbleBorder(color, thickness, 10, 0);
		}
		
		public static final Border border1 = ViewUtil.Bordas.criarBordaArredondada(Color.gray.darker());
		public static final Border border2 = ViewUtil.Bordas.criarBordaArredondada(Color.RED.darker(), 2);
		
		
	}
	
}