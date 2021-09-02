/*
 * package com.joyandbiz.board.dao;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import javax.sql.DataSource; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.joyandbiz.board.MemberRepository;
 * 
 * @Repository public class MemberJdbc implements MemberRepository{ private
 * Connection conn; private PreparedStatement pstmt; private ResultSet rs;
 * 
 * @Autowired
 * 
 * @Qualifier("dataSource") private DataSource dataSource;
 * 
 * public String getName() throws Exception { String sql = "select * from ITEM";
 * String name = "ERROR"; conn = dataSource.getConnection(); pstmt =
 * conn.prepareStatement(sql);
 * 
 * rs = pstmt.executeQuery();
 * 
 * if(rs.next()) { name = rs.getString("NAME"); } rs.close(); pstmt.close();
 * conn.close();
 * 
 * return name; } }
 */