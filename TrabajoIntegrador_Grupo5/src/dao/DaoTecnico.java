package dao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import entidades.Cliente;
import entidades.Tecnico;

public class DaoTecnico {
	public void Add(Tecnico tecnico) 
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		     
	    session.beginTransaction();
	    session.save(tecnico);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public Tecnico ReadOne(int id)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Tecnico tecnico=(Tecnico)session.get(Tecnico.class,id);
        
        config.cerrarSession();
        
        return tecnico;
	}
	
	public void Update(Tecnico tecnico)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(tecnico);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public void Delete(Tecnico tecnico)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(tecnico);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public List<Tecnico> listarTecnicos() {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		List<Tecnico> tecnicosList = null;

		session.beginTransaction();
		try {
		tecnicosList = session.createQuery("FROM Tecnico").list();
		}catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		config.cerrarSession();

		return tecnicosList;
	}
	

	public Tecnico tecnicoConMasIncidentesResueltos(int dias) {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		Tecnico tecnico = null;
		
		session.beginTransaction();
		try {
			tecnico = (Tecnico) session.createQuery("SELECT t.*, ixt.idTecnico, COUNT(ixt.idIncidente) AS incidentesResueltos"
					+ " FROM Tecnico t"
					+ " JOIN Incidente_x_Tecnico ixt ON t.idTecnico = ixt.idTecnico"
					+ " JOIN Incidente i ON ixt.idIncidente = i.idIncidente "
					+ " WHERE i.resuelto = 1 AND i.fechaResolucion >= DATE_SUB(CURDATE(), INTERVAL :dias DAYS)"
					+ " GROUP BY t.idTecnico"
					+ " ORDER BY incidentesResueltos DESC"
					+ " LIMIT 1").setParameter("dias", dias).uniqueResult();
			
		} catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		config.cerrarSession();
		
		return tecnico;
	}
	
	public void borrarSobrantesIncidentexTecnico() {
		ConfigHibernate config = new ConfigHibernate();
		Session session = config.abrirConexion();
		
		session.beginTransaction();

			String hql = "DELETE FROM Incidente_x_Tecnico WHERE idTecnico IN (SELECT idTecnico FROM Tecnico WHERE idEspecialidad <> (SELECT idEspecialidad FROM Incidente WHERE idIncidente = Incidente_x_Tecnico.idIncidente))";
			
			session.createQuery(hql).executeUpdate();
	
		config.cerrarSession();
	}
	
}
