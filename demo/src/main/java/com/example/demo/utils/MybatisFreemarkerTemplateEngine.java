package com.example.demo.utils;

import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author hqm
 * @Date 2022/6/9 11:27
 */
public class MybatisFreemarkerTemplateEngine extends FreemarkerTemplateEngine {

        @Override
        public AbstractTemplateEngine batchOutput() {
            System.out.println(" 进子类方法");
            try {
                ConfigBuilder config = this.getConfigBuilder();
                List<TableInfo> tableInfoList = config.getTableInfoList();
                tableInfoList.forEach((tableInfo) -> {
                    Map<String, Object> objectMap = this.getObjectMap(config, tableInfo);
                    Optional.ofNullable(config.getInjectionConfig()).ifPresent((t) -> {
                        t.beforeOutputFile(tableInfo, objectMap);
                    });
                    this.outputEntity(tableInfo, objectMap);
                    this.outputMapper(tableInfo, objectMap);
                    this.outputService(tableInfo, objectMap);
                    this.outputController(tableInfo, objectMap);
                    this.outputVO(tableInfo, objectMap);
                });
                return this;
            } catch (Exception var3) {
                throw new RuntimeException("无法创建文件，请检查配置信息！", var3);
            }
        }

        /**
         * 输出VO文件
         *
         * @param tableInfo 表信息
         * @param objectMap 渲染数据
         * @since 3.0.0
         */
        protected void outputVO(TableInfo tableInfo,  Map<String, Object> objectMap) {
            // VO类名： 实体类+"VO"
            String voName = tableInfo.getEntityName()+"VO";
            // String voPath = this.getPathInfo("entity_path");
            String voPath = "D:\\output\\a\\v\\vo";
            if (StringUtils.isNotBlank(voName) && StringUtils.isNotBlank(voPath)) {
                String entityFile = String.format(voPath + File.separator + "%s" + this.suffixJavaOrKt(), voName);
                this.outputFile(new File(entityFile), objectMap, "/templates/vo.java.vm");
            }
        }



}
