package entities;



public class Employer {
   private Integer id;
   private String name;
   private Double salary;
    public Employer(String name,Double salary,Integer id){
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void increaseSalary(Double percent){
        salary = salary + (salary*percent/100);
    }


    public String toString() {
        return "Nome: "+getName() +
                "\nID: "+ getId() +
                "\nNovo Salario: " + getSalary();
    }
}
