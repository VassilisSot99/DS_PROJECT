package gr.hua.huaproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "undergr_prgm")
    private String undergr_prgm;

    @Column(name = "gpa")
    private int gpa;

    @Column(name = "teacher1")
    private String teacher1;

    @Column(name = "teacher2")
    private String teacher2;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="course")
    private Course course;

    @Column(name = "promoted")
    private String promoted;

    @Column(name = "evaluated")
    private String evaluated;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "student_id")
    private Student student;

    public Application() {

    }

    public Application(String undergr_prgm,int gpa,String teacher1,String teacher2,Course course,String promoted,String evaluated, Student student){
        super();
        this.undergr_prgm=undergr_prgm;
        this.teacher1=teacher1;
        this.teacher2=teacher2;
        this.course=course;
        this.promoted=promoted;
        this.evaluated=evaluated;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUndergr_prgm() {
        return undergr_prgm;
    }

    public void setUndergr_prgm(String undergr_prgm) {
        this.undergr_prgm = undergr_prgm;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    public String getTeacher1() {
        return teacher1;
    }

    public void setTeacher1(String teacher1) {
        this.teacher1 = teacher1;
    }

    public String getTeacher2() {
        return teacher2;
    }

    public void setTeacher2(String teacher2) {
        this.teacher2 = teacher2;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getPromoted() {
        return promoted;
    }

    public void setPromoted(String promoted) {
        this.promoted = promoted;
    }

    public String getEvaluated() {
        return evaluated;
    }

    public void setEvaluated(String evaluated) {
        this.evaluated = evaluated;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "application{" +
                "id=" + id +
                ", undergr_prgm='" + undergr_prgm + '\'' +
                ", gpa=" + gpa +
                ", teacher1='" + teacher1 + '\'' +
                ", teacher2='" + teacher2 + '\'' +
                ", course='" + course + '\'' +
                ", promoted=" + promoted +
                ", evaluated=" + evaluated +
                '}';
    }
}