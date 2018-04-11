package DAO;

import Entity.Faculty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAO implements AbstractController<Faculty, Long> {
    public static String READ_ALL = "SELECT * FROM `faculties`";
    public static String READ_BY_ID = "SELECT * FROM `faculties` WHERE `id` = ?";
    public static String UPDATE = "UPDATE `faculties` SET `name` = ? WHERE `id` = ?";
    public static String CREATE = "INSERT INTO `faculties` (`name`) VALUES (?)";
    public static String DELETE = "DELETE FROM `faculties` WHERE `id` = ?";

    @Override
    public List<Faculty> getAll() {
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = JDBConnector.getConnection();
            s = c.createStatement();
            r = s.executeQuery(READ_ALL);
            List<Faculty> faculties = new ArrayList<>();
            while (r.next()) {
                Faculty faculty = new Faculty();
                faculty.setId(r.getLong("id"));
                faculty.setName(r.getString("name"));
                faculties.add(faculty);
            }
            return faculties;
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
    public Faculty getEntityById(Long id) {
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = JDBConnector.getConnection();
            s = c.prepareStatement(READ_BY_ID);
            s.setLong(1, id);
            r = s.executeQuery();
            Faculty faculty = null;
            if (r.next()) {
                faculty = new Faculty();
                faculty.setId(r.getLong("id"));
                faculty.setName(r.getString("name"));
            }
            return faculty;
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
    public boolean update(Faculty entity) {
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = JDBConnector.getConnection();
            s = c.prepareStatement(UPDATE);
            s.setString(1, entity.getName());
            s.setLong(2,entity.getId());
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
    public boolean create(Faculty entity) {
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = JDBConnector.getConnection();
            s = c.prepareStatement(CREATE);
            s.setString(1, entity.getName());
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
