package classRoom;

/**
 * Created by online on 15-1-21.
 */
public class Person {
    public String sname;
    public String sid;
    public String professional;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }
    ClassRoom cr = new ClassRoom();

    public ClassRoom getCr() {
        return cr;
    }
}
