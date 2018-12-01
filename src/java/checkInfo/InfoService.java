package checkInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

@ManagedBean(name = "info", eager = true)
@SessionScoped
public class InfoService implements Serializable {
    double x = 0;
    double y = 0;
    double r = 2;
    boolean isInArea;
    LinkedList<Info> infos = new LinkedList<>();

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }
    
    public LinkedList<Info> getInfos() {
        return infos;
    }
    public void setInfos(LinkedList<Info> infos) {
        this.infos = infos;
    }

    public boolean getIsInArea() {
        isArea();
        return isInArea;
    }

    public void isArea () {
        if ((x >= 0) && (y >= 0) && (y <= r - x)) {
            isInArea = true;
        } else {
            if ((x <= 0) && (y >= 0) && ((x * x + y * y) <= r/2 * r/2)) {
                isInArea = true;
            } else {
                if ((x <= 0) && (y <= 0) && (x >= -r) && (y >= -r/2)) {
                    isInArea = true;
                } else {
                    isInArea = false;
                }
            }
        }
    }

    public void addInfo() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Info info = new Info(getX(),getY(),getR(),getIsInArea());
        infos.add(info);
        session.save(info);
        session.getTransaction().commit();
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (IOException e) {
            //
        }
    }

}
