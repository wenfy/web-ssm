package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.RecordDao;
import com.heitian.ssm.model.Record;
import com.heitian.ssm.service.RecordService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by w-fy on 2017/1/11.
 */
@Repository("RecordServiceImp")
public class RecordServiceImpl implements RecordService{
    @Resource(name="RecordDao")
    RecordDao recordDao;

    public List<Record> getAll() {
        return recordDao.getAll();
    }

    public List<Record> getAllByName(String name) {
        return recordDao.getAllByName(name);
    }

    public List<Record> getAllById(int id) {
        return recordDao.getAllById(id);
    }

    public void insert(Record r) {
        recordDao.insert(r);
    }

    public void update(Record r) {
        recordDao.update(r);

    }

    public void delete(int id) {
        recordDao.delete(id);

    }

    public Record getById(int id) {
        return recordDao.getById(id);
    }

    public String getCommentsById(int id) {
        return recordDao.getCommentsById(id);
    }


}
