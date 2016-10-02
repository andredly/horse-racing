package racers.entity.user;

import java.util.Date;
import java.util.List;

public class User {
    private long userId;
    private String firstName;
    private String lastName;
    private Date date;
    private String country;
    private String city;
    private List<String> address;
    private String postCode;
    private String login;
    private String password;
    private String securityQuestion;
    private String answer;
    private String email;
    private Balance userBalanse;
    private String mobileNumber;
    private int securLevel;

    public User(long userId) {
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public int getSecurLevel() {
        return securLevel;
    }

    public void setSecurLevel(int securLevel) {
        this.securLevel = securLevel;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Balance getUserBalanse() {
        return userBalanse;
    }

    public void setUserBalanse(Balance userBalanse) {
        this.userBalanse = userBalanse;
    }

    private enum Sex {
        MR("Mr"), MRS("Mrs"), MISS("Miss"), MS("Ms");
        private String sex;

        Sex(String sex) {
            this.sex = sex;
        }

        static public Sex getType(String pType) {
            for (Sex type : Sex.values()) {
                if (type.getTypeValue().equals(pType)) {
                    return type;
                }
            }
            return null;
        }

        public String getTypeValue() {
            return sex;
        }
    }
}
