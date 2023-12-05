package com.pichill.report.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.comment.entity.Comment;
import com.pichill.report.entity.Report;

public class ReportDAOImpl implements ReportDAO {
	private SessionFactory factory;

	public ReportDAOImpl() {
		factory = com.pichill.util.HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int add(Report report) {
		return (Integer) getSession().save(report);

	}

	@Override
	public int update(Report report) {
		try {
			getSession().update(report);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delete(int reportID) {
		Report report = getSession().get(Report.class,reportID);
		if(report!=null) {
			getSession().delete(report);
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public Report getByReportID(Integer reportID) {
		getSession().clear();
		return getSession().get(Report.class,reportID);
	}

	@Override
	public List<Report> getAll() {
		return getSession().createQuery("from Comment",Report.class).list();

	}
}
//	private static final String INSERT_STMT = "INSERT INTO report(manageID,postID,commentID,reportTime,reportStatus,reportType)VALUES(?,?,?,?,?,?)";
//	private static final String UPDATE_STMT = "UPDATE report SET manageID=?,postID=?,commentID=?,reportTime=?,reportStatus=?,reportType=? WHERE reportID = ?";
//	private static final String DELETE_STMT = "DELETE FROM report WHERE reportID = ?";
//	private static final String FIND_BY_PK = "SELECT * FROM report WHERE reportID = ?";
//	private static final String GET_ALL = "SELECT * FROM report";
//
//	static {
//		try {
//			Class.forName(Util.DRIVER);
//		} catch (ClassNotFoundException ce) {
//			ce.printStackTrace();
//		}
//	}
//
//	@Override
//	public void add(Report report) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setInt(1, report.getManageID());
//			
//			pstmt.setObject(2, report.getPostID());
////			if(report.getPostID()!=null) {
////				
////			}
//			pstmt.setInt(3, report.getCommentID());
//			pstmt.setTimestamp(4, report.getReportTime());
//			pstmt.setInt(5, report.getReportStatus());
//			pstmt.setInt(6, report.getReportType());
//
//			
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//
//	}
//
//	@Override
//	public void update(Report report) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(UPDATE_STMT);
//
//			pstmt.setInt(1, report.getManageID());
//			pstmt.setInt(2, report.getPostID());
//			pstmt.setInt(3, report.getCommentID());
//			pstmt.setTimestamp(4, report.getReportTime());
//			pstmt.setInt(5, report.getReportStatus());
//			pstmt.setInt(6, report.getReportType());
//			pstmt.setInt(7, report.getReportID());
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//
//	}
//
//	@Override
//	public void delete(int reportID) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(DELETE_STMT);
//
//			pstmt.setInt(1, reportID);
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//
//	}
//
//	@Override
//	public Report findByPK(Integer reportID) {
//		Report report = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(FIND_BY_PK);
//			pstmt.setInt(1, reportID);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				report = new Report();
//				report.setReportID(rs.getInt("reportID"));
//				report.setManageID(rs.getInt("manageID"));
//				report.setPostID(rs.getInt("postID"));
//				report.setCommentID(rs.getInt("commentID"));
//				report.setReportTime(rs.getTimestamp("reportTime"));
//				report.setReportStatus(rs.getInt("reportStatus"));
//				report.setReportType(rs.getInt("reportType"));
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return report;
//	}
//
//	@Override
//	public List<Report> getAll() {
//		List<Report> reportList = new ArrayList<Report>();
//		Report report = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(GET_ALL);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				report = new Report();
//				report.setReportID(rs.getInt("reportID"));
//				report.setManageID(rs.getInt("manageID"));
//				report.setPostID(rs.getInt("postID"));
//				report.setCommentID(rs.getInt("commentID"));
//				report.setReportTime(rs.getTimestamp("reportTime"));
//				report.setReportStatus(rs.getInt("reportStatus"));
//				report.setReportType(rs.getInt("reportType"));
//				reportList.add(report);
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return reportList;
//	}
//
//}