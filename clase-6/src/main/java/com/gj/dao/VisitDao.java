package com.gj.dao;
import com.gj.models.Visit;
import com.gj.utils.DBConnection;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.List;

public class VisitDao {
    public void createVisit(@NotNull Visit v) throws SQLException {
        String sql = "INSERT INTO visits (visitor_name, visitor_document, visitor_email, host_name, reason) VALUES (?,?,?,?,?)";
        try (Connection con = DBConnection.get();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, v.getVisitorName());
            ps.setString(2, v.getVisitorDocument());
            if(v.getVisitorEmail() == null) ps.setNull(3, java.sql.Types.VARCHAR); else ps.setString(3, v.getVisitorEmail());
            ps.setString(4, v.getHostName());
            ps.setString(5, v.getReason());
            ps.executeUpdate();
        }
    }

    public int closeVisit(long id) throws SQLException{
        String sql = "UPDATE visits SET visit_exit = NOW() WHERE id = ? AND visit_exit IS NULL";
        try (Connection con = DBConnection.get();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate();
        }
    }
    private List<Visit> mapAll(ResultSet rs) throws SQLException {
        List<Visit> visits = new java.util.ArrayList<>();
        while (rs.next()) {
            Visit v = new Visit();
            v.setId(rs.getLong("id"));
            v.setVisitorName(rs.getString("visitor_name"));
            v.setVisitorDocument(rs.getString("visitor_document"));
            v.setVisitorEmail(rs.getString("visitor_email"));
            v.setHostName(rs.getString("host_name"));
            v.setReason(rs.getString("reason"));

            Timestamp entry = rs.getTimestamp("visit_entry");
            Timestamp exit = rs.getTimestamp("visit_exit");
            if (entry != null) v.setVisitEntry(entry.toLocalDateTime());
            if (exit != null) v.setVisitExit(exit.toLocalDateTime());

            visits.add(v);
        }
        return visits;
    }

    public List<Visit> listall() throws SQLException{
        String sql = "SELECT id, visitor_name, visitor_document, visitor_email, host_name, reason, visit_entry, visit_exit FROM visits " +
                "ORDER BY visit_entry DESC";
        try (Connection con = DBConnection.get();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return mapAll(rs);
        }
    }

    public List<Visit> listToday() throws SQLException{
        String sql = "SELECT id, visitor_name, visitor_document, visitor_email, host_name, reason, visit_entry, visit_exit FROM visits " +
                "WHERE visit_entry::date = CURRENT_DATE ORDER BY visit_entry DESC";
        try (Connection con = DBConnection.get();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return mapAll(rs);
        }
    }

    public List<Visit> listActive() throws SQLException{
        String sql = "SELECT id, visitor_name, visitor_document, visitor_email, host_name, reason, visit_entry, visit_exit FROM visits " +
                "WHERE visit_exit IS NULL ORDER BY visit_entry DESC";
        try (Connection con = DBConnection.get();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            return mapAll(rs);
        }
    }



}
