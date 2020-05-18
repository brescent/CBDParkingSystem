package com.project.dao;


import com.project.entity.CompanyUserEntity;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository

public class BasicDao {
   @Autowired
   private LocalContainerEntityManagerFactoryBean managerFactoryBean;

   public EntityManager getEntityManager(){
        //获得工厂
        EntityManagerFactory managerFactory=
        managerFactoryBean.getNativeEntityManagerFactory();

        return  managerFactory.createEntityManager();
    }


    public List<CompanyUserEntity> getAllCompany(String companyName, String companyAddress,
                                                 String contact, String contactPhone ,
                                                 int pageNum, int pageSize){


        String sql="select * from t_company where 1 = 1 ";
        if(companyName != null &&companyName !=""){
            sql += "and c_company_name like '%"+companyName+"%' ";
        }
        if(companyAddress != null &&companyAddress !=""){
            sql += "and c_company_address like '%"+companyAddress+"%' ";
        }
        if(contact != null &&contact !=""){
            sql += "and c_contact like '%"+contact+"%' ";
        }
        if(contactPhone != null &&contactPhone !=""){
            sql += "and c_contact_phone like '%"+contactPhone+"%' ";
        }
        sql += "limit "+(pageNum-1)*pageSize+","+pageSize;

        EntityManager entityManager=this.getEntityManager();
        NativeQuery query  = (NativeQuery) entityManager.createNativeQuery(sql);
        query.addEntity(CompanyUserEntity.class);
        return   query.getResultList();
    }

    public int getAllCouunt(String companyName, String companyAddress,
                            String contact, String contactPhone ){
        String sql="select * from t_company where 1 = 1 ";

        if(companyName != null && companyName !=""){
            sql += "and c_company_name like '%"+companyName+"%' ";
        }
        if(companyAddress != null && companyAddress !=""){
            sql += "and c_company_address like '%"+companyAddress+"%' ";
        }
        if(contact != null && contact !=""){
            sql += "and c_contact like '%"+contact+"%' ";
        }
        if(contactPhone != null &&contactPhone !=""){
            sql += "and c_contact_phone like '%"+contactPhone+"%' ";
        }

        EntityManager entityManager=this.getEntityManager();
        NativeQuery query  = (NativeQuery) entityManager.createNativeQuery(sql);
        query.addEntity(CompanyUserEntity.class);
        return query.getResultList().size();
    }




}
