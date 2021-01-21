package com.brianlaughlin.invesmentmodeling.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "rapidproperty")
@NamedQueries({@NamedQuery(name = "RapidProperty.findAll", query = "SELECT r FROM RapidProperty r")})

public class RapidProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "propid")
    private String propid;

    @Column(name = "listingid")
    private String listingid;

    @Column(name = "city")
    private String city;

    @Column(name = "mlsid")
    private String mlsId;

    @Column(columnDefinition = "json", name = "jsondata")
    private String jsondata;

    @Column(name = "overriddenrent")
    private Integer overriddenrent;

    @Column(name = "created_date")
    private Date createddate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropid() {
        return propid;
    }

    public void setPropid(String propid) {
        this.propid = propid;
    }

    public String getListingid() {
        return listingid;
    }

    public void setListingid(String listingid) {
        this.listingid = listingid;
    }

    public String getJsondata() {
        return jsondata;
    }

    public void setJsondata(String jsondata) {
        this.jsondata = jsondata;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMlsId() {
        return mlsId;
    }

    public void setMlsId(String mlsId) {
        this.mlsId = mlsId;
    }


	public Integer getOverriddenrent() {
		return overriddenrent;
	}

	public void setOverriddenrent(Integer overriddenrent) {
		this.overriddenrent = overriddenrent;
	}
}
