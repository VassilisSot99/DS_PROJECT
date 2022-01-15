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
    private String undergrPrgm;

    @Column(name = "gpa")
    private int gpa;

    @Column(name = "teacher1")
    private String teacher1;

    @Column(name = "teacher2")
    private String teacher2;

    @Column(name = "checked")
    private String checked;

    @Column(name = "evaluated")
    private String evaluated;

    @Column(name = "student_id")
    private int student_id;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="course_id")
    private Course course;

    public Application() {

    }

    public Application(String undergrPrgm,int gpa,String teacher1,String teacher2,
                       Course course,String checked,String evaluated){
        super();
        this.undergrPrgm=undergrPrgm;
        this.teacher1=teacher1;
        this.teacher2=teacher2;
        this.course=course;
        this.checked=checked;
        this.evaluated=evaluated;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUndergr_prgm() {
        return undergrPrgm;
    }

    public void setUndergr_prgm(String undergr_prgm) {
        this.undergrPrgm = undergr_prgm;
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

    public String getChecked() {
        return checked;
    }

    public void setChecked(String promoted) {
        this.checked = promoted;
    }

    public String getEvaluated() {
        return evaluated;
    }

    public void setEvaluated(String evaluated) {
        this.evaluated = evaluated;
    }


    @Override
    public String toString() {
        return "application{" +
                "id=" + id +
                ", undergr_prgm='" + undergrPrgm + '\'' +
                ", gpa=" + gpa +
                ", teacher1='" + teacher1 + '\'' +
                ", teacher2='" + teacher2 + '\'' +
                ", course='" + course + '\'' +
                ", promoted=" + checked +
                ", evaluated=" + evaluated +
                '}';
    }
}