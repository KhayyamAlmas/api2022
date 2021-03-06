package pojos;

public class BookingDatesPojo {

    //  1) Tum key'ler icin private varibale'lar olusturuyoruz
    private String checkin;
    private String checkout;

    //  2) Tum parametrelerle ve parametresiz constructor'larimizi olusturuyoruz

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }

    //  3) Getters ve Setters'lerimiz olusturuyoruz

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    //  4) toString() methodumuzu olusturuyoruz

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
