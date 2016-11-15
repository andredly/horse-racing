package com.charniauski.training.horsesrace.daoxml.impl;

import com.charniauski.training.horsesrace.daoapi.GenericDao;
import com.charniauski.training.horsesrace.datamodel.AbstractModel;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ivc4 on 21.10.2016.
 */
@Repository
public abstract class AbstractDao<T extends AbstractModel, PK> implements GenericDao<T, PK> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDao.class);

    @Inject
    private XStream xstream;

    private File file;

    private final Class<T> clazz;

    @Value("${basePath}")
    private String basePath;

    public String getBasePath() {
        return basePath;
    }

    @SuppressWarnings("unchecked")
    protected AbstractDao() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @PostConstruct
    private void initialize() throws IOException {
        xstream = new XStream();
        xstream.alias(clazz.getSimpleName(), clazz);
        File dir = new File(basePath);
        if (!dir.exists()){dir.mkdir();}
        this.file = new File(basePath + "/" + clazz.getSimpleName() + ".xml");
        if (!this.file.exists()) {
            this.file.createNewFile();
            xstream.toXML(new ArrayList<>(), new FileOutputStream(this.file));
        }
        initSequence();
    }

    @Override
    public T get(PK id) {
        List<T> entities = readCollection();
        for (T entity : entities) {
            if (entity.getId().equals(id)) {
                return entity;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PK insert(T entity) {
        List<T> entities = readCollection();
        Long id = (Long) next();
//        Long id = getNextId(entities);
        entities.add(entity);
        entity.setId(id);
        writeCollection(entities);
        return (PK) id;
    }

    @Override
    public Integer update(T entity) {
        List<T> list = readCollection();
        for (int i = 0; i < list.size(); i++) {
            if (entity.getId().equals(list.get(i).getId())) {
                list.set(i, entity);
                writeCollection(list);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public boolean delete(PK id) {
        List<T> list = readCollection();
        Iterator<T> iterator = list.iterator();
        boolean isDelete = false;
        while (iterator.hasNext()){
            if (!iterator.next().getId().equals(id)) {
                iterator.remove();
                isDelete = true;
                continue;}
        }
        writeCollection(list);
        return isDelete;
    }

    @Override
    public List<T> getAll() {
        return readCollection();
    }

    @SuppressWarnings("unchecked")
    List<T> readCollection() {
        return new ArrayList<>((List<T>) xstream.fromXML(file));
    }

    private void writeCollection(List<T> newList) {
        try {
            xstream.toXML(newList, new BufferedOutputStream(new FileOutputStream(file)));

        } catch (FileNotFoundException e) {
            throw new NoSuchElementException();
        }
    }

//    private long getNextId(List<T> list) {
//        return list.isEmpty() ? 1l : list.get(
//                list.size() - 1).getId() + 1;
//    }

    XStream getXstream() {
        return xstream;
    }

    private void initSequence() {
        List<T> list = readCollection();
        Long maxId = 0L;
        if (!list.isEmpty()) {
            maxId = list.get(list.size() - 1).getId() + 1;
        }
        getSequence().set(maxId);
    }

    abstract AtomicLong getSequence();

    abstract PK next();
}
