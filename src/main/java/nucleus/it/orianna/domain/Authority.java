package nucleus.it.orianna.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Authority")
public class Authority {

    @Id
    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String name;

    public Authority() { }

    public Authority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
