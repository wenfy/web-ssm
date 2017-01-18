package com.heitian.ssm.service;

import com.heitian.ssm.model.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */
@Repository("RecordService")
public interface RecordService {
    public List<Record> getAll();
    public List<Record> getAllByName(String name);
    public List<Record> getAllById(int id);
    public void insert(Record r);
    public void update(Record r);
    public void delete(int id);
    public Record getById(int id);
    public String getCommentsById(int id);
}
