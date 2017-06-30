package org.openmrs.module.xdssender.api.model;

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.Provider;

import java.util.Date;
import java.util.List;

/**
 * Represents basic information about a document related to a patient
 * 
 * @author Justin
 */
public class DocumentInfo {
	
	// Patient of the document
	private Patient patient;
	
	// title of the document
	private String title;
	
	// mime type of the document
	private String mimeType;
	
	// hash of the document
	private byte[] hash;
	
	// related encounters
	private Encounter relatedEncounter;
	
	// authors
	private List<Provider> authorXon;
	
	// Unique id
	private String uniqueId;
	
	// Repository id
	private String repositoryId;
	
	// Format code
	private String formatCode;
	
	// Class code
	private String classCode;
	
	// Creation time
	private Date creationTime;
	
	// Type code
	private String typeCode;
	
	/**
	 * Gets the creation time
	 * 
	 * @return
	 */
	public Date getCreationTime() {
		return this.creationTime;
	}
	
	/**
	 * Sets the creation time
	 * 
	 * @param creationTime
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	
	/**
	 * @return the repositoryId
	 */
	public String getRepositoryId() {
		return repositoryId;
	}
	
	/**
	 * @param repositoryId the repositoryId to set
	 */
	public void setRepositoryId(String repositoryId) {
		this.repositoryId = repositoryId;
	}
	
	/**
	 * @return the uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}
	
	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}
	
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}
	
	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	/**
	 * @return the hash
	 */
	public byte[] getHash() {
		return hash;
	}
	
	/**
	 * @param hash the hash to set
	 */
	public void setHash(byte[] hash) {
		this.hash = hash;
	}
	
	/**
	 * @return the relatedEncounter
	 */
	public Encounter getRelatedEncounter() {
		return relatedEncounter;
	}
	
	/**
	 * @param relatedEncounter the relatedEncounter to set
	 */
	public void setRelatedEncounter(Encounter relatedEncounter) {
		this.relatedEncounter = relatedEncounter;
	}
	
	/**
	 * @return the authorDisplayNames
	 */
	public List<Provider> getAuthors() {
		return authorXon;
		
	}
	
	/**
	 * @param authors the authorDisplayNames to set
	 */
	public void setAuthors(List<Provider> authors) {
		this.authorXon = authors;
	}
	
	/**
	 * @return the formatCode
	 */
	public String getFormatCode() {
		return formatCode;
	}
	
	/**
	 * @param formatCode the formatCode to set
	 */
	public void setFormatCode(String formatCode) {
		this.formatCode = formatCode;
	}
	
	/**
	 * @return the classCode
	 */
	public String getClassCode() {
		return classCode;
	}
	
	/**
	 * @param classCode the classCode to set
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	
	public String getTypeCode() {
		return typeCode;
	}
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
}
