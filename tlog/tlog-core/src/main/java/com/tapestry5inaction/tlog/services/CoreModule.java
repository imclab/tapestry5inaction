package com.tapestry5inaction.tlog.services;

import com.tapestry5inaction.tlog.entities.Month;
import com.tapestry5inaction.tlog.services.impl.MonthValueEncoder;
import com.tapestry5inaction.tlog.services.impl.SidebarBlockSourceImpl;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.services.ComponentClassResolver;
import org.apache.tapestry5.services.LibraryMapping;
import org.apache.tapestry5.services.ValueEncoderFactory;
import org.apache.tapestry5.services.ValueEncoderSource;

public class CoreModule {

    public static void bind(final ServiceBinder binder) {
        binder.bind(SidebarBlockSource.class, SidebarBlockSourceImpl.class);
    }

    @Contribute(ValueEncoderSource.class)
    public static void contributeValueEncoders(MappedConfiguration<Class, ValueEncoderFactory> configuration) {

        configuration.add(Month.class, new ValueEncoderFactory<Month>() {

            public ValueEncoder<Month> create(Class<Month> type) {
                return new MonthValueEncoder();
            }
        });
    }
}
