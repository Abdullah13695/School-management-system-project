package model;
public abstract class Person {

    
    private final String id;
    private String name;
    private String email;
    private String password;

    public Person(String id, String name, String email, String password) {
        this.id       = id;
        this.name     = name;
        this.email    = email;
        this.password = password;
    }

    public abstract String getRole();
    public abstract void showDashboard();


    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public String getId()       { return id;       }
    public String getName()     { return name;     }
    public String getEmail()    { return email;    }
    public String getPassword() { return password; }

    public void setName(String name)         { this.name     = name;     }
    public void setEmail(String email)       { this.email    = email;    }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "[" + getRole() + "] ID: " + id + " | Name: " + name + " | Email: " + email;
    }
}
