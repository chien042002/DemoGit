package model;

public class monhoc {
    private String tienganh;
    private String nguvan;
    private String toanhoc;
    private String lichsu;
    public monhoc(){
        super();
    }
    public monhoc(String tienganh,String nguvan,String toanhoc,String lichsu){
        super();
        this.tienganh=tienganh;
        this.nguvan=nguvan;
        this.toanhoc=toanhoc;
        this.lichsu=lichsu;
    }

    public String getTienganh() {
        return tienganh;
    }

    public void setTienganh(String tienganh) {
        this.tienganh = tienganh;
    }

    public String getNguvan() {
        return nguvan;
    }

    public void setNguvan(String nguvan) {
        this.nguvan = nguvan;
    }

    public String getToanhoc() {
        return toanhoc;
    }

    public void setToanhoc(String toanhoc) {
        this.toanhoc = toanhoc;
    }

    public String getLichsu() {
        return lichsu;
    }

    public void setLichsu(String lichsu) {
        this.lichsu = lichsu;
    }

    @Override
    public String toString() {
        return "monhoc{" +
                "tienganh='" + tienganh + '\'' +
                ", nguvan='" + nguvan + '\'' +
                ", toanhoc='" + toanhoc + '\'' +
                ", lichsu='" + lichsu + '\'' +
                '}';
    }
}
