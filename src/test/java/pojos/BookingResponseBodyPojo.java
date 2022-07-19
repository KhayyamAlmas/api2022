package pojos;

public class BookingResponseBodyPojo {

    // 1) Tum key'ler icin private varibale'lar olusturuyoruz
    private Integer bookingid;
    private  BookingPojo booking;

    //  2) Tum parametrelerle ve parametresiz constructor'larimizi olusturuyoruz


    public BookingResponseBodyPojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public BookingResponseBodyPojo() {
    }

    //  3) Getters ve Setters'lerimiz olusturuyoruz

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    //  4) toString() methodumuzu olusturuyoruz

    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
