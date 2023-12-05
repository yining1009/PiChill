package com.pichill.reserveorder.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reserveorder")
public class ReserveOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reserveOrderID", updatable = false)
	private Integer reserveOrderID;
	
	@Column(name="gUserID")
	private Integer gUserID;
	
	@Column(name="oUserID")
	private Integer oUserID;
	
	@Column(name="reserveDate")
	private Date reserveDate;
	
	@Column(name="timeID")
	private Integer timeID;
	
	@Column(name="placeID")
	private Integer placeID;
	
	@Column(name="orderTime")
	private Timestamp orderTime;
	
	@Column(name="orderNum")
	private Integer orderNum;
	
	@Column(name="orderStatus")
	private Integer orderStatus;
	
	@Column(name="totalCost")
	private Integer totalCost;

	public ReserveOrder() {
		super();
	}

	public ReserveOrder(Integer reserveOrderID, Integer gUserID, Integer oUserID, Date reserveDate, Integer timeID,
			Integer placeID, Timestamp orderTime, Integer orderNum, Integer orderStatus, Integer totalCost) {
		super();
		this.reserveOrderID = reserveOrderID;
		this.gUserID = gUserID;
		this.oUserID = oUserID;
		this.reserveDate = reserveDate;
		this.timeID = timeID;
		this.placeID = placeID;
		this.orderTime = orderTime;
		this.orderNum = orderNum;
		this.orderStatus = orderStatus;
		this.totalCost = totalCost;
	}

	public Integer getReserveOrderID() {
		return reserveOrderID;
	}

	public void setReserveOrderID(Integer reserveOrderID) {
		this.reserveOrderID = reserveOrderID;
	}

	public Integer getgUserID() {
		return gUserID;
	}

	public void setgUserID(Integer gUserID) {
		this.gUserID = gUserID;
	}

	public Integer getoUserID() {
		return oUserID;
	}

	public void setoUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	public Integer getTimeID() {
		return timeID;
	}

	public void setTimeID(Integer timeID) {
		this.timeID = timeID;
	}

	public Integer getPlaceID() {
		return placeID;
	}

	public void setPlaceID(Integer placeID) {
		this.placeID = placeID;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "ReserveOrder [reserveOrderID=" + reserveOrderID + ", gUserID=" + gUserID + ", oUserID=" + oUserID
				+ ", reserveDate=" + reserveDate + ", timeID=" + timeID + ", placeID=" + placeID + ", orderTime="
				+ orderTime + ", orderNum=" + orderNum + ", orderStatus=" + orderStatus + ", totalCost=" + totalCost
				+ "]";
	}

	

	

	

}