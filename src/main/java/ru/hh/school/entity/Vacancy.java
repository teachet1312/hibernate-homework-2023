package ru.hh.school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

//TODO: оформите entity
@Entity
public class Vacancy {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
  @JoinColumn(name = "employer")
  private Employer employer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="area")
  private Area area;

  @Column(name = "title")
  private String title;
  @Column(name = "description")
  private String description;

  @Column(name = "compensationFrom")
  private Integer compensationFrom;

  @Column(name = "compensationTo")
  private Integer  compensationTo;

  @Column(name = "compensationGross")
  private Boolean compensationGross;

  @Column(name = "creationTime")
  private LocalDateTime creationTime;

  @Column(name = "archivingTime")
  private LocalDateTime archivingTime;

  public Vacancy() {
  }

  public Vacancy(Employer employer) {
    this.employer = employer;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Employer getEmployer() {
    return employer;
  }

  public void setEmployer(Employer employer) {
    this.employer = employer;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCompensationFrom(Integer compensationFrom) {
    this.compensationFrom = compensationFrom;
  }

  public void setCompensationTo(Integer compensationTo) {
    this.compensationTo = compensationTo;
  }

  public LocalDateTime getArchivingTime() {
    return archivingTime;
  }

  public void setArchivingTime(LocalDateTime archivingTime) {
    this.archivingTime = archivingTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vacancy vacancy = (Vacancy) o;
    return Objects.equals(id, vacancy.id);
  }

  @Override
  public int hashCode() {
    return 17;
  }

}
