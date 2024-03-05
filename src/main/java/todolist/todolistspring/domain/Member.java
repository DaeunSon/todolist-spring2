package todolist.todolistspring.domain;


import java.util.List;

public class Member {
    private String nickname;
    private String email;
    private String password;

    private List Member;

    public List getMember() {
        return Member;
    }

    public void setMember(List member) {
        Member = member;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
