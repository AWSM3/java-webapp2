package com.lanit.webapp2.factory;

import com.lanit.webapp2.dao.DaoInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DaoFactory extends AbstractFactory {
    @Override
    public Object build() {
        throw new UnsupportedOperationException();
    }

    public <T> T build(Class<T> daoClass) throws
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = daoClass.getConstructor();

        return (T) constructor.newInstance();
    }
}
