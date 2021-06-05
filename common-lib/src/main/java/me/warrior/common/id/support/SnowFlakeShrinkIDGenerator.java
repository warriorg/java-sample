package me.warrior.common.id.support;

import me.warrior.common.id.SnowFlakeShrink;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class SnowFlakeShrinkIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return SnowFlakeShrink.nextId();
    }
}
