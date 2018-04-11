package DAO;

import Entity.Faculty;
import Entity.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO implements AbstractController<Teacher, Long> {

    public static String READ_ALL = "SELECT * FROM `teachers`";
    public static String READ_BY_ID = "SELECT * FROM `teachers` WHERE `id` = ?";
    public static String UPDATE = "UPDATE `teachers` SET `name` = ?, `cathedra` = ? WHERE `id` = ?";
    public static String CREATE = "INSERT INTO `teachers` (`name`, `cathedra`) VALUES (?, ?)";
    public static String DELETE = "DELETE FROM `teachers` WHERE `id` = ?";

    @Override
    public List<Teacher> getAll() {
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = JDBConnector.getConnection();
            s = c.createStatement();
            r = s.executeQuery(READ_ALL);
            List<Teacher> teachers = new ArrayList<>();
            while (r.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(r.getLong("id"));
                teacher.setName(r.getString("name"));
                teachers.add(teacher);
            }
            return teachers;
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
    public Teacher getEntityById(Long id) {
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = JDBConnector.getConnection();
            s = c.prepareStatement(READ_BY_ID);
            s.setLong(1, id);
            r = s.executeQuery();
            Teacher teacher = null;
            if (r.next()) {
                teacher = new Teacher();
                teacher.setId(r.getLong("id"));
                teacher.setName(r.getString("name"));
            }
            return teacher;
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
    public boolean update(Teacher entity) {
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = JDBConnector.getConnection();
            s = c.prepareStatement(UPDATE);
            s.setString(1, entity.getName());
            s.setString(2, entity.getFaculty());
            s.setLong(3, entity.getId());
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
    public boolean create(Teacher entity) {
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = JDBConnector.getConnection();
            s = c.prepareStatement(CREATE);
            s.setString(1, entity.getName());
            s.setString(2, entity.getFaculty());
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
