package rc.springinterview.multiplemodules.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> users;
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(){}

    public Role(String name) {
        this.name = name;
    }
}
