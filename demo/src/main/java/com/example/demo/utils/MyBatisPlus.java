package com.example.demo.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author hqm
 * @Date 2022/5/27 13:26
 */
public class MyBatisPlus {
    public static void main(String[] args) {
        FastAutoGenerator.create(
                        new DataSourceConfig.Builder("jdbc:mysql://192.168.1.200:3306/reagent?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&autoReconnect=true", "root", "Ruobo_2022"))
                // 全局配置
                .globalConfig((scanner, builder) -> builder
                        // 交互式作用名称
                        .author(scanner.apply("请输入作者名称？"))
//                         .author("hqm")
                        .fileOverride()
                        // 开启swagger模式
                        .enableSwagger()
                        // 输出位置
                        .outputDir("D:\\workspace\\demo\\src\\main\\java"))
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？"))
                        .service("service")
                        .serviceImpl("service.Impl")
                        .mapper("mapper")
                        .xml("mapper")
                        .entity("entity")
                )

                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok()
                        // 下划线转驼峰命名
                        .columnNaming(NamingStrategy.underline_to_camel)
                        .addTableFills(
                                new Column("update_time", FieldFill.INSERT_UPDATE))
                        .addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build())

                .templateConfig((scanner, builder) -> getTemplateConfig())

                .execute();
    }

    public static TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .entity("/templates/entity.java.vm")
                .service("/templates/service.java.vm")
                .serviceImpl("/templates/serviceImpl.java.vm")
                .mapper("/templates/mapper.java.vm")
                .mapperXml("/templates/mapper.xml.vm")
                .controller("/templates/controller.java.vm")
                .build();
        return templateConfig;
    }


    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
