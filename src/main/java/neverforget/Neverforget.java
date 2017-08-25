package neverforget;

public class Neverforget {
    public String getObiect() {
        return obiect;
    }

    public void setObiect(String obiect) {
        this.obiect = obiect;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setCapitala(String locatie) {
        this.locatie = locatie;
    }



    String obiect;
    String locatie;
    long id;

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
