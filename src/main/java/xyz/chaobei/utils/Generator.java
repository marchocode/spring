package xyz.chaobei.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.nio.file.Paths;
import java.util.Map;

/**
 * @author mrc
 */
public class Generator {

    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://192.168.1.20:3306/test?useSSL=false", "root", "root")
                .globalConfig(builder -> builder
                        .author("mrc")
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                        .commentDate("yyyy-MM-dd")
                        .enableSpringdoc()
                        .dateType(DateType.ONLY_DATE)
                )
                .packageConfig(builder -> builder
                        .parent("xyz.chaobei")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .pathInfo(Map.of(OutputFile.xml, Paths.get(System.getProperty("user.dir")) + "/src/main/resources/mapper"))
                )
                .strategyConfig(builder -> builder
                        .addInclude("tb_user")
                        .entityBuilder().formatFileName("%sDO").enableFileOverride().enableTableFieldAnnotation().addTableFills(new Column("create_time", FieldFill.INSERT),new Column("update_time", FieldFill.INSERT_UPDATE)).enableLombok()
                        .mapperBuilder().enableFileOverride()
                        .serviceBuilder().enableFileOverride()
                        .controllerBuilder().disable()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
