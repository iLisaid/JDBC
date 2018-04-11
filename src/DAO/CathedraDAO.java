package DAO;

import Entity.Cathedra;
import Entity.Faculty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CathedraDAO implements AbstractController<Cathedra, Long> {
    public static String READ_ALL = "SELECT * FROM `Cathedries`";
    public static String READ_BY_ID = "SELECT * FROM `Cathedries` WHERE `id` = ?";
    public static String UPDATE = "UPDATE `Cathedries` SET `name` = ?, `faculty` = ? WHERE `id` = ?";
    public static String CREATE = "INSERT INTO `Cathedries` (`name`, `faculty`) VALUES (?, ?)";
    public static String DELETE = "DELETE FROM `Cathedries` WHERE `id` = ?";

    @Override
    public List<Cathedra> getAll() {
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = JDBConnector.getConnection();
            s = c.createStatement();
            r = s.executeQuery(READ_ALL);
            List<Cathedra> cathedries = new ArrayList<>();
            while (r.next()) {
                Cathedra cathedra = new Cathedra();
                cathedra.setId(r.getLong("id"));
                cathedra.setName(r.getString("name"));
                cathedra.setFacilty(r.getString("faculty"));
                cathedries.add(cathedra);
            }
            return cathedries;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                r.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Cathedra getEntityById(Long id) {
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = JDBConnector.getConnection();
            s = c.prepareStatement(READ_BY_ID);
            s.setLong(1, id);
            r = s.executeQuery();
            Cathedra cathedra = null;
            if (r.next()) {
                cathedra = new Cathedra();
                cathedra.setId(r.getLong("id"));
                cathedra.setName(r.getString("name"));
                cathedra.setFacilty(r.getString("faculty"));
            }
            return cathedra;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                r.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean update(Cathedra entity) {
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = JDBConnector.getConnection();
            s = c.prepareStatement(UPDATE);
            s.setString(1, entity.getName());
            s.setString(2, entity.getFacilty());
            s.setLong(3,entity.getId());
            s.executeUpdate();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = JDBConnector.getConnection();
            s = c.prepareStatement(DELETE);
            s.setLong(1, id);
            s.executeUpdate();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean create(Cathedra entity) {
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = JDBConnector.getConnection();
            s = c.prepareStatement(CREATE);
            s.setString(1, entity.getName());
            s.setString(2, entity.getFacilty());
            s.executeUpdate();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
            try {
                c.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
