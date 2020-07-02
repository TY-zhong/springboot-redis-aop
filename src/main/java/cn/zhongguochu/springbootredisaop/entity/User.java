package cn.zhongguochu.springbootredisaop.entity;

public class User {
    private String id;

    private String name;

    private Integer age;

    private String phone;

    private Integer sex;

    public User(){}

    public User(String id, String name, Integer age, String phone, Integer sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
