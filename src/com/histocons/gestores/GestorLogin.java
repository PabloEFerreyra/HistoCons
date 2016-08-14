package com.histocons.gestores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.histocons.ejecucion.Errores;
import com.histocons.entidades.Usuarios;

@SuppressWarnings("deprecation")
public class GestorLogin  
{
	public static String validar_ingreso(String usuario, String clave){
		String perfil = null;
		SessionFactory factory;
        try 
	    { 
        	factory = new Configuration().configure().buildSessionFactory();
	    } catch (HibernateException he) 
	    { 
	        System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
	        throw new ExceptionInInitializerError(he); 
	    } 
        Session session = factory.openSession();
        
        Query query = session.createQuery("select u.perfil from Usuarios u where u.username =:usuario and u.password =:clave and u.isactive = 'SI'").setMaxResults(1);
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
	        query.setParameter("usuario", usuario);
	        query.setParameter("clave", clave);
	        try{
	        	perfil = query.list().get(0).toString();
	        }
	        catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(null, Errores.UsuarioPassIncorrecto());
	        	try {
					com.histocons.log.Log.crearLog("Error login " + e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
	        transaction.commit();
		}
		catch (HibernateException e) {
	        if (transaction != null)
	            transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		return perfil;
	}
	
	public static int ActuaPass (Usuarios pass)
	{
		int resultado=0;
		String SQL= "UPDATE auth_user set password=? where username=? and password=?";
	try 
	{
	
			Connection cn=Conexion.getConexion();
			PreparedStatement pst=cn.prepareStatement(SQL);
			pst.setString(1,pass.getPassword());
			pst.setString(2, pass.getUsername());
			resultado=pst.executeUpdate();
		}
	catch(SQLException e)
			{		
				System.out.println("Error: "+e.getMessage());		
			}
		
		return resultado;
			}

	}