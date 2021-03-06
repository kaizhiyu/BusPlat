package com.zhiyin.dbs.generator;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据工程信息生成mybatis的配置文件
 * 配置信息在：generator-config.properties
 * Created by hg on 2016/11/11.
 */
@Slf4j
public class GenMybatisFlie {



    // xml配置文件在resources下面.
    public static String genGeneratorConfig( ) {
        return genGeneratorConfig("mysql-base-generator-config.xml");
    }


    // xml配置文件在resources下面.
    public static String genGeneratorConfig2( ) {
        return genGeneratorConfig("mysql-base-generator-config2.xml");
    }



    public static String genGeneratorConfig(String fileName) {
        Parameters params = new Parameters();

        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(GeneratorConstant.GenConfigProperName));
        try {
            Configuration config = builder.getConfiguration();
            List<String> mapperList = config.getList(String.class, "table.entity.mapper");
            mapperList = Optional.fromNullable(mapperList).or(new ArrayList<String>());

            log.info("table entity mapper size:{}",mapperList.size());

            if(mapperList.size() <= 0){
                return null;
            }

            List<String > appendList = Lists.newArrayList();
            for(String tmp : mapperList){
                String[] mp = tmp.trim().split(",");
                if(mp.length != 2){
                    log.error("table entity not valid,{}",tmp);
                    return null ;
                }
                appendList.add(" <table tableName=\""+mp[0]+"\" domainObjectName=\""+mp[1]+"\"/>");
            }
//            List<String> lines = FileUtils.readLines( new File("/mysql-base-generator-config.xml") );

            List<String> lines = IOUtils.readLines( GenMybatisFlie.class.getResourceAsStream("/" + fileName) );
            lines.addAll(lines.size()-3,appendList);
            File saveFile = new File(config.getString("project.name") + "/generator-config-" + config.getString("project.name") + ".xml");
            log.info("project mybatis config file path is:{}",saveFile.getAbsolutePath());
            FileUtils.writeLines(saveFile,lines);
            return saveFile.getAbsolutePath();
        } catch (ConfigurationException cex) {
            // loading of the configuration file failed
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static void genMybatis(String path) {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = false;
            ConfigurationParser cp = new ConfigurationParser(warnings);
            org.mybatis.generator.config.Configuration config = cp.parseConfiguration(new File(path));
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
