/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.ejb.util;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author prometeo
 */
public class JpaUtil {

    String PU = "SAICoop_v2-ejbPU";

    public EntityManager createEntityManager(String ip, String bd) {
        try {
            Properties properties = new Properties();
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://" + ip + ":5432/" + bd);
            properties.put("javax.persistence.jdbc.user", "saicoop");
            properties.put("javax.persistence.jdbc.password", "slufpana?");
            return Persistence.createEntityManagerFactory(PU, properties).createEntityManager();
        } catch (Throwable e) {
            System.err.println("Error en getTntityManagerFactory de JpaUtil tipo " + e.getMessage());
            return null;
        }
    }
}

/*
    private static final String PU = "SAICoop_v2-ejbPU";
    private static final ThreadLocal<EntityManager> manager = new ThreadLocal<>();
    private static EntityManagerFactory factory;

    private JpaUtil() {
    }

    public static EntityManager getEntityManager1(String ip, String bd) {
        if (JpaUtil.factory == null) {
            Properties properties = new Properties();
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://" + ip + ":5432/" + bd);
            properties.put("javax.persistence.jdbc.password", "saicoop");
            properties.put("javax.persistence.jdbc.user", "saicoop");
            JpaUtil.factory = Persistence.createEntityManagerFactory(PU, properties);
        }
        EntityManager em = JpaUtil.manager.get();
        if (em == null || !em.isOpen()) {
            em = JpaUtil.factory.createEntityManager();
            JpaUtil.manager.set(em);
        }
        return em;
    }

    public static void closeEntityManager() {
        EntityManager em = JpaUtil.manager.get();
        if (em != null) {
            EntityTransaction tx = em.getTransaction();
            if (tx.isActive()) {
                tx.commit();
            }
            em.close();
            JpaUtil.manager.set(null);
        }
    }

    public static void closeEntityManagerFactory() {
        closeEntityManager();
        JpaUtil.factory.close();
    }
*/
