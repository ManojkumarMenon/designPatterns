package com.manoj.practice.other.patterns;

public class DaoPatternImpl {

    public static void main(String[] args) {
        StudentEntity s = new StudentEntity();

        StudentDao sDao = new StudentDaoImpl();
        sDao.save(s);
        sDao.update(s);
        sDao.delete(s);
    }

}

// Entity class
class StudentEntity {

    private int empId;
    private String firstName;
    private String secondName;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "StudentEntity [empId=" + empId + ", firstName=" + firstName + ", secondName=" + secondName + "]";
    }

}

// DAO interface for StudentEntity
interface StudentDao {

    public int save(StudentEntity s);

    public void delete(StudentEntity s);

    public int update(StudentEntity s);
}

// DAO impl for StudentEntity operations.
class StudentDaoImpl implements StudentDao {

    private DatabaseConnection conn = new MongoDatabaseConnection();

    @Override
    public int save(StudentEntity s) {
        conn.save(s);
        return 0;
    }

    @Override
    public void delete(StudentEntity s) {
        conn.delete(s);

    }

    @Override
    public int update(StudentEntity s) {
        conn.update(s);
        return 0;
    }

}

// Database connection interface.
interface DatabaseConnection<T> {
    public void save(T t);

    public void update(T t);

    public void delete(T t);

}

// Impl class for Mongo Database Connection.
class MongoDatabaseConnection implements DatabaseConnection {

    @Override
    public void save(Object t) {
        System.out.println("Saved  !!!");
    }

    @Override
    public void update(Object t) {
        System.out.println("Updated  !!!");

    }

    @Override
    public void delete(Object t) {
        System.out.println("Deleted  !!!");

    }
}
