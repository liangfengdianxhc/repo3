package com.hegong.dao;

import com.hegong.domain.Classify;
import com.hegong.domain.Commodity;
import com.hegong.domain.User;
import com.hegong.domain.YouLike;
import com.hegong.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlowerDao {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection connection;
    public List<Classify> selectAll(){
        String sql = "select * from classify";
        List<Classify> classifies = new ArrayList<>();
        connection = JDBCUtils.getConnection();
        try {

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Classify c = new Classify();
                c.setId(rs.getInt("id"));
                c.setC_name(rs.getString("c_name"));
                c.setContent(rs.getString("content"));
                c.setImg_url(rs.getString("img_url"));
                c.setMoney(rs.getDouble("money"));
                classifies.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,connection);
        }
        return classifies;
    }

    public int selectCount(int key) {
        connection = JDBCUtils.getConnection();
        int i = -1;
        String sql = "SELECT COUNT(*) AS a FROM userbuycar GROUP BY shop_id HAVING shop_id = "+key+"";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()){
                String str_i = rs.getString("a");
                i = Integer.parseInt(str_i);
            }

        } catch (SQLException throwables) {
                throwables.printStackTrace();
        }finally {
                JDBCUtils.close(rs,ps,connection);
        }
        return i;
    }

    public List<Classify> selectOnes(String key) {
        connection = JDBCUtils.getConnection();
        String sql = "select * from classify where c_name = ?";
        List<Classify> classifies = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,key);
            rs = ps.executeQuery();
            while (rs.next()){
                Classify c = new Classify();
                c.setId(rs.getInt("id"));
                c.setC_name(rs.getString("c_name"));
                c.setContent(rs.getString("content"));
                c.setImg_url(rs.getString("img_url"));
                c.setMoney(rs.getDouble("money"));
                classifies.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,connection);
        }
        return classifies;
    }

    /**
     * 查询youlike表中的所有数据
     * @return
     */
    public List<YouLike> selectLikeAll() {
        String sql = "select * from youlike";
        List<YouLike> youLikes = new ArrayList<>();
        connection = JDBCUtils.getConnection();
        try {

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                YouLike c = new YouLike();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setImgUrl(rs.getString("imgUrl"));
                c.setPrice(rs.getInt("price"));
                youLikes.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,connection);
        }
        return youLikes;
    }


    /**
     * 统计总共有几类商品
     * @return
     */
    public int typesCount() {
        connection = JDBCUtils.getConnection();
        int i = -1;
        String sql = "SELECT COUNT(*) AS a FROM userbuycar GROUP BY shop_imgUrl";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()){
                String str_i = rs.getString("a");
                i = Integer.parseInt(str_i);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,connection);
        }
        return i;
    }

    public List<Commodity> getCommodityList() {
        List<Commodity> commodities = new ArrayList<>();
        String sql = "SELECT DISTINCT shop_id,shopname,shop_price,shop_imgUrl FROM userbuycar";
        connection = JDBCUtils.getConnection();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Commodity commodity = new Commodity();
                commodity.setId(rs.getInt("shop_id"));
                commodity.setName(rs.getString("shopname"));
                commodity.setImgUrl(rs.getString("shop_imgUrl"));
                commodity.setPrice(rs.getInt("shop_price"));
                commodities.add(commodity);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,connection);
        }
        return commodities;


    }

    public User seletcUser(String username) {
        int i  = -1;
        connection = JDBCUtils.getConnection();
        String sql = "SELECT * FROM `user` WHERE username = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setUsername(resultSet.getString("username"));
                u.setPwd(resultSet.getString("pwd"));
                return u;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(rs,ps,connection);
        }
        return null;
    }
}
