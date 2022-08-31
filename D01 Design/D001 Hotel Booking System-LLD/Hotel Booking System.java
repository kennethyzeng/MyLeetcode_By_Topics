/*
https://leetcode.com/discuss/interview-question/object-oriented-design/2101522/Hotel-Booking-System-or-LLD-or-Feedback-welcomed

*/ 

class Receptionst extends Persons{
    Search searchObj; 
    Booking bookingObj; 
    
    public void checkInGuest(Booking booking);
    public void checkoutGuest(Booking booking);
}

enum AccountStatus{
    ACTIVE, 
    CLOSED,
    CANCELED, 
    BLACKLISTED, 
    BLOCKED
}

enum AccountType{
    RECEPTIONIST, REGISTER_USER, GUEST, ADMIN
}

class Search{
    public List<Room> searchRoom(RoomType roomType, Durateion duration);
}

enum PaymentStatus{
    PENDING, 
    COMPLETED, 
    REFUNDED, 
    CANCELED, 
    FAILED
}
