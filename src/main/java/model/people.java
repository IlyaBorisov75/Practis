package model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
@Document

public class people {
	@Id
	private String Id;
	private String Name;
	private long RoomNumber;
	
	public people(String id, String name, long roomNumber) {
		Id = id;
		Name = name;
		RoomNumber = roomNumber;
	}
	
	public String getId() {
		return Id;
	}
	
	public String getName() {
		return Name;
	}
	
	public long getRoomNumber() {
		return RoomNumber;
	}
	/*public void setRoomNumber(long roomNumber) {
		RoomNumber = roomNumber;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setId(String id) {
		Id = id;
	}
	
	 @Override
	    public String toString() {
	        return String.format(
	                "Guests[Id=%s, Name='%s', RoomNumber='%s']",
	                Id, Name, RoomNumber);
	    }*/
}
