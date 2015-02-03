package cn.thinkjoy.codegen;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import com.google.common.io.Files;

import java.io.File;


/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
	public static final boolean isStandard = false;
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		
		
		GeneratorFacade g = new GeneratorFacade();
//		g.printAllTableNames();				//打印数据库中的表名称
		
		g.deleteOutRootDir();			//删除生成器的输出目录
//		g.generateByTable("ehr_salary","template/mybatis");	//通过数据库表生成文件,template为模板的根目录
		g.generateByAllTable("template/mybatis");	//自动搜索数据库中的所有表并生成文件,template为模板的根目录
		if(isStandard) {
			g.generateByTableList("template/common");
		}


		if(false) {
			//yq add 进行对应的文件拷贝
			String startupDir = GeneratorProperties.getRequiredProperty("startupDir");
			String autoGenProject = startupDir + "-autogen/managerui-biz-startup";
			String basePackage = GeneratorProperties.getRequiredProperty("basepackage");
			String outRoot = GeneratorProperties.getRequiredProperty("outRoot");
			String module = GeneratorProperties.getRequiredProperty("module");
			String basePackageDir = basePackage.replace(".", "/");

			//domain拷贝
			String parentDirStr = autoGenProject + "/mubs-domain/src/main/java/" + basePackageDir + "/domain";
			File parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			File sourceDir = new File(outRoot + "/" + module + "-domain");
			for (File file : sourceDir.listFiles()) {
				Files.copy(file, new File(parentDirStr + "/" + file.getName()));
			}

			//dao拷贝
			parentDirStr = autoGenProject + "/mubs-service/src/main/java/" + basePackageDir + "/dao";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-service/java");
			for (File file : sourceDir.listFiles()) {
				Files.copy(file, new File(parentDirStr + "/" + file.getName()));
			}


			//mybatis拷贝
			parentDirStr = autoGenProject + "/mubs-service/src/main/resources/mybatis";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-service/resources");
			for (File file : sourceDir.listFiles()) {
				Files.copy(file, new File(parentDirStr + "/" + file.getName()));
			}

			//dubbo拷贝
			parentDirStr = autoGenProject + "/mubs-service/src/main/resources/dubbo";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/dubbo");
			for (File file : sourceDir.listFiles()) {
				Files.copy(file, new File(parentDirStr + "/" + file.getName()));
			}


			//api拷贝
			parentDirStr = autoGenProject + "/mubs-service/src/main/java/" + basePackageDir + "/service";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-api");
			for (File file : sourceDir.listFiles()) {
				if (!file.isDirectory()) {
					Files.copy(file, new File(parentDirStr + "/" + file.getName()));
				}
			}


			//api-impl拷贝
			parentDirStr = autoGenProject + "/mubs-service/src/main/java/" + basePackageDir + "/service/impl";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-api/impl");
			for (File file : sourceDir.listFiles()) {
				Files.copy(file, new File(parentDirStr + "/" + file.getName()));
			}

			//api-test拷贝
			parentDirStr = autoGenProject + "/mubs-service/src/test/java/" + basePackageDir + "/service/impl";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-service/test");
			for (File file : sourceDir.listFiles()) {
				Files.copy(file, new File(parentDirStr + "/" + file.getName()));
			}


			//facade拷贝
			parentDirStr = autoGenProject + "/mubs-service/src/main/java/" + basePackageDir + "/facade";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-facade");
			for (File file : sourceDir.listFiles()) {
				if (!file.isDirectory()) {
					Files.copy(file, new File(parentDirStr + "/" + file.getName()));
				}
			}

			//facade-impl拷贝
			parentDirStr = autoGenProject + "/mubs-service/src/main/java/" + basePackageDir + "/facade/impl";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-facade/impl");
			for (File file : sourceDir.listFiles()) {
				Files.copy(file, new File(parentDirStr + "/" + file.getName()));
			}


			//facade-test拷贝
			parentDirStr = autoGenProject + "/mubs-service/src/test/java/" + basePackageDir + "/facade/impl";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-facade/test");
			for (File file : sourceDir.listFiles()) {
				Files.copy(file, new File(parentDirStr + "/" + file.getName()));
			}

			//war-maps拷贝
			parentDirStr = autoGenProject + "/mubs-admin-war/src/main/java/" + basePackageDir + "/common";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-common");
			for (File file : sourceDir.listFiles()) {
				Files.copy(file, new File(parentDirStr + "/" + file.getName()));
			}

			//war-controller拷贝
			parentDirStr = autoGenProject + "/mubs-admin-war/src/main/java/" + basePackageDir + "/controller";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-controller");
			for (File file : sourceDir.listFiles()) {
				Files.copy(file, new File(parentDirStr + "/" + file.getName()));
			}

			//war-ftl拷贝
			parentDirStr = autoGenProject + "/mubs-admin-war/src/main/webapp/WEB-INF/view/module";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-view");
			for (File file : sourceDir.listFiles()) {
				if (!file.isDirectory()) {
					Files.copy(file, new File(parentDirStr + "/" + file.getName()));
				}
			}

			//war-custome-ftl拷贝
			parentDirStr = autoGenProject + "/mubs-admin-war/src/main/webapp/WEB-INF/view/module/custome";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-view/custome");
			for (File file : sourceDir.listFiles()) {
				if (!file.isDirectory()) {
					Files.copy(file, new File(parentDirStr + "/" + file.getName()));
				}
			}

			//war-custome-script-ftl拷贝
			parentDirStr = autoGenProject + "/mubs-admin-war/src/main/webapp/WEB-INF/view/module/custome/script";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-view/custome/script");
			for (File file : sourceDir.listFiles()) {
				if (!file.isDirectory()) {
					Files.copy(file, new File(parentDirStr + "/" + file.getName()));
				}
			}

			//war-custome-js-ftl拷贝
			parentDirStr = autoGenProject + "/mubs-admin-war/src/main/webapp/WEB-INF/view/module/custome/js";
			parentDir = new File(parentDirStr);
			parentDir.mkdirs();
			sourceDir = new File(outRoot + "/" + module + "-view/custome/js");
			for (File file : sourceDir.listFiles()) {
				if (!file.isDirectory()) {
					Files.copy(file, new File(parentDirStr + "/" + file.getName()));
				}
			}
		}


//		g.generateByAllTable("template/hibernate");
//		g.generateByClass(Blog.class,"template_clazz");
		 
//		g.deleteByTable("table_name", "template"); //删除生成的文件
		//打开文件夹
		//Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));

	}
}
