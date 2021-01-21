package com.brianlaughlin.invesmentmodeling.repository;

import com.brianlaughlin.invesmentmodeling.entity.RapidProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RapidPropertyRepository extends JpaRepository<RapidProperty, Long>{
	
	
	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Transactional
	 * 
	 * @Query(
	 * value="delete from  rapidproperty where JSON_EXTRACT(jsondata ,  '$.address.city') = :city"
	 * ,nativeQuery = true) public void deleteRapidProperty(@Param("city")String
	 * city);
	 */

	   RapidProperty findByPropid (String propId);

	    @Modifying(clearAutomatically = true)
	    @Query(value="DELETE FROM rapidproperty WHERE (JSON_EXTRACT(jsondata ,  '$.address.city') = :city or :city is null) " +

				" and (JSON_EXTRACT(jsondata ,  '$.address.state_code') = :statecode  or :statecode is null)" +
				" and (JSON_EXTRACT(jsondata ,  '$.address.postal_code') = :postalcode  or :postalcode = -1)" +
				" and (JSON_EXTRACT(jsondata ,  '$.beds') >= :minbed  or :minbed = -1)" +
				" and (JSON_EXTRACT(jsondata ,  '$.prop_type') in :proptype  ) " +
				" and (JSON_EXTRACT(jsondata ,  '$.price') >= :minprice  or :minprice = -1)" +
				" and (JSON_EXTRACT(jsondata ,  '$.lot_size.size') >= :minsqft  or :minsqft = -1)" +
				" and (JSON_EXTRACT(jsondata ,  '$.price') <= :maxprice  or :maxprice = -1)" +
				" and listingid not in :listingid" +
				"",nativeQuery = true)
		public Integer  deleteBySerachParam(@Param("city")String city,@Param("statecode")String statecode,@Param("postalcode")Integer postalcode,@Param("minbed")Integer minbed,@Param("proptype")List<String> proptype,@Param("minprice")Integer minprice,
										 @Param("maxprice")Integer maxprice,@Param("minsqft")Integer minsqft,@Param("listingid")List<String> listingid);
	    
	    
	    @Query(value=""
	    		+ "SELECT " + 
	    		"   JSON_EXTRACT(jsondata , '$.mls.id'), " + 
	    		"   JSON_EXTRACT(jsondata , '$.beds'), " + 
	    		"   JSON_EXTRACT(jsondata , '$.price' ), " + 
	    		"   JSON_EXTRACT(jsondata , '$.prop_type'), " + 
	    		"   JSON_EXTRACT(jsondata , '$.prop_status'), " + 
	    		"   JSON_EXTRACT(jsondata ,  '$.address.city'), " + 
	    		"   JSON_EXTRACT(jsondata ,  '$.address.state_code'), " + 
	    		"   JSON_EXTRACT(jsondata ,  '$.address.postal_code'), " + 
	    		"   JSON_EXTRACT(jsondata ,  '$.rdc_web_url'), " + 
	    		"   JSON_EXTRACT(jsondata , '$.baths'), " + 
	    		"   JSON_EXTRACT(jsondata , '$.thumbnail'), " + 
	    		"   (IF(rp.overriddenrent IS NULL, IF(rd.overridden_rent IS NULL,rd.median_rent,rd.overridden_rent) , rp.overriddenrent )) median_rent, " +
	    		"   rd.sample_size, " + 
	    		"   (IF(rp.overriddenrent IS NULL, IF(rd.overridden_rent IS NULL,rd.median_rent,rd.overridden_rent) , rp.overriddenrent ) * 1200) / (CAST(JSON_EXTRACT(jsondata , '$.price') as UNSIGNED )) percentage_return, " +
	    		"   rd.overridden_rent , " +
	    		"   rp.listingid,  "+
	    		"   JSON_EXTRACT(jsondata , '$.last_update') , " +
				"   rp.overriddenrent,   " +
				"   JSON_EXTRACT(jsondata , '$.property_id') ," +
				"   JSON_EXTRACT(jsondata , '$.property_history') , "+
				"   JSON_EXTRACT(jsondata , '$.client_display_flags.is_pending') "+
				" FROM " +
	    		"    retsdata.rapidproperty rp  " +
	    		"  left join  retsdata.rentometer_data rd  on CAST(JSON_EXTRACT(jsondata , '$.address.postal_code') as UNSIGNED )  = rd.zipcode " +
				"  AND IF(CAST(JSON_EXTRACT(jsondata , '$.beds') AS UNSIGNED )>4, CEIL(JSON_EXTRACT(jsondata , '$.beds')/:splitBy ) , CAST(JSON_EXTRACT(jsondata , '$.beds') AS UNSIGNED ))  = rd.bed_summary     " +
	    		"  group by rp.mlsid "+
	    		"  order by percentage_return desc"
	    		,nativeQuery = true)
		public List<Object[]> getJsonData(@Param("splitBy")Integer splitBy);

		 @Modifying(clearAutomatically = true)
		 @Transactional
		 @Query(value="update  retsdata.rentometer_data set overridden_rent=:rentvalue where bed_summary = :bedsummary and zipcode = :zipcode",nativeQuery = true)
		 public void updateRentByPostalcodeAndBedsummary(@Param("zipcode")String zipcode, @Param("bedsummary")String bedsummary, @Param("rentvalue")String rentvalue);

	    
	    public RapidProperty findByListingid(String listingid);

	    @Query(value="Select configvalue from rapidpropertyconfig where configname = :configname", nativeQuery = true)
	    public Object getRapidConfigConfiguration(@Param("configname")String configname);

}
