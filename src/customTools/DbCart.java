package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Shoppingcart;

public class DbCart {
	public static void insert(Shoppingcart cart) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(cart);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Shoppingcart cart) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(cart);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void upsert(Shoppingcart cart){
		
		
		
		
	}
	
//
//	public static void delete(Product prod) {
//		EntityManager em = DbUtil.getEmFactory().createEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		try {
//			trans.begin();
//			em.remove(em.merge(prod));
//			trans.commit();
//		} catch (Exception e) {
//			System.out.println(e);
//			trans.rollback();
//		} finally {
//			em.close();
//		}
//	}

	public static List<Shoppingcart> listOfProducts (){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "select b from Shoppingcart b";
		
		List<Shoppingcart> posts = null;
		try{
			TypedQuery<Shoppingcart> query = em.createQuery(qString,Shoppingcart.class);
			posts = query.getResultList();

		}catch (Exception e){
			e.printStackTrace();
		}
		finally{
				em.close();
			}
		return posts;
	}
	
//	public static List<Product> postsofUser(long userid)
//	{
//		EntityManager em = DbUtil.getEmFactory().createEntityManager();
//		List<Product> userposts = null;
//		String qString = "select b from products b where b.bhuser.bhuserid = :userid";
//		
//		try{
//			TypedQuery<Product> query = em.createQuery(qString,Product.class);
//			query.setParameter("userid", userid);
//			userposts = query.getResultList();
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		finally{
//				em.close();
//			}
//		return userposts;	
//	}
	
//	public static List<Product> listOfProducts(String useremail)
//	{
//		EntityManager em = DbUtil.getEmFactory().createEntityManager();
//		List<Product> userposts = null;
//		String qString = "select b from products b "
//				+ "where b.bhuser.useremail = :useremail";
//		
//		try{
//			TypedQuery<Product> query = em.createQuery(qString,Product.class);
//			query.setParameter("useremail", useremail);
//			userposts = query.getResultList();
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		finally{
//				em.close();
//			}
//		return userposts;	
//	}
	
//	public static List<Product> searchProducts (String search)
//	{
//		EntityManager em = DbUtil.getEmFactory().createEntityManager();
//		List<Product> searchposts = null;
//		String qString = "select b from products b "
//				+ "where b.posttext like :search";
//		
//		try{
//			TypedQuery<Product> query = em.createQuery(qString,Product.class);
//			query.setParameter("search", "%" + search + "%");
//			searchposts = query.getResultList();
//		}catch (Exception e){
//			e.printStackTrace();
//		}finally{
//			em.close();
//		}return searchposts;
//	}
	
}