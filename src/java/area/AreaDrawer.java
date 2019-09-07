package area;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import area.ZoneType;
import checkInfo.InfoService;
import checkInfo.Info;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import org.hibernate.cfg.Configuration;
import org.primefaces.component.log.Log;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class AreaDrawer{
    private StreamedContent image = null;
    
    public StreamedContent getImage() {
        return image = this.Draw();
    }

    public void setImage(StreamedContent image) {
        this.image = image;
    }

    public AreaDrawer() throws IOException, XMLStreamException, JAXBException  {
    }
    
    public StreamedContent Draw() {
        try {
            return this.DrawImpl();
        } catch(Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
                    
            return null;
        }
    }
    
    private <T> T getBean(String expr, Class<T> t) {
        FacesContext context = FacesContext.getCurrentInstance();
        Application app = context.getApplication();
        T obj = app.evaluateExpressionGet(context.getCurrentInstance(), expr, t);
        return obj;
    }
    
    private StreamedContent DrawImpl() throws IOException, XMLStreamException, JAXBException {
        try{
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

            InfoService ps = this.getBean("#{info}", InfoService.class);

            File localXmlFile = new File(ctx.getRealPath("/")+"/WEB-INF/FlatZone.xml");

            int r = 50; // for shape rendering

            Unmarshaller un = JAXBContext.newInstance(ZoneType.class).createUnmarshaller();
            XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(new FileInputStream(localXmlFile));

            ZoneType zone = (ZoneType) un.unmarshal(xsr, ZoneType.class).getValue();

            BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
            final Graphics2D g = image.createGraphics();
            g.setBackground(Color.white);
            g.clearRect(0, 0, 200, 200);

            AffineTransform labelsTransform = AffineTransform.getTranslateInstance(100, 100);

            AffineTransform shapeTransform = AffineTransform.getTranslateInstance(100, 100);
            shapeTransform.concatenate(AffineTransform.getScaleInstance(1, -1));
            g.setTransform(shapeTransform);

            g.setPaint(Color.blue);
            for (ShapeType o : zone.getTriangleOrCircleOrRectangle()) {
                ZoneVisitor.apply(o, new ZoneVisitor() {
                    @Override
                    public void visitCircle(CircleType cir) {
                        g.fillArc((int)((cir.getOX() - cir.getR())* r ), (int)((cir.getOY() - cir.getR())* r ), (int)(cir.getR() * r * 2), (int)(cir.getR() * r * 2), (int)(cir.getQuarter() * 90), 90);
                    }

                    @Override
                    public void visitRectangle(RectangleType rect) {
                        g.fillRect((int)(rect.getX() * r), (int)(rect.getY() * r), (int)(rect.getW() * r), (int)(rect.getH() * r));
                    }

                    @Override
                    public void visitTriangle(TriangleType tri) {
                        int[] xp = {(int)(tri.getX1() * r), (int)(tri.getX2() * r), (int)(tri.getX3() * r)};
                        int[] yp = {(int)(tri.getY1() * r), (int)(tri.getY2() * r), (int)(tri.getY3() * r)};

                        g.fillPolygon(xp, yp, 3);
                    }
                });
            }

            g.setPaint(Color.magenta);

            LinkedList<Info> list = ps.getInfos();
            if (list != null ) {
                for (Info info : list) {
                    if(info.getR() == ps.getR())
                    {
                    if(info.isInArea())
                        g.setPaint(Color.green);
                    else
                        g.setPaint(Color.red);
                    g.fillArc((int) (info.getX() * r/info.getR() - 3), (int) (info.getY() * r / info.getR() - 3), 7, 7, 0, 360);
                    }
                }
            }
            g.setTransform(labelsTransform);
            g.setPaint(Color.black);

            String rStr = Double.toString(ps.getR());

            Font f = g.getFont();
            Font f2 = f.deriveFont(10);
            g.setFont(f2);
            g.drawString("0", 0, 0);
            g.drawString(rStr, r, 0);
            g.drawString(rStr, 0, -r);
            g.drawString("-" + rStr, -r, 0);
            g.drawString("-" + rStr, 0, r);

            g.drawLine(0, 100, 0, -100);
            g.drawLine(-100, 0, 100, 0);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(image, "png", out);
            out.flush();

            StreamedContent result = new DefaultStreamedContent(new ByteArrayInputStream(out.toByteArray()), "image/png");
            return result;
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
