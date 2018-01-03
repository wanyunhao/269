package dierji.treeSetAndTreeMap;

public class Worker implements Comparable<Worker>{
    /**
     * 职业
     */
    private String type;
    /**
     * 工资
     */
    private double salary;

    public Worker() {
    }

    public Worker(String type, double salary) {
        this.type = type;
        this.salary = salary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * 工资排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Worker o) {
        return this.salary > o.salary ? 1 : (this.salary == o.salary?0:-1);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "type='" + type + '\'' +
                ", salary=" + salary +
                '}';
    }
}
