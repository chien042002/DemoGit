package dao;

import ketnoi.KetNoi;
import model.danhsachsv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class danhsachsvDAO implements DAOinteface<danhsachsv> {
    public static danhsachsvDAO getInstance() {
        return new danhsachsvDAO();
    }

    @Override
    public int insert(danhsachsv danhsachsv) {
        int ketQua = 0;
        Connection conn=null;
        try {
            conn = KetNoi.getConnection();
            String sql = "INSERT INTO danhsachsv (ten,tuoi,diachi,hanhkiem,diem)" +
                    "  VALUES (?, ?, ?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, danhsachsv.getTen());
            pst.setInt(2, danhsachsv.getTuoi());
            pst.setString(3, danhsachsv.getDiachi());
            pst.setString(4, danhsachsv.getHanhkiem());
            pst.setInt(5,danhsachsv.getDiem());
            ketQua = pst.executeUpdate();
            System.out.println("ban da thuc thi :" + sql);
            System.out.println("co " + ketQua + " dong bi thay doi!");
         KetNoi.clsoeConnection(conn);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }

    @Override
    public int update(danhsachsv danhsachsv) {
        int ketQua = 0;
        Connection conn=null;
        try {
         conn = KetNoi.getConnection();
            String sql = "UPDATE danhsachsv " +
                    " SET " +
                    " ,tuoi=?" +
                    " ,diachi=?" +
                    " ,hanhkiem=?" +
                    " ,diem=?" +
                    " WHERE ten=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, danhsachsv.getTuoi());
            pst.setString(2, danhsachsv.getDiachi());
            pst.setString(3, danhsachsv.getHanhkiem());
            pst.setInt(4,danhsachsv.getDiem());
            pst.setString(5, danhsachsv.getTen());
            ketQua = pst.executeUpdate();
            System.out.println("ban da thuc thi :" + sql);
            System.out.println("co " + ketQua + " dong bi thay doi!");



        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQua;

    }

    @Override
    public int delete(danhsachsv danhsachsv) {
        int ketQua = 0;
        Connection conn=null;
        try {
            conn = KetNoi.getConnection();
            String sql = "DELETE FROM danhsachsv " +
                    " WHERE ten=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, danhsachsv.getTen());
            ketQua = pst.executeUpdate();
            System.out.println("ban da thuc thi :" + sql);
            System.out.println("co " + ketQua + " dong bi thay doi!");


            KetNoi.clsoeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }

    @Override
    public ArrayList<danhsachsv> selectALL() {
        ArrayList<danhsachsv> ketQua = new ArrayList<danhsachsv>();
        Connection conn=null;
        try {

            conn = KetNoi.getConnection();

            String sql = "SELECT * FROM danhsachsv ";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String ten = rs.getString("ten");
                int tuoi = rs.getInt("tuoi");
                String diachi = rs.getString("diachi");
                String hanhkiem = rs.getString("hanhkiem");
                int diem=rs.getInt("diem");
                danhsachsv sv = new danhsachsv(ten, tuoi, diachi, hanhkiem,diem);
                ketQua.add(sv);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }

    @Override
    public danhsachsv selectById(danhsachsv danhsachsv) {
        danhsachsv ketQua = null;
        Connection conn=null;
        try {
        conn = KetNoi.getConnection();
            String sql = "SELECT * FROM danhsachsv WHERE ten LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + danhsachsv.getTen() + "%");

            System.out.println(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String ten = rs.getString("ten");
                int tuoi = rs.getInt("tuoi");
                String diachi = rs.getString("diachi");
                String hanhkiem = rs.getString("hanhkiem");
                int diem=rs.getInt("diem");
                ketQua = new danhsachsv(ten, tuoi, diachi, hanhkiem,diem);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }
}