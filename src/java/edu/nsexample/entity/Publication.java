/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nsexample.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Yash
 */
@Entity
@Table(name = "publication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p")
    , @NamedQuery(name = "Publication.findByTitle", query = "SELECT p FROM Publication p WHERE p.title = :title")
    , @NamedQuery(name = "Publication.findByJournalName", query = "SELECT p FROM Publication p WHERE p.journalName = :journalName")
    , @NamedQuery(name = "Publication.findByPublisher", query = "SELECT p FROM Publication p WHERE p.publisher = :publisher")
    , @NamedQuery(name = "Publication.findByIssn", query = "SELECT p FROM Publication p WHERE p.issn = :issn")
    , @NamedQuery(name = "Publication.findByIssue", query = "SELECT p FROM Publication p WHERE p.issue = :issue")
    , @NamedQuery(name = "Publication.findByDoi", query = "SELECT p FROM Publication p WHERE p.doi = :doi")
    , @NamedQuery(name = "Publication.findByPublicationCd", query = "SELECT p FROM Publication p WHERE p.publicationCd = :publicationCd")})
public class Publication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 16777215)
    @Column(name = "Keywords")
    private String keywords;
    @Size(max = 255)
    @Column(name = "journalName")
    private String journalName;
    @Size(max = 255)
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "ISSN")
    private Integer issn;
    @Size(max = 45)
    @Column(name = "issue")
    private String issue;
    @Size(max = 45)
    @Column(name = "doi")
    private String doi;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "publicationCd")
    private String publicationCd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicationCd")
    private Collection<Author> authorCollection;
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    @ManyToOne
    private Student studentId;

    public Publication() {
    }

    public Publication(String publicationCd) {
        this.publicationCd = publicationCd;
    }

    public Publication(String publicationCd, String title) {
        this.publicationCd = publicationCd;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getIssn() {
        return issn;
    }

    public void setIssn(Integer issn) {
        this.issn = issn;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getPublicationCd() {
        return publicationCd;
    }

    public void setPublicationCd(String publicationCd) {
        this.publicationCd = publicationCd;
    }

    @XmlTransient
    public Collection<Author> getAuthorCollection() {
        return authorCollection;
    }

    public void setAuthorCollection(Collection<Author> authorCollection) {
        this.authorCollection = authorCollection;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicationCd != null ? publicationCd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
        if ((this.publicationCd == null && other.publicationCd != null) || (this.publicationCd != null && !this.publicationCd.equals(other.publicationCd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.nsexample.entity.Publication[ publicationCd=" + publicationCd + " ]";
    }
    
}
