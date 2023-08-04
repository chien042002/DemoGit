package dao;

import ketnoi.KetNoi;

import model.monhoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class monhocDAO implements DAOinteface<monhoc> {
    public static monhocDAO getInstance (){return new monhocDAO();}

    @Override
    public int insert(monhoc monhoc) {
        int ketQua = 0;
        Connection conn=null;
        try {
             conn = KetNoi.getConnection();
            String sql = "INSERT INTO monhoc (tienganh,nguvan,toanhoc,lichsu)" +
                    "  VALUES (?, ?, ?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, monhoc.getTienganh());
            pst.setString(2, monhoc.getNguvan());
            pst.setString(3, monhoc.getToanhoc());
            pst.setString(4, monhoc.getLichsu());
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
    public int update(monhoc monhoc) {
        int ketQua = 0;
        Connection conn=null;
        try {
         conn = KetNoi.getConnection();
          String sql ="UPDATE monhoc " +
                    " SET " +
                    " ,nguvan=?"+
                    " ,toanhoc=?"+
                    " ,lichsu=?"+
                    " WHERE tienganh=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, monhoc.getNguvan());
            pst.setString(2, monhoc.getToanhoc());
            pst.setString(3, monhoc.getLichsu());
            pst.setString(4, monhoc.getTienganh());
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
    public int delete(monhoc monhoc) {
        int ketQua = 0;
        Connection conn=null;
        try {
        conn = KetNoi.getConnection();
            String sql ="DELETE FROM monhoc " +
                    " WHERE toanhoc=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, monhoc.getToanhoc());
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
    public ArrayList<monhoc> selectALL() {
        ArrayList<monhoc> ketQua = new ArrayList<monhoc>();
        Connection conn=null;
        try {

          conn = KetNoi.getConnection();

            String sql = "SELECT * FROM monhoc ";
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String tienganh = rs.getString("tienganh");
                String nguvan = rs.getString("nguvan");
                String toanhoc = rs.getString("toanhoc");
                String lichsu=rs.getString("lichsu");
               monhoc mh = new monhoc(tienganh, nguvan,toanhoc,lichsu);
                ketQua.add(mh);

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
    public monhoc selectById(monhoc monhoc) {
        monhoc ketQua = null;
        Connection conn=null;
        try {
         conn = KetNoi.getConnection();

            String sql = "SELECT * FROM monhoc WHERE lichsu LIKE ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + monhoc.getLichsu() + "%");

            System.out.println(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String tienganh = rs.getString("tienganh");
                String nguvan = rs.getString("nguvan");
                String toanhoc = rs.getString("toanhoc");
                String lichsu = rs.getString("lichsu");
                ketQua = new monhoc(tienganh, nguvan, toanhoc, lichsu);
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

