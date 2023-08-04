package model;

public class danhsachsv {
        private String ten;
        private int tuoi;
        private String diachi;
        private String hanhkiem;
        private int diem;
        public danhsachsv(String name, int age, String address, String conduct){
            super();
        }
        public danhsachsv(String ten,int tuoi,String diachi,String hanhkiem,int diem ){
          super();
          this.ten=ten;
          this.tuoi=tuoi;
          this.diachi=diachi;
          this.hanhkiem=hanhkiem;
          this.diem=diem;

        }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getHanhkiem() {
        return hanhkiem;
    }

    public void setHanhkiem(String hanhkiem) {
        this.hanhkiem = hanhkiem;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "danhsachsv{" +
                "ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", diachi='" + diachi + '\'' +
                ", hanhkiem='" + hanhkiem + '\'' +
                ", diem=" + diem +
                '}';
    }
}
