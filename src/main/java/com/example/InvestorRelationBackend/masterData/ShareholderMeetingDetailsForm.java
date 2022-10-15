package com.example.InvestorRelationBackend.masterData;

public class ShareholderMeetingDetailsForm {

	private String id;
	private long date;
	
	private long startTime;
	
	private long endTime;
	
	private String organization;
	
	private String stakeHolderType;
	
	private String meetingType;
	
	private String subject;
	
	private String location;
	
	private String status;
	
	private String comments;
	
	private String participent;
	
	private String feedback;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getStakeHolderType() {
		return stakeHolderType;
	}

	public void setStakeHolderType(String stakeHolderType) {
		this.stakeHolderType = stakeHolderType;
	}

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getParticipent() {
		return participent;
	}

	public void setParticipent(String participent) {
		this.participent = participent;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public ShareholderMeetingDetailsForm(String id, long date, long startTime, long endTime, String organization,
			String stakeHolderType, String meetingType, String subject, String location, String status, String comments,
			String participent, String feedback) {
		super();
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.organization = organization;
		this.stakeHolderType = stakeHolderType;
		this.meetingType = meetingType;
		this.subject = subject;
		this.location = location;
		this.status = status;
		this.comments = comments;
		this.participent = participent;
		this.feedback = feedback;
	}

	public ShareholderMeetingDetailsForm() {
		super();
	}

	@Override
	public String toString() {
		return "ShareholderMeetingDetailsForm [id=" + id + ", date=" + date + ", startTime=" + startTime + ", endTime="
				+ endTime + ", organization=" + organization + ", stakeHolderType=" + stakeHolderType + ", meetingType="
				+ meetingType + ", subject=" + subject + ", location=" + location + ", status=" + status + ", comments="
				+ comments + ", participent=" + participent + ", feedback=" + feedback + "]";
	}
	

}
