package com.restaurant.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(generator = "restaurant_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "restaurant_gen",sequenceName = "restaurant_sequence",initialValue = 50,allocationSize = 1)
	private Integer restaurantId;
	@Column(length = 30)
	private String restaurantName;
	@Column(length = 30)
	private String city;
	@Column(length = 30)
	private String type;
	@Column(length = 30)
	private double rating;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Set<Item> items;

	public Restaurant(String restaurantName, String city, String type, double rating, Set<Item> items) {
		this.restaurantName = restaurantName;
		this.city = city;
		this.type = type;
		this.rating = rating;
		this.items = items;
	}
}
