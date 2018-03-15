/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.nsexample.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "university")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "University.findAll", query = "SELECT u FROM University u")
    , @NamedQuery(name = "University.findByName", query = "SELECT u FROM University u WHERE u.name = :name")
    , @NamedQuery(name = "University.findByCode", query = "SELECT u FROM University u WHERE u.code = :code")
    , @NamedQuery(name = "University.findByAddress", query = "SELECT u FROM University u WHERE u.address = :address")
    , @NamedQuery(name = "University.findByCity", query = "SELECT u FROM University u WHERE u.city = :city")
    , @NamedQuery(name = "University.findByState", query = "SELECT u FROM University u WHERE u.state = :state")
    , @NamedQuery(name = "University.findByCountry", query = "SELECT u FROM University u WHERE u.country = :country")
    , @NamedQuery(name = "University.findByZipcode", query = "SELECT u FROM University u WHERE u.zipcode = :zipcode")})
public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "code")
    private String code;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @Size(max = 45)
    @Column(name = "country")
    private String country;
    @Column(name = "zipcode")
    private Integer zipcode;
    @OneToMany(mappedBy = "uniCode")
    private Collection<Student> studentCollection;

    public University() {
    }

    public University(String code) {
        this.code = code;
    }

    public University(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.nsexample.entity.University[ code=" + code + " ]";
    }
    
}
