package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "languages")
@Entity
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "language_level")
	private int languageLevel;
	
	@Column(name = "created_date")
	private LocalDate createdDate;

	public Language(int id, Candidate candidate, String language, int languageLevel, LocalDate createdDate) {
		super();
		this.id = id;
		this.candidate = candidate;
		this.language = language;
		this.languageLevel = languageLevel;
		this.createdDate = createdDate;
	}
	
	public Language() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getLanguageLevel() {
		return languageLevel;
	}

	public void setLanguageLevel(int languageLevel) {
		this.languageLevel = languageLevel;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
}
