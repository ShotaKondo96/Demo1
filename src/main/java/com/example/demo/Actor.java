package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long actor_id;

	private String first_name;

	private String last_name;

	private String last_update;

	private short is_delete;

	public Actor() {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();

        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        this.last_update = formattedDate;

	}

	public void setId(long id) {
		this.actor_id = id;
	}

	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}

}
