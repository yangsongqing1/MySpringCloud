package ysq.com.client.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import net.logstash.logback.decorate.JsonFactoryDecorator;

/**
 * @Describle:
 * @Author: yangsongqing
 * @Date: 2017/12/5 17:16
 */
public class LogJsonFactoryDecorator implements JsonFactoryDecorator {
    @Override
    public MappingJsonFactory decorate(MappingJsonFactory factory) {
        // 禁用对非ascii码进行escape编码的特性的kibana上正常显示中文
        factory.disable(JsonGenerator.Feature.ESCAPE_NON_ASCII);
        return factory;
    }
}
