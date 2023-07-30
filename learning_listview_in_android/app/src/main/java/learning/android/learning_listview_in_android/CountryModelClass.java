package learning.android.learning_listview_in_android;

public class CountryModelClass {
    private String countryName, cup_win_count;
    private int countryFlag;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCup_win_count() {
        return cup_win_count;
    }

    public void setCup_win_count(String cup_win_count) {
        this.cup_win_count = cup_win_count;
    }

    public int getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(int countryFlag) {
        this.countryFlag = countryFlag;
    }

    public CountryModelClass(String countryName, String cup_win_count, int countryFlag) {
        this.countryName = countryName;
        this.cup_win_count = cup_win_count;
        this.countryFlag = countryFlag;
    }

}
