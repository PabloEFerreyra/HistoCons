package com.histocons.gestores;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.histocons.ejecucion.Errores;
import com.histocons.entidades.Paciente;
public class GestorPacientes {
	
	public static int ConsultarDni(int dni)
	{
		
		int resultado = 0;
		SessionFactory factory;
		try 
		{ 
			factory = new Configuration().configure().buildSessionFactory();
		}
		catch (HibernateException he) 
		{ 
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
			throw new ExceptionInInitializerError(he); 
		} 
		
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		Query paciente = session.createQuery("select p.dni from Pacientes p where p.dni =: dni").setMaxResults(1);
		Transaction transaction = null;
		try
		{
			paciente.setParameter("dni", dni);
			transaction = session.beginTransaction();
			transaction.commit();
			if(!paciente.list().isEmpty())
				resultado = 1;
			else
				resultado = 0;
	        transaction.commit();
	        resultado = 1;
		}
		catch (HibernateException e) {
	        if (transaction != null)
	            transaction.rollback();
	        e.printStackTrace();
	        resultado = 0;
	    } finally {
	        session.close();
	    }
		return resultado;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public static List<Paciente> ConsultarPaciente(String apellido)
	{
		SessionFactory factory;
		try 
		{ 
			factory = new Configuration().configure().buildSessionFactory();
		}
		catch (HibernateException he) 
		{ 
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
			throw new ExceptionInInitializerError(he); 
		} 
		
		Session session = factory.openSession();
		
		@SuppressWarnings("unchecked")
		List<Paciente> pacientes= new ArrayList<Paciente>();
		Transaction transaction = null;
		try
		{
			pacientes = session.createCriteria(Paciente.class).add(Restrictions.like("apellido", apellido+"%")).list();
		}
		catch (HibernateException e) {
	        if (transaction != null)
	            transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		return pacientes;
		
	}

	@SuppressWarnings({ "unused", "null" })
	public static int IngresarPaciente(int dni, String apellido, String nombre, String sexo, String fechanac, String obrasocial, 
			int numeroafiliado, String planobra, String provincia, String ciudad, String domicilio, int telefono, 
			int celular, String mail)
	{
		int resultado=0;
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
        
		Transaction transaction = null;
		try
		{
			Paciente pacientes = new Paciente();
			pacientes.setDni(dni);
			pacientes.setApellido(apellido);
			pacientes.setNombre(nombre);
			pacientes.setSexo(sexo);
			pacientes.setFechaNacimiento(fechanac);
			pacientes.setObraSocial(obrasocial);
			pacientes.setNroAfiliado(numeroafiliado);
			pacientes.setPlanOs(planobra);
			pacientes.setProvincia(provincia);
			pacientes.setCiudad(ciudad);
			pacientes.setDomicilio(domicilio);
			pacientes.setTelefono(telefono);
			pacientes.setTelefonoCelular(celular);
			pacientes.setCorreo(mail);
			
			try{
				session.save(pacientes);
				resultado = 1;
				return resultado;
			}
			catch(Exception e)
			{
				resultado = 0;
				return resultado;
			}
		}
		catch (HibernateException e) {
			if (transaction != null)
				resultado = 0;
				transaction.rollback();
			e.printStackTrace();
			} finally {
				session.close();
			}
		return resultado;
	}
	
	public static int ActuaPaciente(Paciente pacientes) throws IOException {
		int resultado = 0;
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
        
        Query query = session.createQuery("update Paciente p set p.apellido =:apellido, p.nombre =:nombre, p.sexo =:sexo,"
        		+ "p.fechaNacimiento=:fechanac, p.obraSocial=:obrasocial, p.nroAfiliado =:numeroafiliado, p.planOs=:planObra, "
        		+ "p.provincia =:provincia, p.ciudad =:ciudad, p.domicilio =:domicilio, p.telefono =:telefono,"
        		+ "p.telefonoCelular=:celular, p.correo =:mail where p.dni =:dni");
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			query.setParameter("dni", pacientes.getDni());
			query.setParameter("apellido", pacientes.getApellido());
			query.setParameter("nombre", pacientes.getNombre());
			query.setParameter("sexo", pacientes.getSexo());
			query.setParameter("fechanac", pacientes.getFechaNacimiento());
			query.setParameter("obrasocial", pacientes.getObraSocial());
			query.setParameter("numeroafiliado", pacientes.getNroAfiliado());
			query.setParameter("planobra", pacientes.getPlanOs());
			query.setParameter("provincia", pacientes.getProvincia());
			query.setParameter("ciudad", pacientes.getCiudad());
			query.setParameter("domicilio", pacientes.getDomicilio());
			query.setParameter("telefono", pacientes.getTelefono());
			query.setParameter("celular", pacientes.getTelefonoCelular());
			query.setParameter("mail", pacientes.getCorreo());
			try{
				resultado =query.executeUpdate();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, Errores.UsuarioPassIncorrecto());
				com.histocons.log.Log.crearLog("Error login " + e);
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
		return resultado;
	}
}


