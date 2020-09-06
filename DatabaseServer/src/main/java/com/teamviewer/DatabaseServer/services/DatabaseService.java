package com.teamviewer.DatabaseServer.services;


import com.teamviewer.DatabaseServer.model.request.DatabaseRequest;
import com.teamviewer.DatabaseServer.repository.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseService {
    //@Autowired
    //DatabaseRepository databaseRepository;
    @Autowired
    private DataSource dataSource;

    public ArrayList<Map<String,String>> process(DatabaseRequest databasemodel) throws SQLException {
        //databasemodel에 roomid, query를 getRoomId(), getQuery()로 가져다쓴다
        Connection con = null;

        Statement stmt = dataSource.getConnection().createStatement();
        String query = databasemodel.getQuery();
        //query에 POST로 얻은 SQL있음

        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();

        //속성 수
        int columnCnt = rsmd.getColumnCount();
        
        //속성 이름들의 리스트
        ArrayList <String> columnnameList = new ArrayList<>();
        
        ArrayList<Map<String, String>> clist = new ArrayList<>();
        
        for(int i = 1; i <= columnCnt; ++i) {
            columnnameList.add(rsmd.getColumnName(i));
        }

        //3번수
        while(rs.next()){
            Map <String, String> ret = new HashMap<>();
            for(int i = 0; i < columnCnt; ++i){
                String colname = columnnameList.get(i);
                System.out.println(colname);

                ret.put(colname, String.valueOf(rs.getObject(colname)));
                
                //리스트나 맵으로 리턴해줘야돼
            }
            clist.add(ret);
        }
        return clist;
    }
}

